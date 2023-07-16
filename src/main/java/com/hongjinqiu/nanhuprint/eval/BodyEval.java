package com.hongjinqiu.nanhuprint.eval;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.NanhuprintException;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.NanhuprintFont;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.eval.custom.ExtendToFillBodyEval;
import com.hongjinqiu.nanhuprint.eval.explain.ExplainUtil;
import com.hongjinqiu.nanhuprint.event.BackgroundImageVO;
import com.hongjinqiu.nanhuprint.event.NanhuprintBodyImageEvent;
import com.hongjinqiu.nanhuprint.event.NanhuprintBodyWaterMark;
import com.hongjinqiu.nanhuprint.event.WaterMarkVO;
import com.hongjinqiu.nanhuprint.model.Body;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * com.hongjinqiu.nanhuprint.model.Body 的解析类
 */
public class BodyEval extends AbstractEval {
	private String childKey = "ifAndForEachAndSet";

	@Override
	public String getChildKey() {
		return childKey;
	}

	/**
	 * 解析所有的 if,forEach,set,spring el 等动态标签,生成 xml,
	 *
	 * @param metaObj
	 * @param env
	 * @param expressionEvaluator
	 * @return
	 */
	@Override
	public String evalDynamicElement(Object metaObj, Map<String, Object> env, NanhuprintExpressionEvaluator expressionEvaluator) {
		Body body = (Body) metaObj;
		return EvalUtil.commonEvalDynamicElement("body", metaObj, body.getIfAndForEachAndSet(), env, expressionEvaluator);
	}

	/**
	 * id 与 parentId 映射关系赋值
	 *
	 * @param metaObj
	 * @param parentObj
	 */
	@Override
	public void setIdAndParentId(Object metaObj, Object parentObj) {
		String parentId = null;// body 的父元素为 html, html 标签没 id,
		EvalUtil.commonSetIdAndParentId(metaObj, parentId);
		Map<String, String> keyIdValueParentIdMap = NanhuprintThreadLocal.getKeyIdValueParentIdMap();
		keyIdValueParentIdMap.put(NanhuprintConstant.NANHUPRINT_BODY_ID_KEY, ((Body)metaObj).getId());
	}

	/**
	 * 设置id,宽度映射,由 html 中传入,
	 * @param metaObj
	 */
	@Override
	public void setContentWidth(Object metaObj, float[] absoluteWidths, int[][] rowColumnFlag) {
		Body body = (Body)metaObj;
		Rectangle rectangle = getPageSize(body);
		float bodyWidth = rectangle.getWidth();
		float marginLeft = getMargin(body, NanhuprintConstant.PADDING_LEFT);
		float marginRight = getMargin(body, NanhuprintConstant.PADDING_RIGHT);
		float bodyContentWidth = bodyWidth - marginLeft - marginRight;

		float[] bodyAbsoluteWidths = new float[]{bodyContentWidth};
		int[][] bodyRowColumnFlag = new int[][]{
			new int[]{0}
		};
		NanhuprintThreadLocal.getContentWidthMap().put(body.getId(), bodyContentWidth);
		EvalUtil.loopSetContentWidth(metaObj, bodyAbsoluteWidths, bodyRowColumnFlag, body.getIfAndForEachAndSet());
	}

	/**
	 * id 与 metaObj 的映射
	 *
	 * @param metaObj
	 */
	@Override
	public void setIdAndMetaObj(Object metaObj) {
		EvalUtil.commonSetIdAndMetaObj(metaObj);
	}

	/**
	 * 将 xml 元素解析并输出 pdf,
	 *
	 * @param metaObj
	 * @param env
	 * @return
	 */
	public List<Element> evalToPdf(String filePath, Object metaObj, Map<String, Object> env) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
			evalToPdf(out, metaObj, env);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		} finally {
			IOUtils.closeQuietly(out);
		}

		return new ArrayList<>();
	}

	/**
	 * 将 xml 元素解析并输出 pdf,
	 * @param out
	 * @param metaObj
	 * @param env
	 */
	public void evalToPdf(OutputStream out, Object metaObj, Map<String, Object> env) {
		Body body = (Body) metaObj;
		ExplainUtil.addExplain(metaObj, "===================== body(id:" + body.getId() + ") explain begin =====================");
		Document document = getDocument(body);

		PdfWriter pdfWriter = null;
		boolean hasException = false;
		try {
			// pdf写入对象
			pdfWriter = PdfWriter.getInstance(document, out);
			// body 的背景支持
			setBodyBackgroundImageEvent(pdfWriter, body);
			// body 的水印支持
			setWaterMarkEvent(pdfWriter, body);

			document.open();

			String extendValue = EvalUtil.getParamValue(body.getIfAndForEachAndSet(), NanhuprintConstant.EXTEND_TO_FILL_BODY);
			if (StringUtils.isNotEmpty(extendValue) && extendValue.equalsIgnoreCase(NanhuprintConstant.EXTEND_TO_FILL_BODY_VALUE_DEFAULT)) {
				ExplainUtil.addExplain(metaObj, "使用参数 extendToFillBody,使得每页固定表头表尾,并进行表身空白行填充");
				extendToFillBodyEvalToPdf(document, body, env);
			} else {
				normalEvalToPdf(document, body, env);
			}
		} catch (Exception e) {
			hasException = true;
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		} finally {
			// 发生异常时,document.close 通常会报错,此时又会抛出异常,从而掩盖真正的异常,因此,发生异常时,做一个 try, catch,
			if (hasException) {
				try {
					document.close();
					if (pdfWriter != null) {
						pdfWriter.close();
					}
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			} else {
				document.close();
				if (pdfWriter != null) {
					pdfWriter.close();
				}
			}
		}
		ExplainUtil.addExplain(metaObj, "===================== body(id:" + body.getId() + ") explain end =====================");
		ExplainUtil.outputExplain(body.getId());
	}

	/**
	 * 设置水印
	 * @param pdfWriter
	 * @param body
	 */
	private void setWaterMarkEvent(PdfWriter pdfWriter, Body body) {
		// 水印
		String waterMark = EvalUtil.getParamValue(body.getIfAndForEachAndSet(), NanhuprintConstant.NANHUPRINT_WATER_MARK);
		if (StringUtils.isNotEmpty(waterMark) && waterMark.equalsIgnoreCase(NanhuprintConstant.NANHUPRINT_WATER_MARK_VALUE_DEFAULT)) {

			WaterMarkVO waterMarkVO = EvalUtil.getWaterMarkVO(body);
			NanhuprintBodyWaterMark nanhuprintBodyWaterMark = new NanhuprintBodyWaterMark(waterMarkVO);
			pdfWriter.setPageEvent(nanhuprintBodyWaterMark);
            ExplainUtil.addExplain(body, "添加水印,使用NanhuprintWaterMark 生成水印,字体:fontFamilyname" + waterMarkVO.getFont().getFamilyname() + ", style:" + waterMarkVO.getFont().getStyle());
        }
	}

	/**
	 * 设置背景图,
	 */
	private void setBodyBackgroundImageEvent(PdfWriter pdfWriter, Body body) {
		String attributeValue = EvalUtil.getCssAttribute(body, NanhuprintConstant.BACKGROUND_IMAGE);
		if (org.apache.commons.lang3.StringUtils.isNotEmpty(attributeValue)) {
			// url('http://xxxx')
			try {
				Pattern pattern = Pattern.compile("url\\(['\"]?(.*?)['\"]?\\)", Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(attributeValue);
				if (matcher.find()) {
					String urlText = matcher.group(1);

					BackgroundImageVO backgroundImageVO = new BackgroundImageVO();
					backgroundImageVO.setImg(Image.getInstance(new URL(urlText)));
					backgroundImageVO.setBackgroundSize(EvalUtil.getCssAttribute(body, NanhuprintConstant.BACKGROUND_SIZE));
					backgroundImageVO.setBackgroundPositionX(EvalUtil.getCssAttribute(body, NanhuprintConstant.BACKGROUND_POSITION_X));
					backgroundImageVO.setBackgroundPositionY(EvalUtil.getCssAttribute(body, NanhuprintConstant.BACKGROUND_POSITION_Y));
					backgroundImageVO.setBackgroundImageOpacityByPdf(EvalUtil.getCssAttribute(body, NanhuprintConstant.BACKGROUND_IMAGE_OPACITY_BY_PDF));

					pdfWriter.setPageEvent(new NanhuprintBodyImageEvent(backgroundImageVO));
				}
			} catch (MalformedURLException e) {
				logger.error(e.getMessage(), e);
//					throw new NanhuprintException(e);
			} catch (BadElementException e) {
				logger.error(e.getMessage(), e);
//					throw new NanhuprintException(e);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
//					throw new NanhuprintException(e);
			}
		}
	}

	/**
	 * 固定表头,表身填充,固定表尾的 pdf 解析生成方法
	 * @param document
	 * @param body
	 * @param env
	 * @throws DocumentException
	 */
	private void extendToFillBodyEvalToPdf(Document document, Body body, Map<String, Object> env) throws DocumentException {
		List<Element> elements = new ExtendToFillBodyEval().evalToPdf(document, body, env);
		if (elements == null || elements.size() == 0) {
            document.add(new Paragraph("no element"));
        } else {
            for (int i = 0; i < elements.size(); i++) {
                document.add(elements.get(i));
                if (i < (elements.size() - 1)) {
                	document.newPage();
				}
            }
        }
	}

	/**
	 * 普通的生成 pdf 方法
	 * @param document
	 * @param body
	 * @param env
	 * @throws DocumentException
	 */
	private void normalEvalToPdf(Document document, Body body, Map<String, Object> env) throws DocumentException {
		boolean hasElement = false;
		if (body.getIfAndForEachAndSet() != null && body.getIfAndForEachAndSet().size() > 0) {
            EvalFactory evalFactory = new EvalFactory();
            for (Object obj: body.getIfAndForEachAndSet()) {
                IEval evalImplment = evalFactory.routeEval(obj);
                List<Element> elements = evalImplment.evalToPdf(obj, env);
                if (elements != null && elements.size() > 0) {
                    for (Element element: elements) {
                        document.add(element);
                        hasElement = true;
                    }
                }
            }
        }
		if (!hasElement) {// 空元素时,加一个 empty,避免报错
            document.add(new Paragraph("no element"));
        }
	}


	/**
	 * 根据各种属性,返回 Document,
	 * body 的取值,用 padding, 而不用 margin, 因为 iText 的大部分元素只支持 paddig, 不支持 margin,
	 * 因此,统一取值 padding
	 *
	 * @param body
	 * @return
	 */
	private Document getDocument(Body body) {
		float marginLeft = getMargin(body, NanhuprintConstant.PADDING_LEFT);			// 取 PADDING_LEFT, 而不用 MARGIN_LEFT, 下同,取对应的 PADDING 值,而不用 MARGIN
		float marginRight = getMargin(body, NanhuprintConstant.PADDING_RIGHT);
		float marginTop = getMargin(body, NanhuprintConstant.PADDING_TOP);
		float marginBottom = getMargin(body, NanhuprintConstant.PADDING_BOTTOM);
		Document document = new Document(getPageSize(body), marginLeft, marginRight, marginTop, marginBottom);

		return document;
	}

	/**
	 * 将字体设到 threadLocal 的 map 里面,
	 * fontStyle:
	 * html:normal|italic
	 * fontWeight:
	 * html:normal|bold
	 * pdf中的值为:NORMAL|BOLD|ITALIC|BOLDITALIC
	 * fontSize
	 * fontFamily
	 */
	@Override
	public void setFontToMap(Object metaObj) {
//		Font parentFont = NanhuprintThreadLocal.getFontMap().get(NanhuprintFont.ARIAL_FONT_KEY);
		Font parentFont = null;
		try {
			parentFont = new Font(BaseFont.createFont());
		} catch (DocumentException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e.getMessage(), e);
		}
		Font thisFont = parentFont;

		EvalUtil.commonSetFontToMap(metaObj, thisFont);
	}

	/**
	 * 取得 margin 的值
	 *
	 * @param body
	 * @param marginDirection marginLeft|marginTop|marginRight|marginBottom
	 * @return
	 */
	private float getMargin(Body body, String marginDirection) {
		String margin = EvalUtil.getCssAttribute(body, marginDirection);
		if (StringUtils.isEmpty(margin)) {
			return 0;
		}
		return EvalUtil.getPrefixFloatValue(margin);
	}

	/**
	 * 取得 document 的 pageSize
	 *
	 * @param body
	 * @return
	 */
	private Rectangle getPageSize(Body body) {
		boolean isRotate = NanhuprintConstant.ROTATE_VALUE_TRUE.equalsIgnoreCase(body.getRotate());
		if (StringUtils.isEmpty(body.getPageSizePdf())) {
			if (isRotate) {
				return PageSize.A4.rotate();
			} else {
				return PageSize.A4;
			}
		}
		Map<String, Rectangle> map = new HashMap<String, Rectangle>() {
			{
				put("A0", PageSize.A0);
				put("A1", PageSize.A1);
				put("A2", PageSize.A2);
				put("A3", PageSize.A3);
				put("A4", PageSize.A4);
				put("A5", PageSize.A5);
				put("A6", PageSize.A6);
				put("A7", PageSize.A7);
				put("A8", PageSize.A8);
				put("A9", PageSize.A9);
				put("A10", PageSize.A10);
			}
		};
		if (map.get(body.getPageSizePdf()) != null) {
			if (isRotate) {
				return map.get(body.getPageSizePdf()).rotate();
			} else {
				return map.get(body.getPageSizePdf());
			}
		}
		throw new NanhuprintException("can't found pageSize for body tag, pageSize is:" + body.getPageSizePdf());
	}

	//public static void main(String[] args) {
	//	BodyEval bodyEval = new BodyEval();
	//	Body body = new Body();
	//	{
	//		body.setPaddingLeft("35px;");
	//		float marginLeft = bodyEval.getMargin(body, NanhuprintConstant.PADDING_LEFT);
	//		System.out.println(marginLeft);
	//	}
	//	{
	//		body.setPaddingLeft("A35px;");
	//		float marginLeft = bodyEval.getMargin(body, NanhuprintConstant.PADDING_LEFT);
	//		System.out.println(marginLeft);
	//	}
	//	{
	//		body.setPaddingLeft("3%;");
	//		float marginLeft = bodyEval.getMargin(body, NanhuprintConstant.PADDING_LEFT);
	//		System.out.println(marginLeft);
	//	}
	//}
}

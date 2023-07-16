package com.hongjinqiu.nanhuprint.eval;

import com.hongjinqiu.nanhuprint.NanhuprintException;
import com.hongjinqiu.nanhuprint.model.*;

/**
 * 工厂类,
 * 对 JAXBContext 返回的对象中的各个数据类型,返回其对应的执行器
 *
 * @author hongjinqiu 2018.08.03
 */
public class EvalFactory {
	/**
	 * 路由分发方法,根据 metaObj 的类型,返回对应的解析类
	 *
	 * @param metaObj
	 * @return
	 */
	public IEval routeEval(Object metaObj) {
		if (metaObj instanceof Html) {
			return new HtmlEval();
		}
		if (metaObj instanceof Style) {
			return new StyleEval();
		}
		if (metaObj instanceof Body) {
			return new BodyEval();
		}
		if (metaObj instanceof Div) {
			return new DivEval();
		}
		if (metaObj instanceof Table) {
			return new TableEval();
		}
		if (metaObj instanceof Thead) {
			return new TheadEval();
		}
		if (metaObj instanceof Tbody) {
			return new TbodyEval();
		}
		if (metaObj instanceof Tloop) {
			return new TloopEval();
		}
		if (metaObj instanceof Tbottom) {
			return new TbottomEval();
		}
		if (metaObj instanceof Tr) {
			return new TrEval();
		}
		if (metaObj instanceof Td) {
			return new ThTdEval();
		}
		if (metaObj instanceof Th) {
			return new ThTdEval();
		}
		if (metaObj instanceof Span) {
			return new SpanEval();
		}
		if (metaObj instanceof Params) {
			return new ParamsEval();
		}
		if (metaObj instanceof Param) {
			return new ParamEval();
		}
		/*
		if (metaObj instanceof Img) {
			return new ImgEval();
		}
		*/
		if (metaObj instanceof If) {
			return new IfEval();
		}
		if (metaObj instanceof ForEach) {
			return new ForEachEval();
		}
		if (metaObj instanceof Set) {
			return new SetEval();
		}
		if (metaObj instanceof Css) {
			return new CssEval();
		}
		if (metaObj instanceof Macros) {
			return new MacrosEval();
		}
		if (metaObj instanceof Macro) {
			return new MacroEval();
		}
		if (metaObj instanceof MacroRef) {
			return new MacroRefEval();
		}
		if (isCssElement(metaObj)) {
			return new CssElementEval();
		}
		throw new NanhuprintException("can't found Eval, metaObj is:" + metaObj);
	}

	/**
	 * 取得对应的 metaObj 的子元素字段名,
	 * @param metaObj
	 * @return
	 */
	public String getChildKey(Object metaObj) {
		if (metaObj instanceof Html) {
			return new HtmlEval().getChildKey();
		}
		if (metaObj instanceof Style) {
			return new StyleEval().getChildKey();
		}
		if (metaObj instanceof Body) {
			return new BodyEval().getChildKey();
		}
		if (metaObj instanceof Div) {
			return new DivEval().getChildKey();
		}
		if (metaObj instanceof Table) {
			return new TableEval().getChildKey();
		}
		if (metaObj instanceof Thead) {
			return new TheadEval().getChildKey();
		}
		if (metaObj instanceof Tbody) {
			return new TbodyEval().getChildKey();
		}
		if (metaObj instanceof Tloop) {
			return new TloopEval().getChildKey();
		}
		if (metaObj instanceof Tbottom) {
			return new TbottomEval().getChildKey();
		}
		if (metaObj instanceof Tr) {
			return new TrEval().getChildKey();
		}
		if (metaObj instanceof Td) {
			return new ThTdEval().getChildKey();
		}
		if (metaObj instanceof Th) {
			return new ThTdEval().getChildKey();
		}
		if (metaObj instanceof Span) {
			return new SpanEval().getChildKey();
		}
		if (metaObj instanceof Params) {
			return new ParamsEval().getChildKey();
		}
		if (metaObj instanceof Param) {
			return new ParamEval().getChildKey();
		}
		/*
		if (metaObj instanceof Img) {
			return new ImgEval().getChildKey();
		}
		*/
		if (metaObj instanceof If) {
			return new IfEval().getChildKey();
		}
		if (metaObj instanceof ForEach) {
			return new ForEachEval().getChildKey();
		}
		if (metaObj instanceof Set) {
			return new SetEval().getChildKey();
		}
		if (metaObj instanceof Css) {
			return new CssEval().getChildKey();
		}
		if (metaObj instanceof Macros) {
			return new MacrosEval().getChildKey();
		}
		if (metaObj instanceof Macro) {
			return new MacroEval().getChildKey();
		}
		if (metaObj instanceof MacroRef) {
			return new MacroRefEval().getChildKey();
		}
		if (isCssElement(metaObj)) {
			return new CssElementEval().getChildKey();
		}
		throw new NanhuprintException("can't found Eval, metaObj is:" + metaObj);
	}

	/**
	 * 是否是 css 样式元素
	 * @param metaObj
	 * @return
	 */
	public boolean isCssElement(Object metaObj) {
		if (metaObj instanceof Macro.BackgroundColor) {
			return true;
		}
		if (metaObj instanceof Macro.BackgroundImage) {
			return true;
		}
		if (metaObj instanceof Macro.BackgroundImageOpacityByPdf) {
			return true;
		}
		if (metaObj instanceof Macro.BackgroundPositionX) {
			return true;
		}
		if (metaObj instanceof Macro.BackgroundPositionY) {
			return true;
		}
		/*if (metaObj instanceof Macro.BackgroundRepeat) {
			return true;
		}*/
		if (metaObj instanceof Macro.BackgroundSize) {
			return true;
		}
		if (metaObj instanceof Macro.BorderBottomColor) {
			return true;
		}
		/*if (metaObj instanceof Macro.BorderStyle) {
			return true;
		}*/
		if (metaObj instanceof Macro.BorderBottomStyle) {
			return true;
		}
		if (metaObj instanceof Macro.BorderBottomWidth) {
			return true;
		}
		if (metaObj instanceof Macro.TextDecoration) {
			return true;
		}
		if (metaObj instanceof Macro.BorderCollapse) {
			return true;
		}
		if (metaObj instanceof Macro.BorderLeftColor) {
			return true;
		}
		if (metaObj instanceof Macro.BorderLeftStyle) {
			return true;
		}
		if (metaObj instanceof Macro.BorderLeftWidth) {
			return true;
		}
		if (metaObj instanceof Macro.BorderRightColor) {
			return true;
		}
		if (metaObj instanceof Macro.BorderRightStyle) {
			return true;
		}
		if (metaObj instanceof Macro.BorderRightWidth) {
			return true;
		}
		if (metaObj instanceof Macro.BorderSpacing) {
			return true;
		}
		if (metaObj instanceof Macro.BorderTopColor) {
			return true;
		}
		if (metaObj instanceof Macro.BorderTopStyle) {
			return true;
		}
		if (metaObj instanceof Macro.BorderTopWidth) {
			return true;
		}
		if (metaObj instanceof Macro.Bottom) {
			return true;
		}
		if (metaObj instanceof Macro.BoxSizing) {
			return true;
		}
		if (metaObj instanceof Macro.Clear) {
			return true;
		}
		if (metaObj instanceof Macro.Color) {
			return true;
		}
		if (metaObj instanceof Macro.Display) {
			return true;
		}
		if (metaObj instanceof Macro.FloatAlign) {
			return true;
		}
		if (metaObj instanceof Macro.FontFamily) {
			return true;
		}
		if (metaObj instanceof Macro.FontSize) {
			return true;
		}
		if (metaObj instanceof Macro.FontStyle) {
			return true;
		}
		if (metaObj instanceof Macro.FontWeight) {
			return true;
		}
		if (metaObj instanceof Macro.Height) {
			return true;
		}
		if (metaObj instanceof Macro.Left) {
			return true;
		}
		if (metaObj instanceof Macro.LineHeight) {
			return true;
		}
		if (metaObj instanceof Macro.MarginBottomByJs) {
			return true;
		}
		if (metaObj instanceof Macro.MarginLeftByJs) {
			return true;
		}
		if (metaObj instanceof Macro.MarginRightByJs) {
			return true;
		}
		if (metaObj instanceof Macro.MarginTopByJs) {
			return true;
		}
		if (metaObj instanceof Macro.TransformByJs) {
			return true;
		}
		if (metaObj instanceof Macro.OpacityByJs) {
			return true;
		}
		if (metaObj instanceof Macro.ZIndexByJs) {
			return true;
		}
		if (metaObj instanceof Macro.BackgroundRepeatByJs) {
			return true;
		}
		if (metaObj instanceof Macro.MaxHeight) {
			return true;
		}
		if (metaObj instanceof Macro.MaxWidth) {
			return true;
		}
		if (metaObj instanceof Macro.MinHeight) {
			return true;
		}
		if (metaObj instanceof Macro.MozBoxSizing) {
			return true;
		}
		if (metaObj instanceof Macro.OverflowX) {
			return true;
		}
		if (metaObj instanceof Macro.OverflowY) {
			return true;
		}
		if (metaObj instanceof Macro.PaddingBottom) {
			return true;
		}
		if (metaObj instanceof Macro.PaddingLeft) {
			return true;
		}
		if (metaObj instanceof Macro.PaddingRight) {
			return true;
		}
		if (metaObj instanceof Macro.PaddingTop) {
			return true;
		}
		if (metaObj instanceof Macro.Position) {
			return true;
		}
		if (metaObj instanceof Macro.Right) {
			return true;
		}
		if (metaObj instanceof Macro.TableLayout) {
			return true;
		}
		if (metaObj instanceof Macro.TextAlign) {
			return true;
		}
		if (metaObj instanceof Macro.Top) {
			return true;
		}
		if (metaObj instanceof Macro.VerticalAlign) {
			return true;
		}
		if (metaObj instanceof Macro.Visibility) {
			return true;
		}
		if (metaObj instanceof Macro.WebkitBoxSizing) {
			return true;
		}
		if (metaObj instanceof Macro.WhiteSpace) {
			return true;
		}
		if (metaObj instanceof Macro.Width) {
			return true;
		}
		if (metaObj instanceof Macro.WordWrap) {
			return true;
		}
		if (metaObj instanceof Macro.Zoom) {
			return true;
		}
		return false;
	}
}

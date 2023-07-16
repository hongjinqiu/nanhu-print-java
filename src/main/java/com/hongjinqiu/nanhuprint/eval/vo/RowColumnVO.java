package com.hongjinqiu.nanhuprint.eval.vo;

/**
 * 参数对象,在计算表格宽度的过程中会用到
 * @author hongjinqiu
 */
public class RowColumnVO {
	private int row;// 行
	private int column;// 列

	public RowColumnVO(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
}

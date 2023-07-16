package com.hongjinqiu.nanhuprint;

/**
 * 打印模型异常包装类
 * @author hongjinqiu 2018.08.03
 */
public class NanhuprintException extends RuntimeException  {
	private static final long serialVersionUID = -6448531730347863278L;

	public NanhuprintException() {
		super();
	}

	public NanhuprintException(String message) {
		super(message);
	}

	public NanhuprintException(String message, Throwable cause) {
		super(message, cause);
	}

	public NanhuprintException(Throwable cause) {
		super(cause);
	}
}

package cn.cnsjwx.common.exceptions;

/**
 * 自定义异常基类
 */
public class NestedException extends NestedRuntimeException {

	private static final long serialVersionUID = -4775190692869227607L;

	public NestedException(String msg) {
		super(msg);
	}

	public NestedException(Throwable cause) {
		super(cause);
	}

	public NestedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Return the detail message, including the message from the creditease
	 * check exception if there is one.
	 */
	public String getMessage() {
		return super.getMessage(ExceptionDescriptor.Exception_DEF);
	}
}
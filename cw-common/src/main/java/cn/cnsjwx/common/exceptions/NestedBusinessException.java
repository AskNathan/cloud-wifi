package cn.cnsjwx.common.exceptions;

/**
 * 业务自定义异常基类
 */
public class NestedBusinessException extends NestedRuntimeException {

	private static final long serialVersionUID = 2724032065111817538L;

	String businessMes;

	public NestedBusinessException(String msg) {
		super(msg);
		businessMes = msg;
	}

	public NestedBusinessException(Throwable cause) {
		super(cause);
	}

	public NestedBusinessException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Return the detail message, including the message from the business check
	 * exception if there is one.
	 */
	public String getMessage() {
		return super.getMessage(ExceptionDescriptor.Exception_BIZ);
	}

	public String getBusinessMessage() {
		return new StringBuffer("").append(businessMes).append("").toString();
	}
}
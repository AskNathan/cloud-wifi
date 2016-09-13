package cn.cnsjwx.common.exceptions;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 把程序异常转化为自定义的运行时异常 一般自定义异常继承本类
 */
public abstract class NestedRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -8177944177839639283L;

	static {
		NestedExceptionUtil.class.getName();
	}

	private Throwable exceptionCause;

	/**
	 * Construct a <code>NestedRuntimeException</code> with the specified detail
	 * message. 构造子
	 * 
	 * @param msg
	 *            the detail message
	 */
	public NestedRuntimeException(String msg) {
		super(msg);
	}

	public NestedRuntimeException(Throwable cause) {
		this.exceptionCause = cause;
	}

	/**
	 * Construct a <code>NestedRuntimeException</code> with the specified detail
	 * message and nested exception. 构造子
	 * 
	 * @param msg
	 *            the detail message
	 * @param cause
	 *            the nested exception
	 */
	public NestedRuntimeException(String msg, Throwable cause) {
		super(msg, cause);
		this.exceptionCause = cause;
	}

	/**
	 * Retrieve the innermost cause of this exception, if any. 返回异常链上层异常
	 * 
	 * @return the innermost exception, or <code>null</code> if none
	 * @since 1.0
	 */
	public Throwable getRootCause() {
		Throwable rootCause = null;
		Throwable cause = getCause();
		while (cause != null && cause != rootCause) {
			rootCause = cause;
			cause = cause.getCause();
		}
		return rootCause;
	}

	/**
	 * Retrieve the most specific cause of this exception, that is, either the
	 * innermost cause (root cause) or this exception itself.
	 * <p>
	 * Differs from {@link #getRootCause()} in that it falls back to the present
	 * exception if there is no root cause.
	 * 
	 * @return the most specific cause (never <code>null</code>)
	 * @since 1.0
	 */
	public Throwable getMostSpecificCause() {
		Throwable rootCause = getRootCause();
		return (rootCause != null ? rootCause : this);
	}

	/**
	 * Return the detail message, including the message from the nested
	 * exception if there is one.
	 */
	public String getMessage() {
		return super.getMessage();
	}

	/**
	 * Return the detail message, including the message from the g3check
	 * exception if there is one.
	 */
	public String getMessage(int type) {
		return NestedExceptionUtil.buildMessage(super.getMessage(), type, getCause());
	}

	/**
	 * Check whether this exception contains an exception of the given type:
	 * either it is of the given class itself or it contains a nested cause of
	 * the given type.
	 * 
	 * @param exType
	 *            the exception type to look for
	 * @return whether there is a nested exception of the specified type
	 */
	public boolean contains(Class<?> exType) {
		if (exType == null) {
			return false;
		}
		if (exType.isInstance(this)) {
			return true;
		}
		Throwable cause = getCause();
		if (cause == this) {
			return false;
		}
		if (cause instanceof NestedRuntimeException) {
			return ((NestedRuntimeException) cause).contains(exType);
		} else {
			while (cause != null) {
				if (exType.isInstance(cause)) {
					return true;
				}
				if (cause.getCause() == cause) {
					break;
				}
				cause = cause.getCause();
			}
			return false;
		}
	}

	/**
	 * overwrite detail printStackTrace 重写打印错误信息堆栈的方法
	 */
	public void printStackTrace() {
		super.printStackTrace();
		if (exceptionCause != null) {
			synchronized (System.err) {
				System.err.println("\nException cause by:");
				exceptionCause.printStackTrace();
			}
		}
	}

	public void printStackTrace(PrintStream s) {
		super.printStackTrace(s);

		if (exceptionCause != null) {
			synchronized (s) {
				s.println("\nException cause by:");
				exceptionCause.printStackTrace(s);
			}
		}
	}

	public void printStackTrace(PrintWriter s) {
		super.printStackTrace(s);
		if (exceptionCause != null) {
			synchronized (s) {
				s.println("\nException cause by:");
				exceptionCause.printStackTrace(s);
			}
		}
	}
}

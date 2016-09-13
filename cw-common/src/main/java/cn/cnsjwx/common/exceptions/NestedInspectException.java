package cn.cnsjwx.common.exceptions;
/**
 * 
 */
public abstract class NestedInspectException extends Exception {

	private static final long serialVersionUID = 7100714597678207546L;

	/**
	 * Construct a <code>NestedInspectException</code> with the specified detail
	 * message.
	 * 
	 * @param msg
	 *            the detail message
	 */
	public NestedInspectException(String msg) {
		super(msg);
	}

	/**
	 * Construct a <code>NestedInspectException</code>
	 */
	public NestedInspectException() {
		super();
	}

	/**
	 * Construct a <code>NestedInspectException</code> with the specified
	 * Throwable
	 * 
	 * @param cause
	 */
	public NestedInspectException(Throwable cause) {
		super(cause);
	}

	/**
	 * Construct a <code>NestedInspectException</code> with the specified detail
	 * message and nested exception.
	 * 
	 * @param msg
	 *            the detail message
	 * @param cause
	 *            the check exception
	 */
	public NestedInspectException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Return the detail message, including the message from the g3check
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
	 * @return the innermost exception, or <code>null</code> if none
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
	 * @return the most specific cause (never <code>null</code>)
	 * @since 1.0
	 */
	public Throwable getMostSpecificCause() {
		Throwable rootCause = getRootCause();
		return (rootCause != null ? rootCause : this);
	}

	/**
	 * @param exType
	 *            the exception type to look for
	 * @return whether there is a common exception of the specified type
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
		if (cause instanceof NestedInspectException) {
			return ((NestedInspectException) cause).contains(exType);
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
}
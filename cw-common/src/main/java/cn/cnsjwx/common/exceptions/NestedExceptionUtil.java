package cn.cnsjwx.common.exceptions;
/**
 * 异常基础类负责拼装消息
 */
public abstract class NestedExceptionUtil {

	public static String buildMessage(String message, Throwable cause) {
		if (cause != null) {
			StringBuffer buf = new StringBuffer();
			if (message != null) {
				buf.append(message).append(";");
			}
			buf.append("Exception is:").append(cause);
			return buf.toString();
		} else {
			return message;
		}
	}

	public static String buildMessage(String message, int type, Throwable cause) {
		if (cause != null) {
			StringBuffer buf = new StringBuffer();
			if (message != null) {
				buf.append(message).append(",");
			}
			try {
				switch (type) {
				case ExceptionDescriptor.Exception_DEF:
					buf.append("TINestedException.");
				case ExceptionDescriptor.Exception_SQL:
					buf.append("TISQLException,SQL is: " + ((DataBaseAccessException) cause).getSql());
				case ExceptionDescriptor.Exception_CCE:
					buf.append("TIClassCastException.");
				case ExceptionDescriptor.Exception_IOB:
					buf.append("TIIndexOutOfBandsException.");
				case ExceptionDescriptor.Exception_NCF:
					buf.append("TINoClassDefFoundException.");
				case ExceptionDescriptor.Exception_SEC:
					buf.append("TISeccurityException.");
				case ExceptionDescriptor.Exception_NPE:
					buf.append("TINullPointerException.");
				case ExceptionDescriptor.Exception_MOG:// MongoDB数据库异常
					buf.append("TINestedMongoDbException.");
				case ExceptionDescriptor.Exception_BIZ:// 业务流程自定义异常
					buf.append("TINestedBusinessException,business info is: "
							+ ((NestedBusinessException) cause).getBusinessMessage());
				default:// 业务自定义异常
					buf.append("TINestedException");
				}
			} catch (Exception e) {
				buf.append("TINestedRuntimeException.");
			}
			// buf.append(" caused by :").append(cause);
			buf.append(" caused by :").append(cause.getMessage());
			return buf.toString();
		} else {
			return message;
		}
	}
}

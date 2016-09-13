package cn.cnsjwx.common.exceptions;

/**
 * 
 */
public class ExceptionDescriptor {
	
	// default Exception
	public static final int Exception_DEF = -1;
	// SQLException
	public static final int Exception_SQL = 0;

	// IndexOutOfBandsException
	public static final int Exception_IOB = 1;

	// ClassCastException
	public static final int Exception_CCE = 2;

	// NoClassDefFoundException
	public static final int Exception_NCF = 3;

	// SeccurityException
	public static final int Exception_SEC = 4;

	// NullPointerException
	public static final int Exception_NPE = 5;

	// mongodb Exception
	public static final int Exception_MOG = 6;

	// business Exception
	public static final int Exception_BIZ = 7;
}

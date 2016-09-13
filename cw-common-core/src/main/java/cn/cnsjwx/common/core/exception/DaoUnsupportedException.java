package cn.cnsjwx.common.core.exception;
import cn.cnsjwx.common.exceptions.DataBaseAccessException;
/**
 * 数据库操作异常
 */
public class DaoUnsupportedException extends DataBaseAccessException {

    private static final long serialVersionUID = 4928613476405775180L;

    public DaoUnsupportedException(String msg) {
        super(msg);
    }

    public DaoUnsupportedException() {
        super("this operation is not supported.");
    }

    public DaoUnsupportedException(Throwable cause) {
        super(cause);
    }
}
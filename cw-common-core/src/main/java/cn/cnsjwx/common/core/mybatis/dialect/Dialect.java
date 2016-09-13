package cn.cnsjwx.common.core.mybatis.dialect;

/**
 * 方言接口（各种数据库可实现自己的实现类）
 */
public interface Dialect {

	boolean supportsLimit();

	boolean supportsLimitOffset();

	String getLimitString(String sql, int offset, int limit);

}

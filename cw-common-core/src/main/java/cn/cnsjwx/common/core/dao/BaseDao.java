package cn.cnsjwx.common.core.dao;
import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import cn.cnsjwx.common.exceptions.DataBaseAccessException;
import cn.cnsjwx.common.page.Page;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
/**
 * 
 * @描述: 数据访问层基础支撑接口.
 * @版本: 1.0 .
 * @param <T>
 */
public interface BaseDao<T> {

	/**
	 * 保存
	 *
	 * @param key
	 *            MyBatis查询ID
	 * @param entity
	 *            对象
	 * @throws DataBaseAccessException
	 */
	public int save(String key, final T entity) throws DataBaseAccessException;

	/**
	 * 保存
	 *
	 * @param key
	 *            MyBatis查询ID
	 * @param entity
	 *            对象
	 * @throws DataBaseAccessException
	 */
	public int save(String key, final List<T> entity) throws DataBaseAccessException;

	/**
	 * 更新
	 *
	 * @param key
	 *            MyBatis查询ID
	 * @param entity
	 *            对象
	 * @throws DataBaseAccessException
	 */
	public int update(String key, final T entity) throws DataBaseAccessException;

	/**
	 * 更新
	 *
	 * @param key
	 *            MyBatis查询ID
	 * @param map
	 * @throws DataBaseAccessException
	 */
	public int update(String key, Map<Object, T> entity) throws DataBaseAccessException;

	/**
	 * 删除
	 *
	 * @param key
	 *            MyBatis查询ID
	 * @param id
	 *            对象ID
	 * @throws DataBaseAccessException
	 */
	public int delete(String key, final Serializable id) throws DataBaseAccessException;

	/**
	 * 删除
	 *
	 * @param key
	 *            MyBatis查询ID
	 * @param entity
	 *            对象
	 * @throws DataBaseAccessException
	 */
	public int delete(String key, final T entity) throws DataBaseAccessException;


	/**
	 * 批量 删除
	 * @param key
	 * @param ids
	 * @throws DataBaseAccessException
	 */
	public int delete(String key, final List<String> ids) throws DataBaseAccessException;


	/**
	 * 取得所有数据
	 *
	 * @param <T>
	 *            数据对象
	 * @param key
	 *            MyBatis查询ID
	 * @return List<T>
	 */
	public List<T> getAll(String key);

	/**
	 * 查询单个对象
	 *
	 * @param <T>
	 *            数据对象
	 * @param key
	 *            MyBatis查询ID
	 * @param params
	 *            查询参数，与Mapper.xml文件中的parameterType对应或id
	 * @return T
	 */
	public T get(String key, final Object params);

	/**
	 * 数据列表查询
	 *
	 * @param <T>
	 *            数据对象
	 * @param key
	 *            MyBatis查询ID
	 * @param params
	 *            查询参数，与Mapper.xml文件中的parameterType对应
	 * @return List<T>
	 */
	public List<T> getList(String key, final Object params);

	/**
	 * 分页数据列表查询
	 *
	 * @param <T>
	 *            数据对象
	 * @param key
	 *            MyBatis查询ID
	 * @param params
	 *            查询参数，与Mapper.xml文件中的parameterType对应
	 * @param page
	 *            分页对象
	 * @return Page<T>
	 */
	public Page<T> getList(String key, final Object params, Page<T> page);

	/**
	 * 计算记录总数
	 *
	 * @param key
	 * @param params
	 * @return Long
	 */
	public Integer count(String key, final Object params);

	/**
	 * 返回数据库连接
	 *
	 * @return Connection
	 */
	public Connection getConnection();

}

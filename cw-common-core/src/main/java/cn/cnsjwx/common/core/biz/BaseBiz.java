package cn.cnsjwx.common.core.biz;
import cn.cnsjwx.common.exceptions.DataBaseAccessException;
import cn.cnsjwx.common.page.Page;
/**
 * 数据库操作接口
 */
public interface BaseBiz<T> {

	/**
	 * 带条件的分页查询
	 *
	 * @param page
	 */
	public Page<T> getPage(T params, Page<T> page);

	/**
	 * 删除
	 *
	 * @param key
	 *            操作的用户
	 * @return String 提示信息
	 */
	public T findByKey(String key);

	/**
	 * 保存
	 *
	 * @param user
	 *            操作的用户
	 * @param t
	 *            实例对象
	 * @return String 提示信息
	 * @throws DataBaseAccessException
	 */
	public boolean save(String user, T t) throws DataBaseAccessException;

	/**
	 * 修改
	 *
	 * @param user
	 *            操作的用户
	 * @param t
	 *            实例对象
	 * @return String 提示信息
	 */
	public boolean update(String user, T t)throws DataBaseAccessException;

	/**
	 * 删除
	 *
	 * @param user
	 *            操作的用户
	 * @param t
	 *            实例对象
	 * @return String 提示信息
	 */
	public boolean delete(String user, T t)throws DataBaseAccessException;

}

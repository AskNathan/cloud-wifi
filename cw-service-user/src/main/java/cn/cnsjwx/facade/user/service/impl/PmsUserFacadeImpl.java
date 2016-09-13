/**
 * 
 */
package cn.cnsjwx.facade.user.service.impl;

import cn.cnsjwx.common.exceptions.DataBaseAccessException;
import cn.cnsjwx.common.logger.SimpleLogger;
import cn.cnsjwx.common.page.Page;
import cn.cnsjwx.facade.user.entity.PmsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cnsjwx.facade.user.service.PmsUserFacade;
import cn.cnsjwx.service.user.biz.impl.PmsUserBizImpl;

import java.util.Map;

/**
 * @描述: 用户Dubbo服务接口实现 .
 *
 * @创建时间: 2015-1-26,上午1:43:41 .
 * @版本号: V1.0 .
 */
@Service("pmsUserFacade")
public class PmsUserFacadeImpl implements PmsUserFacade {

	private SimpleLogger logger = SimpleLogger.getLogger(this.getClass());

	@Autowired
	private PmsUserBizImpl pmsUserBiz;

	@Override
	public void create(PmsUser pmsUser) {
		try {
			pmsUserBiz.save("zhangsan",pmsUser);
		} catch (DataBaseAccessException e) {
			logger.error("create PmsUser DataBaseAccessException",e);
		}
	}

	@Override
	public PmsUser getById(String userId) {
		return pmsUserBiz.findByKey(userId);
	}

	@Override
	public PmsUser findUserByUserNo(String userNo) {
		return null;
	}

	@Override
	public void deleteUserById(String userId) {

	}

	@Override
	public void update(PmsUser user) {

	}

	@Override
	public void updateUserPwd(String userId, String newPwd, boolean isTrue) {

	}

	@Override
	public Page<PmsUser> listPage(PmsUser params, Page<PmsUser> page) {
		return pmsUserBiz.getPage(params,page);
	}
}

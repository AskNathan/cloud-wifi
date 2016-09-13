package cn.cnsjwx.service.user.biz;
import java.util.Map;

import cn.cnsjwx.common.core.biz.BaseBiz;
import cn.cnsjwx.common.exceptions.DataBaseAccessException;
import cn.cnsjwx.common.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cnsjwx.facade.user.entity.PmsUser;
/**
 * 
 * @描述: 用户表--服务层接口 .
 *
 * @创建时间: 2013-7-25,下午10:41:04 .
 * @版本: 1.0 .
 */
public interface PmsUserBiz extends BaseBiz<PmsUser> {

    /**
     * 根据用户ID更新用户密码.
     * @param userId
     * @param newPwd
     * @param isTrue
     */
    public void updateUserPwd(String userId, String newPwd, boolean isTrue);
}
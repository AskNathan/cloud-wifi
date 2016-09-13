package cn.cnsjwx.service.user.biz.impl;
import cn.cnsjwx.common.core.dao.BaseDao;
import cn.cnsjwx.common.exceptions.DataBaseAccessException;
import cn.cnsjwx.common.logger.SimpleLogger;
import cn.cnsjwx.common.page.Page;
import cn.cnsjwx.service.user.biz.PmsUserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cnsjwx.facade.user.entity.PmsUser;

/**
 * 
 * @描述: 用户表--服务层接口 .
 * @创建时间: 2013-7-25,下午10:41:04 .
 * @版本: 1.0 .
 */
@Service("pmsUserBiz")
public class PmsUserBizImpl implements PmsUserBiz{


    private SimpleLogger logger = SimpleLogger.getLogger(this.getClass());


    private String mapper =  PmsUser.class.getName();

    @Autowired
    private BaseDao<PmsUser> pmsUserDao;


    @Override
    public void updateUserPwd(String userId, String newPwd, boolean isTrue) {

    }

    @Override
    public Page<PmsUser> getPage(PmsUser pmsUser, Page<PmsUser> page) {
        return pmsUserDao.getList(mapper+"Mapper.listPage", pmsUser, page);
    }

    @Override
    public PmsUser findByKey(String key) {
        return pmsUserDao.get(mapper+"Mapper.getById",key);
    }

    @Override
    public boolean save(String user, PmsUser pmsUser) throws DataBaseAccessException {
        if (pmsUserDao.save(mapper+"Mapper.insert",pmsUser) > 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public boolean update(String user, PmsUser pmsUser) throws DataBaseAccessException {
        if (pmsUserDao.update(mapper+"Mapper.update",pmsUser) > 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public boolean delete(String user, PmsUser pmsUser) throws DataBaseAccessException {
        if (pmsUserDao.update(mapper+"Mapper.delete",pmsUser) > 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
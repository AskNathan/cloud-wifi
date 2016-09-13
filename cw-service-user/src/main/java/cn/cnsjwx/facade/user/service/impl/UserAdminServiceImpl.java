package cn.cnsjwx.facade.user.service.impl;
import cn.cnsjwx.common.core.dao.BaseDao;
import cn.cnsjwx.common.exceptions.DataBaseAccessException;
import cn.cnsjwx.common.logger.SimpleLogger;
import cn.cnsjwx.common.page.Page;
import cn.cnsjwx.common.utils.DateUtils;
import cn.cnsjwx.common.utils.rsa.MD5;
import cn.cnsjwx.facade.user.entity.UserAdmin;
import cn.cnsjwx.facade.user.service.UserAdminService;
import cn.cnsjwx.facade.user.vo.UserAdminVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nathan on 2016-09-12.
 */
@Service("userAdminService")
public class UserAdminServiceImpl implements UserAdminService {

    private SimpleLogger logger = SimpleLogger.getLogger(this.getClass());

    private String mapper = UserAdmin.class.getName();

    @Autowired
    private BaseDao<UserAdmin> userAdminDao;

    @Autowired
    private BaseDao<UserAdminVo> userAdminVoDao;


    /**
     * 根据Id 查找UserAdmin
     * @param id
     * @return
     */
    @Override
    public UserAdmin findUserAdminById(String id) {
        return userAdminDao.get(mapper+"Mapper.findUserAdminById", id);
    }

    /**
     * 根据CompanyId查找UserAdmin
     *
     * @param companyId
     * @return
     */
    @Override
    public UserAdmin findUserAdminByCompanyId(String companyId) {
        return userAdminDao.get(mapper+"Mapper.findUserAdminByCompanyId", companyId);
    }

    /**
     * 根据loginname 查找UserAdmin
     *
     * @param loginname
     * @return
     */
    @Override
    public UserAdmin findUserAdminByLoginname(String loginname) {
        return userAdminDao.get(mapper+"Mapper.findUserAdminByLoginname", loginname);
    }

    /**
     * 企业管理员在企业内登录名称唯一
     *
     * @param userAdmin
     * @return
     */
    @Override
    public UserAdmin checkLoginnameInCompany(UserAdmin userAdmin) {
        return userAdminDao.get(mapper+"Mapper.checkLoginnameInCompany", userAdmin);
    }

    /**
     * 企业超管在超管内登录名称唯一
     *
     * @param userAdmin
     * @return
     */
    @Override
    public UserAdmin checkLoginnameInComAdmin(UserAdmin userAdmin) {
        return userAdminDao.get(mapper+"Mapper.checkLoginnameInComAdmin", userAdmin);
    }

    /**
     * CRM对接使用到：
     * 根据必选的企业CompanyId，必选的登录名称loginname,可选的角色roleId,可选的账户类型type判断
     *
     * @param userAdmin
     * @return
     */
    @Override
    public UserAdmin findSuperUAByCompanyIdAndType(UserAdmin userAdmin) {
        return userAdminDao.get(mapper+"Mapper.findSuperUAByCompanyIdAndType", userAdmin);
    }

    /**
     * 根据companyId 更新UserAdmin
     *
     * @param userAdmin
     * @return
     */
    @Override
    public Boolean updateUserAdminByCompanyId(UserAdmin userAdmin) {
        try {
            if(userAdminDao.update(mapper+"Mapper.updateByCompanyId", userAdmin) > 0){
                return Boolean.TRUE;
            }
        } catch (DataBaseAccessException e) {
            logger.error("update UserAdmin By companyId DataBaseAccessException",e);
        }
        return Boolean.FALSE;
    }

    /**
     * 根据id 更新UserAdmin
     *
     * @param userAdmin
     * @return
     */
    @Override
    public Boolean updateUserAdminById(UserAdmin userAdmin) {
        try {
            if(userAdminDao.update(mapper+"Mapper.update", userAdmin) > 0){
                return Boolean.TRUE;
            }
        } catch (DataBaseAccessException e) {
            logger.error("update UserAdmin By id DataBaseAccessException",e);
        }
        return Boolean.FALSE;    }

    /**
     * CRM对接时：变更CRM创建的唯一正式账户企业超管UserAdmin
     * 根据 CompanyID,可选的角色roleId,可选的账户类型type变更企业的登录名称loginname,用户名称username,启用状态eable,电话phone
     *
     * @param userAdmin
     * @return
     */
    @Override
    public UserAdmin updateStatusByRoleIDAndCompanyID(UserAdmin userAdmin) {
        try {
            if(userAdminDao.update(mapper+"Mapper.updateStatusByRoleIDAndCompanyID", userAdmin) > 0){
                return userAdmin;
            }
        } catch (DataBaseAccessException e) {
            logger.error("update UserAdmin By id DataBaseAccessException",e);
        }
        return null;
    }

    /**
     * 根据各参数查询UserAdminVo
     *
     * @param params
     * @param page
     * @return
     */
    @Override
    public Page<UserAdminVo> findUserAdminVoByParam(UserAdminVo params, Page<UserAdminVo> page) {
        return userAdminVoDao.getList(mapper+"Mapper.findUserAdminVoByParam", params, page);
    }

    /**
     * 根据各参数查询UserAdmin
     *
     * @param params
     * @param page
     * @return
     */
    @Override
    public Page<UserAdmin> findUserAdminByParam(UserAdmin params, Page<UserAdmin> page) {
        return userAdminDao.getList(mapper+"Mapper.findUserAdminByParam", params, page);
    }

    /**
     * 增加UserAdmin
     *
     * @param userAdmin
     * @return
     */
    @Override
    public Boolean addUserAdmin(UserAdmin userAdmin) {
        try {
            userAdmin.setPassword(MD5.getMD5Str(userAdmin.getPassword()));// 密码加密处理
            userAdmin.setDatetime(DateUtils.getCurTimestamp());
            if(userAdminDao.save(mapper+"Mapper.insert", userAdmin) > 0){
                return Boolean.TRUE;
            }
        } catch (DataBaseAccessException e) {
            logger.error("create UserAdmin DataBaseAccessException",e);
        }

        return Boolean.FALSE;
    }

    /**
     * del UserAdmin by id
     *
     * @param id
     * @return
     */
    @Override
    public Boolean delUserAdmin(String id) {
        try {
            if((userAdminDao.delete(mapper+"Mapper.delById", id)) > 0){
                return Boolean.TRUE;
            }
        } catch (DataBaseAccessException e) {
            logger.error("del UserAdmin by id DataBaseAccessException",e);
        }
        return Boolean.FALSE;    }

    /**
     * del UserAdmin by ids
     *
     * @param ids
     * @return
     */
    @Override
    public Boolean delUserAdminByIds(List<String> ids) {
        try {
            if((userAdminDao.delete(mapper+"Mapper.delByIds", ids)) > 0){
                return Boolean.TRUE;
            }
        } catch (DataBaseAccessException e) {
            logger.error("del UserAdmin by id DataBaseAccessException",e);
        }
        return Boolean.FALSE;
    }
}

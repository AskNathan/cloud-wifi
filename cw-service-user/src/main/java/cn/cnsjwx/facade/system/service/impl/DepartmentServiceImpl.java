package cn.cnsjwx.facade.system.service.impl;
import cn.cnsjwx.common.core.dao.BaseDao;
import cn.cnsjwx.common.core.mybatis.dao.KeyGenerator;
import cn.cnsjwx.common.exceptions.DataBaseAccessException;
import cn.cnsjwx.common.logger.SimpleLogger;
import cn.cnsjwx.common.page.Page;
import cn.cnsjwx.common.utils.DateUtils;
import cn.cnsjwx.facade.system.entity.Department;
import cn.cnsjwx.facade.system.service.DepartmentService;
import cn.cnsjwx.facade.system.vo.DepartmentVo;
import cn.cnsjwx.facade.user.entity.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by Nathan on 2016-09-08.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    private SimpleLogger logger = SimpleLogger.getLogger(this.getClass());

    private String mapper = Department.class.getName();

    @Autowired
    private BaseDao<Department> departmentDao;

    @Autowired
    private BaseDao<DepartmentVo> departmentVoDao;


    /**
     * 添加部门
     * @param department
     * @return
     */
    @Override
    public boolean add(Department department) {
        try {
            department.setId(KeyGenerator.randomSeqNum());
            department.setCreateTime(DateUtils.getCurTimestamp());
            if(departmentDao.save(mapper+"Mapper.insert", department)>0){
                return Boolean.TRUE;
            }
        } catch (DataBaseAccessException e) {
            logger.error("Create Department DataBaseAccessException", e);

        }
        return Boolean.FALSE;
    }

    /**
     * 更新部门
     * @param department
     * @return
     */
    @Override
    public boolean update(Department department) {
        try {
            if(departmentDao.update(mapper+"Mapper.update", department)>0){
                return Boolean.TRUE;
            }
        } catch (DataBaseAccessException e) {
            logger.error("update Department DataBaseAccessException", e);
        }
        return Boolean.FALSE;
    }

    /**
     * 根据ids 删除部门
     * @param ids
     * @return
     */
    @Override
    public boolean delDepartmentByIds(List<String> ids) {
        try {
            if((departmentDao.delete(mapper+"Mapper.delByIds", ids)) > 0){
                return Boolean.TRUE;
            }
        } catch (DataBaseAccessException e) {
            logger.error("del Department DataBaseAccessException",e);
        }
        return Boolean.FALSE;
    }

    /**
     * 根据Id 查询部门
     * @param id
     * @return
     */
    @Override
    public Department findDepartmentById(String id) {
        return departmentDao.get(mapper+"Mapper.findDepartmentById", id);
    }

    /**
     * 根据pid 查询企业子部门
     * @param pid
     * @return
     */
    @Override
    public List<Department> findDepartmentByPid(String pid) {
        return departmentDao.getList(mapper+"Mapper.findDepartmentByPid", pid);
    }

    /**
     * 根据CompanyId 查询企业部门
     * @param id
     * @return
     */
    @Override
    public List<Department> findDepartmentByCompanyId(String id) {
        return departmentDao.getList(mapper+"Mapper.findDepartmentByCompanyId", id);
    }

    /**
     * 根据各参数查询部门
     *
     * @param params
     * @param page
     * @return
     */
    @Override
    public Page<DepartmentVo> findDepartmentByParam(DepartmentVo params, Page<DepartmentVo> page) {
        return departmentVoDao.getList(mapper+"Mapper.findDepartmentByParam", params, page);
    }

    /**
     * 校验older只是否唯一
     * @param department
     * @return
     */
    @Override
    public Department findDepartmentByOrder(Department department) {
        return departmentDao.get(mapper+"Mapper.findDepartmentByOrder", department);
    }

    /**
     * 校验该企业下的name只是否唯一
     * @param department
     * @return
     */
    @Override
    public Department findDepartmentByName(Department department) {
        return departmentDao.get(mapper+"Mapper.findDepartmentByName", department);
    }

    /**
     * check out next level department by companyid and departmentId as pid
     * @param userClient
     * @return
     */
    @Override
    public List<Department> findNextLevelDepartment(UserClient userClient) {
        return departmentDao.getList(mapper+"Mapper.findNextLevelDepartment", userClient);
    }

    /**
     * check out next level department by companyid and departmentId as pid by function
     *
     * @param userClient
     * @return
     */
    @Override
    public List<Department> findNextLevelDepartmentByFunction(UserClient userClient) {
        return departmentDao.getList(mapper+"Mapper.findNextLevelDepartmentByFunction", userClient);
    }
}

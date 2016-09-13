package cn.cnsjwx.facade.system.service;
import cn.cnsjwx.common.page.Page;
import cn.cnsjwx.facade.system.entity.Department;
import cn.cnsjwx.facade.system.vo.DepartmentVo;
import cn.cnsjwx.facade.user.entity.UserClient;
import java.util.List;
/**
 * 部门接口定义
 * Created by Nathan on 2016-09-08.
 */
public interface DepartmentService {

    /**
     * 添加部门
     * @param department
     * @return
     */
    public boolean add(Department department);

    /**
     * 更新部门
     * @param department
     * @return
     */
    public boolean update(Department department);


    /**
     * 根据ids 删除部门
     * @param ids
     * @return
     */
    public boolean delDepartmentByIds(List<String> ids);

    /**
     * 根据Id 查询部门
     * @param id
     * @return
     */
    public Department findDepartmentById(String id);

    /**
     * 根据pid 查询企业子部门
     * @param pid
     * @return
     */
    public List<Department> findDepartmentByPid(String pid);

    /**
     * 根据CompanyId 查询企业部门
     * @param id
     * @return
     */
    public List<Department> findDepartmentByCompanyId(String id);

    /**
     * 根据各参数查询部门
     * @param params
     * @param page
     * @return
     */
    public Page<DepartmentVo> findDepartmentByParam(DepartmentVo params, Page<DepartmentVo> page);

    /**
     * 校验older只是否唯一
     * @param dep
     * @return
     */
    public Department findDepartmentByOrder(Department dep);

    /**
     * 校验该企业下的name只是否唯一
     * @param dep
     * @return
     */
    public Department findDepartmentByName(Department dep);

    /**
     * check out next level department by companyid and departmentId as pid
     * @param dep
     * @return
     */
    public List<Department> findNextLevelDepartment(UserClient dep);

    /**
     * check out next level department by companyid and departmentId as pid by function
     * @param dep
     * @return
     */
    public List<Department> findNextLevelDepartmentByFunction(UserClient dep);


}

package cn.cnsjwx.facade.system.service;
import cn.cnsjwx.common.page.Page;
import cn.cnsjwx.facade.system.entity.Company;
import java.util.List;
/**
 * 企业Service
 * Created by Nathan on 2016-09-08.
 */
public interface CompanyService {

    /**
     * 添加企业
     * @param company
     * @return
     */
    public boolean add(Company company);

    /**
     * 更新企业
     * @param company
     * @return
     */
    public boolean update(Company company);

    /**
     * 根据ids 删除企业
     * @param ids
     * @return
     */
    public boolean delCompanyByIds(List<String> ids);


    /**
     * 根据Id 删除企业
     * @param id
     * @return
     */
    public boolean delCompanyById(String id);


    /**
     * 根据Id 查询企业
     * @param id
     * @return
     */
    public Company findCompanyById(String id);


    /**
     * 根据各参数查询公司
     * @param params
     * @param page
     * @return
     */
    public Page<Company> findCompanyByParam(Company params, Page<Company> page);

    /**
     * 校验Code只是否唯一
     * @param params
     * @return
     */
    public Company findCompanyByCode(Company params);


    /**
     * 查询所有企业
     * @return
     */
    public List<Company> findAllCompany();


}

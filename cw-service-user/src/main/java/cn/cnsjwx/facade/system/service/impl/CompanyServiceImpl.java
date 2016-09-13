package cn.cnsjwx.facade.system.service.impl;
import cn.cnsjwx.common.core.dao.BaseDao;
import cn.cnsjwx.common.core.mybatis.dao.KeyGenerator;
import cn.cnsjwx.common.exceptions.DataBaseAccessException;
import cn.cnsjwx.common.logger.SimpleLogger;
import cn.cnsjwx.common.page.Page;
import cn.cnsjwx.common.utils.DateUtils;
import cn.cnsjwx.facade.system.entity.Company;
import cn.cnsjwx.facade.system.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * 企业的Service 实现
 * Created by Nathan on 2016-09-08.
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService{

    private SimpleLogger logger = SimpleLogger.getLogger(this.getClass());

    private String mapper = Company.class.getName();

    @Autowired
    private BaseDao<Company> companyDao;


    /**
     * 添加企业
     * @param company
     * @return
     */
    @Override
    public boolean add(Company company) {
        try {
            company.setId(KeyGenerator.randomSeqNum());
            company.setCreateTime(DateUtils.getCurTimestamp());
            if(companyDao.save(mapper+"Mapper.insert", company) > 0){
                return Boolean.TRUE;
            }
        } catch (DataBaseAccessException e) {
            logger.error("create Company DataBaseAccessException",e);
        }
        return Boolean.FALSE;
    }

    /**
     * 更新企业
     * @param company
     * @return
     */
    @Override
    public boolean update(Company company) {
        try {
            if(companyDao.update(mapper+"Mapper.update", company) > 0){

                return Boolean.TRUE;
            }
        } catch (DataBaseAccessException e) {
            logger.error("update Company DataBaseAccessException",e);
        }
        return Boolean.FALSE;
    }

    /**
     * 根据ids 删除企业
     * @param ids
     * @return
     */
    @Override
    public boolean delCompanyByIds(List<String> ids) {
        try {
            if((companyDao.delete(mapper+"Mapper.delByIds", ids)) > 0){
                return Boolean.TRUE;
            }
        } catch (DataBaseAccessException e) {
            logger.error("del Company DataBaseAccessException",e);
        }
        return Boolean.FALSE;

    }

    /**
     * 根据Id 删除企业
     * @param id
     * @return
     */
    @Override
    public boolean delCompanyById(String id) {
        try {
            if((companyDao.delete(mapper+"Mapper.delById", id)) > 0){
                return Boolean.TRUE;
            }
        } catch (DataBaseAccessException e) {
            logger.error("del Company DataBaseAccessException",e);
        }

        return Boolean.FALSE;
    }

    /**
     * 根据Id 查询企业
     * @param id
     * @return
     */
    @Override
    public Company findCompanyById(String id) {
        return companyDao.get(mapper+"Mapper.findCompanyById", id);
    }

    /**
     * 根据各参数查询公司
     * @param params
     * @param page
     * @return
     */
    @Override
    public Page<Company> findCompanyByParam(Company params, Page<Company> page) {
        return companyDao.getList(mapper+"Mapper.findCompanyByParam", params, page);
    }

    /**
     * 校验Code只是否唯一
     * @param params
     * @return
     */
    @Override
    public Company findCompanyByCode(Company params) {
        return companyDao.get(mapper+"Mapper.findCompanyByCode", params);
    }

    /**
     * 查询所有企业
     * @return
     */
    @Override
    public List<Company> findAllCompany() {
        return companyDao.getAll(mapper+"Mapper.findAllCompany");
    }
}

package dubbo.test;
import cn.cnsjwx.common.page.JcUtil;
import cn.cnsjwx.common.page.Page;
import cn.cnsjwx.common.utils.DateUtils;
import cn.cnsjwx.facade.system.entity.Company;
import cn.cnsjwx.facade.system.service.CompanyService;
import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nathan on 2016-09-12.
 */
public class TestCompanyService extends TestCase {

    ClassPathXmlApplicationContext context;

    @Autowired
    private CompanyService companyService;

    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(new String[] { "spring-dubbo-consumer.xml" });
        super.setUp();
        companyService = (CompanyService) context.getBean("companyService");
    }

    public void testadd(){
        Company company = new Company();
        company.setName("商机无限");
        company.setCode("SJWX");
        company.setEnable(0);
        company.setEffDate(DateUtils.getCurTimestamp());
        company.setPid(null);
        company.setTryStatus(1);
        Boolean result = companyService.add(company);
        System.out.println(result);
    }

    public void testupdate(){
         List<Company> companyList = companyService.findAllCompany();
         if(companyList.size() > 0){
           Company company = companyList.get(0);
             company.setRemark("Test");
             Boolean result = companyService.update(company);
             System.out.println(result);
         }
    }

    public void testfindCompanyById(){
        Company company = companyService.findCompanyById("84b869b2b1d640deb68a443cea41bc89");
        System.out.println(company);
        Company  c  = new Company();
                c.setCode("SJWX1");
        Company company1 = companyService.findCompanyByCode(c);
        System.out.println(company1.getCode());

    }

    public void testfindCompanyByParam(){
        Page<Company> page = new Page<Company>();
        Company company  = new Company();
        company.setName("2");
        company.setCode("SJWX2");
        company.setTryStatus(1);
        JcUtil.formatPageSize("0","2",page);
        page = companyService.findCompanyByParam(company,page);
        System.out.println(page.getResult().size());
    }


    public void testdelCompanyById(){
        Boolean result = companyService.delCompanyById("84b869b2b1d640deb68a443cea41bc81");
        System.out.println(result);
        Boolean result1 = companyService.delCompanyByIds(Arrays.asList("84b869b2b1d640deb68a443cea41bc82","84b869b2b1d640deb68a443cea41bc89"));
        System.out.println(result1);
    }

}

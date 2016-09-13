package dubbo.test;
import cn.cnsjwx.common.page.JcUtil;
import cn.cnsjwx.common.page.Page;
import cn.cnsjwx.facade.system.entity.Department;
import cn.cnsjwx.facade.system.service.DepartmentService;
import cn.cnsjwx.facade.system.vo.DepartmentVo;
import cn.cnsjwx.facade.user.entity.UserClient;
import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

/**
 * Created by Nathan on 2016-09-12.
 */
public class TestDepartmentService extends TestCase {

    ClassPathXmlApplicationContext context;

    @Autowired
    private DepartmentService departmentService;

    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(new String[] { "spring-dubbo-consumer.xml" });
        super.setUp();
        departmentService = (DepartmentService) context.getBean("departmentService");
    }


    public void testadd(){
        Department department = new Department();
        department.setName("软件部");
        department.setOrder(1);
        department.setDesc("软件部 CODER");
        department.setCompanyId("68e9e9e33d8d4670949e364072f9c119");
        Boolean result = departmentService.add(department);
        System.out.println(result);
    }

    public void testupdate(){
        Department department = departmentService.findDepartmentById("cce0759a8f424cfe8bba02095e712062");
        department.setDesc("软件部 CODER1");
        department.setPid("58cc4d6dd6af4bfcbcc451d449e5b88a");
        Boolean result = departmentService.update(department);
        System.out.println(result);
    }


    public void testfindDepartmentByOrder(){
        Department department = new Department();
        department.setOrder(1);
        department.setCompanyId("68e9e9e33d8d4670949e364072f9c119");
        Department department1 = departmentService.findDepartmentByOrder(department);
        System.out.println(department1.getId());
        department.setName("软件部1");
        Department department2 = departmentService.findDepartmentByName(department);
        System.out.println(department2.getId());
        List<Department> departmentList = departmentService.findDepartmentByCompanyId("68e9e9e33d8d4670949e364072f9c119");
        System.out.println(departmentList.size());

    }


    public void testfindDepartmentByParam(){
        Page<DepartmentVo> page = new Page<DepartmentVo>();
        DepartmentVo departmentVo = new DepartmentVo();
        departmentVo.setName("1");
        departmentVo.setCompanyId("68e9e9e33d8d4670949e364072f9c119");
        JcUtil.formatPageSize("0","1",page);
        page = departmentService.findDepartmentByParam(departmentVo,page);
        System.out.println(page.getResult().size());
    }


    public void testfindNextLevelDepartmentByFunction(){
        UserClient userClient = new UserClient();
        userClient.setCompanyId("68e9e9e33d8d4670949e364072f9c119");
        userClient.setDepartmentId("58cc4d6dd6af4bfcbcc451d449e5b88a");
        List<Department> departmentList = departmentService.findNextLevelDepartmentByFunction(userClient);
        System.out.println(departmentList.size());
    }









}

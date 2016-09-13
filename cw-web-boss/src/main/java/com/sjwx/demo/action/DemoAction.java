package com.sjwx.demo.action;
import cn.cnsjwx.facade.user.entity.PmsUser;
import cn.cnsjwx.facade.user.service.PmsUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by Nathan on 2016-08-22.
 */
@RestController
public class DemoAction {

    @Autowired
    private PmsUserFacade pmsUserFacade;

    @RequestMapping("/json")
    public String test1(){

        for (int i = 0; i < 1; i++) {
            PmsUser user=  pmsUserFacade.getById("11");
            System.out.println(user);
            System.out.println("第"+i+user.getEmail()+"次调用!");
        }
        return "";
    }

}

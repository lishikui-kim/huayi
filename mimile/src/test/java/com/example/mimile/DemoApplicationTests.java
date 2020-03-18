package com.example.mimile;

import com.example.mimile.beans.Company;
import com.example.mimile.beans.Job;
import com.example.mimile.controllers.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    //    依赖注入，讲spring的时候用到了
    @Autowired
    private MyController myController;

    @Test
    public void myControllerTest() {
        String result = myController.hello1();
        System.out.println(result);
    }

    @Autowired
    private Job job;

    @Test
    public void showJobInfo() {
        System.out.println(job);
    }


    @Autowired
    private Company company;

    @Test
    public void showCompanyInfo() {
        System.out.println(company);
    }


}

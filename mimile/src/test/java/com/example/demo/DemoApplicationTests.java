package com.example.demo;

import com.example.demo.beans.Job;
import com.example.demo.controllers.MyController;
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
        String result = myController.hello();
        System.out.println(result);
    }
    @Autowired
    private Job job;

    @Test
    public void showJobInfo() {
        System.out.println(job);
    }



}

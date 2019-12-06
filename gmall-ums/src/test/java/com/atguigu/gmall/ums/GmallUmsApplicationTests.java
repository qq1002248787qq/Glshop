package com.atguigu.gmall.ums;

import com.atguigu.gmall.ums.entity.Admin;
import com.atguigu.gmall.ums.service.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class GmallUmsApplicationTests {

    @Autowired
    private AdminService AdminService;
    @Test
    void contextLoads() {
        Admin byId = AdminService.getById(3);
        System.out.println(byId.getUsername());
    }

}

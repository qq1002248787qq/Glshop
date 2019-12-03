package com.atguigu.gmall.pms;

import com.atguigu.gmall.pms.entity.Product;
import com.atguigu.gmall.pms.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class GmallPmsApplicationTests {

    @Autowired
    ProductService productService;

    @Test
    void contextLoads() {
        Product byId = productService.getById(1);
        System.out.println(byId.getName());
    }

}

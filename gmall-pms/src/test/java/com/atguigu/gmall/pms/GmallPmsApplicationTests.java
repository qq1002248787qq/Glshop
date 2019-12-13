package com.atguigu.gmall.pms;

import com.atguigu.gmall.pms.entity.Brand;
import com.atguigu.gmall.pms.entity.Product;
import com.atguigu.gmall.pms.service.ProductService;
import com.atguigu.gmall.vo.PageInfoVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class GmallPmsApplicationTests {

    @Autowired
    ProductService productService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object,Object>  redisTemplate;

    @Test
    public void redisTemplate(){
        //stringRedisTemplate.opsForValue();//操作redis种string类型
      //  stringRedisTemplate.opsForHash();//hash类型
      //  stringRedisTemplate.opsForList();//list类型
        stringRedisTemplate.opsForValue().set("hello","world");

        System.out.println("报存了数据");

        String hello = stringRedisTemplate.opsForValue().get("hello");

        System.out.println("刚保存的数据为"+hello);
    }

    @Test
    void redisTemplateObject() {
        //存对象需要转成json字符串
        //去redis中取出来，逆向转成对象
        Brand brand = new Brand();
        brand.setName("大众1");

        redisTemplate.opsForValue().set("abc1",brand);

        System.out.println("刚存了一个对象");

        Brand o = (Brand)redisTemplate.opsForValue().get("abc1");

        System.out.println("刚才存的对象"+o.getName());

    }

    @Test
    void contextLoads() {
        Product byId = productService.getById(1);
        System.out.println(byId.getName());
    }

   /* @Test
    void test1(){
        IPage<Product> page = productMapper.selectPage(new Page<Product>(productQueryParam.getPageNum(), productQueryParam.getPageSize()), null);

        PageInfoVo pageInfoVo = new PageInfoVo(page.getTotal(),page.getPages(),page.getSize(),productQueryParam.getPageSize(),
                page.getRecords(),page.getCurrent());

    }*/

}

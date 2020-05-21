package com.ljh.firsts.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ljh.firsts.MainApplication;
import com.ljh.firsts.dao.ProductDao;
import com.ljh.firsts.model.Product;
import org.springframework.test.context.junit4.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class ProductTest {
	@Autowired 
    private ProductDao productDao;

    @Test
    public void testQuery() {
        Product record = new Product();
        record.setState(1);
        List<Product> list = productDao.list(record);
        System.out.println(list.size());
}
}
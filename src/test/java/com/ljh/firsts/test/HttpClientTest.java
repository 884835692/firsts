package com.ljh.firsts.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ljh.firsts.MainApplication;
import com.ljh.firsts.utils.http.HttpClientUtil;
import org.springframework.test.context.junit4.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class HttpClientTest {

    @Autowired
    HttpClientUtil httpClientUtil;

    @Test
    public void test() {
        try {
            String str = httpClientUtil.doGet("http://www.baidu.com");
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
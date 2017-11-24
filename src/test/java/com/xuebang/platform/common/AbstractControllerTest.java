package com.xuebang.platform.common;

import com.xuebang.platform.unionpay.web.unionPay.UnionPayController;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 2017-11-24 23:23
 * AbstractControllerTest
 * description: 测试 controller
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UnionPayController.class)
@WebAppConfiguration
public abstract class AbstractControllerTest {

    @Autowired
    protected WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
}

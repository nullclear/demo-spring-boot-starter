package dev.yxy.demo.test;

import dev.yxy.demo.config.DemoAutoConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 全局测试类
 *
 * @author nullclear
 * @since 2022-10-16
 */
@SpringBootTest(classes = DemoAutoConfig.class)
public class GlobalTests {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
}

package dev.yxy.demo.test;

import dev.yxy.demo.constant.DemoConstants;
import dev.yxy.demo.service.IDemoService;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * Bar Tests
 *
 * @author nullclear
 * @since 2022-10-16
 */
public class DemoServiceBarTests extends GlobalTests {

    @Resource(name = DemoConstants.DEFAULT_DEMO_SERVICE_BEAN_NAME)
    private IDemoService demoService;

    @Test
    public void test_bar() {
        if (logger.isDebugEnabled()) {
            logger.debug("[test_bar] - {}", demoService.bar("DemoServiceBarTests"));
        }
    }
}


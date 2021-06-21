package dev.yxy.demo.config;

import dev.yxy.demo.service.DemoService;
import dev.yxy.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by atom on 2021/06/21
 */
@Configuration
@EnableConfigurationProperties(DemoProperties.class)
@ConditionalOnProperty(prefix = "demo", name = "enabled", havingValue = "true")
public class DemoConfig {

    @Autowired
    private DemoProperties demoProperties;

    @Bean(name = "demoService")
    @ConditionalOnMissingBean(IDemoService.class)
    public IDemoService demoService() {
        return new DemoService(demoProperties.getName(), demoProperties.getNickName());
    }
}

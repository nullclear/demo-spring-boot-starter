package dev.yxy.demo.config;

import dev.yxy.demo.constant.CryptoConstants;
import dev.yxy.demo.constant.DemoConstants;
import dev.yxy.demo.service.ICryptoService;
import dev.yxy.demo.service.IDemoService;
import dev.yxy.demo.service.impl.AesService;
import dev.yxy.demo.service.impl.DemoService;
import dev.yxy.demo.service.impl.Md5Service;
import dev.yxy.demo.service.impl.RsaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 样例自动配置类
 * <p>
 * 关于 @EnableConfigurationProperties 注解: https://www.jianshu.com/p/7f54da1cb2eb
 * 通过 @ConfigurationProperties 使用外部配置填充Bean属性的几种方法: https://blog.csdn.net/andy_zhang2007/article/details/78761651
 *
 * @author nullclear
 * @since 2022-10-16
 */
@Configuration
@EnableConfigurationProperties(DemoProperties.class)
@ConditionalOnProperty(prefix = DemoConstants.PREFIX_NAME, name = "enabled", havingValue = "true")
@RequiredArgsConstructor
public class DemoAutoConfig {

    private final DemoProperties demoProperties;

    @ConditionalOnMissingBean(ICryptoService.class)
    @ConditionalOnProperty(prefix = DemoConstants.PREFIX_NAME, name = DemoConstants.SIGN_TYPE, havingValue = CryptoConstants.MD5)
    @Bean(name = DemoConstants.DEFAULT_CRYPTO_SERVICE_BEAN_NAME)
    public ICryptoService md5Service() {
        return new Md5Service();
    }

    @ConditionalOnMissingBean(ICryptoService.class)
    @ConditionalOnProperty(prefix = DemoConstants.PREFIX_NAME, name = DemoConstants.SIGN_TYPE, havingValue = CryptoConstants.RSA)
    @Bean(name = DemoConstants.DEFAULT_CRYPTO_SERVICE_BEAN_NAME)
    public ICryptoService rsaService() {
        return new RsaService();
    }

    @ConditionalOnMissingBean(ICryptoService.class)
    @ConditionalOnProperty(prefix = DemoConstants.PREFIX_NAME, name = DemoConstants.SIGN_TYPE, havingValue = CryptoConstants.AES)
    @Bean(name = DemoConstants.DEFAULT_CRYPTO_SERVICE_BEAN_NAME)
    public ICryptoService aesService() {
        return new AesService();
    }

    @ConditionalOnMissingBean(IDemoService.class)
    @Bean(name = DemoConstants.DEFAULT_DEMO_SERVICE_BEAN_NAME)
    public IDemoService demoService(@Qualifier(DemoConstants.DEFAULT_CRYPTO_SERVICE_BEAN_NAME) ICryptoService cryptoService) {
        return new DemoService(demoProperties, cryptoService);
    }
}

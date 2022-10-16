package dev.yxy.demo.config;

import dev.yxy.demo.constant.CryptoConstants;
import dev.yxy.demo.constant.DemoConstants;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * 样例属性
 * <p>
 * springboot项目中yml数字开头为0时自动转换问题: https://blog.csdn.net/qq_33164327/article/details/122818401
 *
 * @author nullclear
 * @since 2022-10-16
 */
@ConfigurationProperties(prefix = DemoConstants.PREFIX_NAME)
@Getter
@Setter
public class DemoProperties {

    /**
     * 是否开启
     */
    private boolean enabled = false;

    /**
     * 签名方式
     */
    private SignType signType;

    /**
     * 发版信息
     */
    @NestedConfigurationProperty
    private final ReleaseInfo releaseInfo = new ReleaseInfo();

    /**
     * 签名方式
     */
    @Getter
    @RequiredArgsConstructor
    public enum SignType {
        MD5(CryptoConstants.MD5),
        RSA(CryptoConstants.RSA),
        AES(CryptoConstants.AES);

        private final String name;
    }

    @Getter
    @Setter
    public static class ReleaseInfo {

        /**
         * 版本号
         */
        private String version;

        /**
         * 编号
         */
        private String number;

        /**
         * 作者名
         */
        private String authorName;
    }
}

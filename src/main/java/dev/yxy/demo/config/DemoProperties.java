package dev.yxy.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by atom on 2021/06/21
 */
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {

    private boolean enabled = false;

    private String name = "default_name";

    private String nickName = "default_nickname";

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}

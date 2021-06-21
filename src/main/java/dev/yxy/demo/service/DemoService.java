package dev.yxy.demo.service;

/**
 * Created by atom on 2021/06/21
 */
public class DemoService implements IDemoService {

    private final String name;

    private final String nickName;

    public DemoService(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String introduceYourself() {
        return String.format("My name is [%s]，and my nickname is [%s]", name, nickName);
    }
}

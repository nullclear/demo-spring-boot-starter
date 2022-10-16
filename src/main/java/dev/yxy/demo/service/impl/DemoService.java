package dev.yxy.demo.service.impl;

import dev.yxy.demo.config.DemoProperties;
import dev.yxy.demo.service.ICryptoService;
import dev.yxy.demo.service.IDemoService;
import lombok.RequiredArgsConstructor;

/**
 * 样例服务
 *
 * @author nullclear
 * @since 2022-10-16
 */
@RequiredArgsConstructor
public class DemoService implements IDemoService {

    private final DemoProperties properties;

    private final ICryptoService cryptoService;

    @Override
    public String foo(String data) {
        return cryptoService.sign(String.format("%s-%s-%s", "foo", properties.getReleaseInfo().getNumber(), data));
    }

    @Override
    public String bar(String data) {
        return cryptoService.sign(String.format("%s-%s-%s", "bar", properties.getReleaseInfo().getNumber(), data));
    }
}

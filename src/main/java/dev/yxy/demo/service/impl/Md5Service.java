package dev.yxy.demo.service.impl;

import dev.yxy.demo.constant.CryptoConstants;
import dev.yxy.demo.service.ICryptoService;

/**
 * MD5
 *
 * @author nullclear
 * @since 2022-10-16
 */
public class Md5Service implements ICryptoService {

    @Override
    public String getAlgorithm() {
        return CryptoConstants.MD5;
    }
}

package dev.yxy.demo.service.impl;

import dev.yxy.demo.constant.CryptoConstants;
import dev.yxy.demo.service.ICryptoService;

/**
 * AES
 *
 * @author nullclear
 * @since 2022-10-16
 */
public class AesService implements ICryptoService {

    @Override
    public String getAlgorithm() {
        return CryptoConstants.AES;
    }
}

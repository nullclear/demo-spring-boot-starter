package dev.yxy.demo.service.impl;

import dev.yxy.demo.constant.CryptoConstants;
import dev.yxy.demo.service.ICryptoService;

/**
 * RSA
 *
 * @author nullclear
 * @since 2022-10-16
 */
public class RsaService implements ICryptoService {

    @Override
    public String getAlgorithm() {
        return CryptoConstants.RSA;
    }
}

package dev.yxy.demo.service;

/**
 * 加密接口
 *
 * @author nullclear
 * @since 2022-10-16
 */
public interface ICryptoService {

    /**
     * 加密算法
     */
    String getAlgorithm();

    /**
     * 签名
     */
    default String sign(String data) {
        return String.format("[%s] - [%s]", this.getAlgorithm(), data);
    }
}

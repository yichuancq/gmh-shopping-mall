package com.gmh.mail.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gmh.mail.domain.ProductEntity;

import java.math.BigInteger;

/**
 * @author yichuan
 */
public interface ProductService extends IService<ProductEntity> {
    /**
     * @return
     */
    boolean saveProduct();

    /**
     * @param id
     * @return
     */
    ProductEntity findById(BigInteger id);
}

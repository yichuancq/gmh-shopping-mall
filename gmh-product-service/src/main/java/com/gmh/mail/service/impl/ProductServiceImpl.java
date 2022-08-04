package com.gmh.mail.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gmh.mail.domain.ProductEntity;
import com.gmh.mail.mapper.ProductMapper;
import com.gmh.mail.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author yichuan
 */
@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductEntity> implements ProductService {
    @Override
    public boolean saveProduct() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCreateTime(new Date());
        productEntity.setProductName("test name");
        productEntity.setUpdateTime(new Date());
        productEntity.setId(BigInteger.valueOf(Long.parseLong(IdWorker.getIdStr())));
        return this.save(productEntity);

    }

    @Override
    public ProductEntity findById(BigInteger id) {
        ProductEntity productEntity = this.getById(id);
        return productEntity;
    }
}

package com.softbreezee.demo.service.impl;

import com.softbreezee.demo.dataobj.ProductInfo;
import com.softbreezee.demo.dto.CartDTO;
import com.softbreezee.demo.enums.ProductStatusEnum;
import com.softbreezee.demo.enums.ResultEnum;
import com.softbreezee.demo.exception.SellException;
import com.softbreezee.demo.repository.ProductInfoRepository;
import com.softbreezee.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.service.impl
 * @date:2018/6/29
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }


    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatusIs(ProductStatusEnum.UP.getCode());
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOS) {
        for (CartDTO cartDTO:cartDTOS ) {
            ProductInfo productInfo = productInfoRepository.findById(cartDTO.getProductId()).get();
            if(productInfo==null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOS) {
        for (CartDTO cartDTO:cartDTOS ) {
            ProductInfo productInfo = productInfoRepository.findById(cartDTO.getProductId()).get();
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }

    @Override
    public ProductInfo offSale(String  productId) {
        ProductInfo productInfo = productInfoRepository.findById(productId).get();
        if(productInfo==null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(!productInfo.getProductStatus().equals(ProductStatusEnum.UP.getCode())){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo onSale(String  productId) {
        ProductInfo productInfo = productInfoRepository.findById(productId).get();
        if(productInfo==null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(!productInfo.getProductStatus().equals(ProductStatusEnum.DOWN.getCode())){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return productInfoRepository.save(productInfo);
    }
}

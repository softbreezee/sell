package com.softbreezee.demo.dataobj;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softbreezee.demo.enums.ProductStatusEnum;
import com.softbreezee.demo.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer productStatus;
    private Integer categoryType = ProductStatusEnum.UP.getCode();//0正常，1下架
    private Date createTime;
    private Date updateTime;



}

package com.waylau.spring.cloud.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 19:46
 **/
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ProductGroup")
@XmlType(propOrder = {
        "product",
        "version",
})
public class ProductGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    // 产品
    private String product;

    // 版本
    private String version;
}

package com.waylau.spring.cloud.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 19:26
 **/
@XmlRootElement(name = "PyeeInf")
@XmlAccessorType(XmlAccessType.NONE)
@Data
public class PyeeInf {
    @XmlElement(name = "PyeeAcctIssrId")
    private String pyeeAcctIssrId;

    @XmlElement(name = "PyeeAcctId")
    private String pyeeAcctId;

    @XmlElement(name = "PyeeAcctNm")
    private String pyeeAcctNm;

    @XmlElement(name = "PyeeAcctTp")
    private List<String> pyeeAcctTp;//有多个同字段数据

    @XmlElement(name = "PyerTrxTrmTp")
    private String pyeeTrxTrmTp;

    @XmlElement(name = "PyerTrxTrmNo")
    private String pyeeTrxTrmNo;

}

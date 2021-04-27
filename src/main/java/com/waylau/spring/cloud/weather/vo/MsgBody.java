package com.waylau.spring.cloud.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 19:25
 **/
@XmlRootElement(name = "MsgBody")
@XmlAccessorType(XmlAccessType.NONE)
@Data
public class MsgBody {
//    @XmlElement(name = "PyerInf")
//    private PyerInf pyerInf;//付款方信息

    @XmlElement(name = "PyerTrxTrmNo")
    private String pyerTrxTrmNo;//收付标识，1：付款方，2-收款方

    @XmlElement(name = "PyeeInf")
    private PyeeInf pyeeInf;//收款方信息

//    @XmlElement(name = "ResfdtInf")
//    private ResfdtInf resfdtInf;//备付金信息
//
//    @XmlElement(name = "TrxInf")
//    private TrxInf trxInf;//交易信息

//    @XmlElement(name = "OrdrInf")
//    private OrdrInf ordrInf;//订单信息

    @XmlElement(name = "BatchId")
    private String batchId;//交易批次号

    @XmlElement(name = "TrxDevcInf")
    private String trxDevcInf;//交易设备信息


}

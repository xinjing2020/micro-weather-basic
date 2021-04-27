package com.waylau.spring.cloud.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 19:24
 **/
@XmlRootElement(name = "MsgHeader")
@XmlAccessorType(XmlAccessType.NONE)
@Data
public class MsgHeader {
    @XmlElement(name = "SndDt")
    private String sndDt;

    @XmlElement(name = "MsgTp")
    private String msgTp;

    @XmlElement(name = "IssrId")
    private String issrId;

    @XmlElement(name = "Drctn")
    private String drctn;

    @XmlElement(name = "SignSN")
    private String signSn;

    @XmlElement(name = "NcrptnSN")
    private String ncrptnSN;

    @XmlElement(name = "DgtlEnvlp")
    private String dgtlEnvlp;

}

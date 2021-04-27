package com.waylau.spring.cloud.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 19:23
 **/
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.NONE)
@Data
public class Root {
    @XmlElement(name = "MsgHeader")
    private MsgHeader MsgHeader;

    @XmlElement(name = "MsgBody")
    private MsgBody MsgBody;
}

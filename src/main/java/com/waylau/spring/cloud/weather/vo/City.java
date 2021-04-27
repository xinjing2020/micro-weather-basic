package com.waylau.spring.cloud.weather.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * City.
 * 
 * @since 1.0.0 2017年11月23日
 * @author <a href="https://waylau.com">Way Lau</a>
 * 便于对象与xml文件之间的转换
 */
@XmlRootElement(name = "d") // xml 文件的根元素
// 表明类内，什么样的成员 是 可以被xml 转化 传输的  可以是 FIELD PROPERTY ...
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
	@XmlAttribute(name = "d1")
	private String cityId;
	
	@XmlAttribute(name = "d2")
	private String cityName;
	
	@XmlAttribute(name = "d3")
	private String cityCode;
	
	@XmlAttribute(name = "d4")
	private String province;

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
}

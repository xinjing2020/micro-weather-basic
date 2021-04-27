package com.waylau.spring.cloud.weather.controller;

import com.waylau.spring.cloud.weather.util.ConstantUtils;
import com.waylau.spring.cloud.weather.util.XMLUtil;
import com.waylau.spring.cloud.weather.util.weatherResponses;
import com.waylau.spring.cloud.weather.vo.Policy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 19:49
 **/
@RestController
@RequestMapping(value = "/jaxb")
public class ObjectConvertXMLController {
    private static final Logger logger = LoggerFactory.getLogger(ObjectConvertXMLController.class);

    @RequestMapping(value = "/objectToXML", method= RequestMethod.POST)
    public weatherResponses objectToXML(@RequestBody Policy policy) {
        String path = "D:\\Policy.xml";
        logger.info("---将对象转换成File类型的xml Start---");
        String str = XMLUtil.convertToXml(policy, path);
        logger.info(str);
        logger.info("---将对象转换成File类型的xml End---");

        logger.info("---将File类型的xml转换成对象 Start---");
        Policy policyObj = (Policy) XMLUtil.convertXmlFileToObject(Policy.class, path);
        logger.info(policyObj.toString());
        logger.info("---将File类型的xml转换成对象 End---");
        return new weatherResponses (ConstantUtils.SUCCESS_CODE,null,ConstantUtils.SUCCESS);
    }
}

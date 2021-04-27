package com.waylau.spring.cloud.weather.vo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;


/**
 * @author: wangxiaobo
 * @create: 2021-04-26 18:13
 **/
public class XmlTest {
    public static void main(String[] args) {
        XMLString();
        Classroom classroom = new Classroom (1,"小波",14);
        Student student = new Student (41 ,"小丑",15,classroom);
        System.out.println ("student:"+student);
        try {
            // 对象转为XML的接口
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = context.createMarshaller ();
            marshaller.marshal (student,System.out);
        } catch (JAXBException e) {
            e.printStackTrace ();
        }
    }
    public static void XMLString(){
        String xmlStr ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student><age>15</age><classroom><grade>14</grade><id>1</id><name>小波</name></classroom><id>41</id><name>小丑</name></student>";
//        Reader reader = null;
        try {
            JAXBContext context = JAXBContext.newInstance (Student.class);
            // XML 转为对象的接口
            Unmarshaller unmarshaller = context.createUnmarshaller ();
//            StringReader sr = new StringReader(xmlStr);
//            Reader reader = new StringReader(xmlStr);
            Student student = (Student) unmarshaller.unmarshal(new StringReader (xmlStr));
            System.out.println ("student:=>"+student.toString ());
            System.out.println(student.getAge());
            System.out.println(student.getClassroom().getName());
        } catch (JAXBException e) {
            e.printStackTrace ();
        }

    }
}

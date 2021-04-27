package com.waylau.spring.cloud.weather.vo;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangxiaobo
 * @create: 2021-04-27 10:03
 **/
public class readUTFCodingFile {
    public static void main(String[] args) throws Exception {
        // 读取XML文件
//        ClassPathResource pathResourcepathResource = new ClassPathResource ("citylist.xml");
//        readFileByRandomAccess( );
//        readFileByRandomAccess1();
//        readFileByRandomAccess2();
        shop();


    }
    public static void  readFileByRandomAccess( ){
        String s = ",";

        try {
            String file="D:/w.txt";
//            FileInputStream fis = new FileInputStream("D:/w.txt");
//            ClassPathResource pathResourcepathResource = new ClassPathResource("w.txt");
//            InputStreamReader streamReader = new InputStreamReader (pathResourcepathResource);
            InputStreamReader ir = new InputStreamReader(new FileInputStream (file),"UTF-8");
            BufferedReader br = new BufferedReader(ir);
//            BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (pathResourcepathResource.getInputStream (),"utf-8"));
            StringBuffer buffer = new StringBuffer ();
            while ((s=br.readLine ())!=null){
                 buffer.append (s);
                System.out.print(s);
            }
            br.close ();
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
    public static void readFileByRandomAccess1(){
        String s;
        try {
            String file="D:/w.txt";
            InputStreamReader ir = new InputStreamReader(new FileInputStream (file),"UTF-8");
            BufferedReader br = new BufferedReader(ir);
            while (br.ready ()){
                s=br.readLine ();
                System.out.println (s);
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
    public static void readFileByRandomAccess2() throws Exception {
      File file =  new File ("D:/w.txt");
        // 装载list
        List<String> list = new ArrayList<> ();
      FileInputStream fis =new FileInputStream(file);
      BufferedReader br = new BufferedReader(new InputStreamReader (fis));
      StringBuffer buffer = new StringBuffer();
      String s ;
      int i=0;
      while ((s=br.readLine ())!=null){
          System.out.println (s);
          if (i==0){
              buffer.append (s+ "\n");
          }else {
              // 判断截取点
              if (s.substring (0,1).equals (">")){
                  list.add (buffer.toString ());
                  buffer.append(s + "\n");
              }else {
                  buffer.append(s + "\n");
              }
          }
          i++;
      }
//       if (s==null){
//           list.add (buffer.toString ());
//       }
        // test
        System.out.println("--------------------------");
        for(int j=0; j<list.size(); j++) {
            System.out.println( j + ":   " + list.get(j));
            System.out.println("-----------------------");
        }
    }
    public static void shop()  {
        BufferedReader bre = null;
        String str;
        try {
            String file = "D:/w.txt";
            bre = new BufferedReader (new FileReader (file));//此时获取到的bre就是整个文件的缓存流
            while ((str = bre.readLine ()) != null) { // 判断最后一行不存在，为空结束循环
                System.out.println (str);//原样输出读到的内容，此处即可根据规则进行内容切分
            }
        }catch (Exception e){

        }
    }

}

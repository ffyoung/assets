package com.qianyuan;

import java.io.File;
import java.io.FileOutputStream;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-04-22
 */
import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;

public class Test {
        public static void main(String args[]) throws Exception {
            // 异常抛出，不处理
            // 第1步、使用File类找到一个文件
            File f = new File("d:" + File.separator + "test.txt");    // 声明File对象
            // 第2步、通过子类实例化父类对象
            OutputStream out = null;    // 准备好一个输出的对象
            out = new FileOutputStream(f);    // 通过对象多态性，进行实例化
            // 第3步、进行写操作
            String str = "Hello World!!!";        // 准备一个字符串
            byte b[] = str.getBytes();            // 只能输出byte数组，所以将字符串变为byte数组
            out.write(b);                      // 将内容输出，保存文件
            // 第4步、关闭输出流
            out.close();                        // 关闭输出流
            //文件不存在会自动创建
        }
    }

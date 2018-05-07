package com.qianyuan.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-04-22
 */
@RequestMapping("test")
@Controller
public class TestController {

    @RequestMapping("down")
    public void outp(HttpServletResponse response) {

        InputStream in = null;
        try{
            in = new FileInputStream("E://up/Java.pdf");
            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            do {
                bytesRead = in.read(buffer, 0, buffer.length);
                response.getOutputStream().write(buffer, 0, bytesRead);
            } while (bytesRead == buffer.length);

        } catch (Exception e) {

        }finally{
            try {
                if (in != null) {
                    in.close();
                }
                response.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

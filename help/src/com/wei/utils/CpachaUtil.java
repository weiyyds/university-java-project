package com.wei.utils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
//验证码生成器
@WebServlet("/CpachaUtil")
public class CpachaUtil extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage bi = new BufferedImage(68, 28, BufferedImage.TYPE_INT_RGB);
        Graphics gs = bi.getGraphics();
        Color c = new Color(246, 240, 250);
        gs.setColor(c);
        gs.fillRect(0,0,68,28);

        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random ran = new Random();
        int len = ch.length,index;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            index = ran.nextInt(len);
            gs.setColor(new Color(CpachaUtil.getCorrectColor(196),CpachaUtil.getCorrectColor(162),CpachaUtil.getCorrectColor(129)));
            gs.drawString(ch[index] + "", (15 * i) + 8, 18);
            sb.append(ch[index]);
        }
        request.getSession().setAttribute("piccode", sb.toString());
        ImageIO.write(bi, "JPG", response.getOutputStream());
    }

    //Test.java
    public static int getCorrectColor(int a){
        Random ran = new Random();
        int temp = ran.nextInt(256);
        if (0 <= a - temp && a - temp < 40) {
            temp = a - 40;
        }
        if (a - temp < 0 && temp - a < 40) {
            temp = a + 40;
        }
        return temp;

   }

    }



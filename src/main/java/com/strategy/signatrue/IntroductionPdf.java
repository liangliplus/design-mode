package com.strategy.signatrue;

import org.springframework.web.servlet.DispatcherServlet;

import java.util.Arrays;

/**
 * 外传的pdf
 */
public class IntroductionPdf implements Pdf {
    @Override
    public void generate(String uid,byte[] signByte) {
        System.out.println("根据用户id"+uid+"获取文件服务pdf");
        byte[] originByte = new byte[1024];
        byte[] result = Arrays.copyOf(originByte, originByte.length + signByte.length);
        System.arraycopy(signByte, 0, result, originByte.length, signByte.length);
        System.out.println("获取签名服务器pdf长度"+originByte.length+"生成新pdf长度 ："+result.length);
    }
}

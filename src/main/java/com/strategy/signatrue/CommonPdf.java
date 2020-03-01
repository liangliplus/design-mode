package com.strategy.signatrue;

public class CommonPdf implements Pdf {
    @Override
    public void generate(String uid,byte[] signByte) {
        System.out.println("直接生成pdf,生成pdf字节数组长度 "+signByte.length);
    }
}

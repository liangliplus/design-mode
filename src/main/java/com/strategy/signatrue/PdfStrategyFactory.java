package com.strategy.signatrue;

import java.util.HashMap;
import java.util.Map;

public class PdfStrategyFactory {
    private static Map<String,Pdf> PDF_STRATEGY = new HashMap<>();
    public static final String COMMON_PDF = "common";//普通的
    public static final String INTRODUCTION_PDF = "introduction";//外传方式
    static {
        PDF_STRATEGY.put(COMMON_PDF,new CommonPdf());
        PDF_STRATEGY.put(INTRODUCTION_PDF,new IntroductionPdf());

    }
    private PdfStrategyFactory(){}

    public static Pdf getPdf(String key){
        if(!PDF_STRATEGY.containsKey(key)){
            return PDF_STRATEGY.get(COMMON_PDF);
        }
        return PDF_STRATEGY.get(key);
    }



}

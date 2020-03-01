package com.strategy.signatrue;

public class User {
    private String id;
    private byte[] caByte;

    public User(String id, byte[] caByte) {
        this.id = id;
        this.caByte = caByte;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getCaByte() {
        return caByte;
    }

    public void setCaByte(byte[] caByte) {
        this.caByte = caByte;
    }

    public void generatePdf(String key){
        Pdf pdf = PdfStrategyFactory.getPdf(key);
        pdf.generate(id,caByte);
    }
}

package com.test;

public class Demo {

    public static void main(String[] args) {
        final int start = Integer.MAX_VALUE - 100;
        final int end = Integer.MAX_VALUE;
        int count = 0;
        for (int i = start;i<=end;i++){
            count++;
            if(i<0){
                System.out.println(i);
            }
        }
        System.out.println(count);


    }
}

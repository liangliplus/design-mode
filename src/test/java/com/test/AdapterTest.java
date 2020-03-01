package com.test;

import com.adapter.charge.PatcherBoard;
import com.adapter.charge.PowerAdapter;
import com.adapter.loginadapter.SiginService;
import com.adapter.loginadapter.SiginServiceAdapter;
import org.junit.Test;

import java.security.Signature;

public class AdapterTest {
    @Test
    public void appleChargeTest(){
        PowerAdapter powerAdapter = new PowerAdapter(new PatcherBoard());
        System.out.println(powerAdapter.outPutDC5());
    }
    @Test
    public void loginAdapterTest(){
        SiginServiceAdapter siginServiceAdapter = new SiginServiceAdapter(new SiginService());
        siginServiceAdapter.loginForQQ("ewewewwfff");
    }


}

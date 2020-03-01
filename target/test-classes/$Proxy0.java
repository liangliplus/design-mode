package com.proxy.customerjdkproxy;	
import com.proxy.Person;	
import java.lang.reflect.Method;	
public class $Proxy0 implements com.proxy.Person{	
CustomerInvocationHandler h;	
public $Proxy0(CustomerInvocationHandler h){this.h = h;	
}	
public final void buyInsurance(){	
try{	
Method m =com.proxy.Person.class.getMethod("buyInsurance",new Class[]{});	
 h.invoke(this,m,null);	
}catch(Throwable e){	
e.printStackTrace();	
}	
}	
}
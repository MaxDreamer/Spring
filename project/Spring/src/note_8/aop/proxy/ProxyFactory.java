package note_8.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 马昕 on 2018/10/15.
 */
public class ProxyFactory implements InvocationHandler{
    private Object stu;
    public Object createStudentProxy(Object stu){
        this.stu=stu;
        return Proxy.newProxyInstance(stu.getClass().getClassLoader(),
                stu.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StudentBean s=(StudentBean)stu;
        Object object=null;
        if(s.getName()!=null){
            object=method.invoke(stu,args);
        }else{
            System.out.println("名称为空 代理类已经进行拦截");
        }
        return object;
    }
}

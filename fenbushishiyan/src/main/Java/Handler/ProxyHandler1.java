package Handler;

import C_and_S.sockerclient;
import JavaBean.request;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class ProxyHandler1{
	
	private sockerclient sock = new sockerclient();
	@SuppressWarnings("unchecked")
	public  <T> T getProxy(Class<T> clazz, final String ip, final int i){
		InvocationHandler handler=new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				request request = new request();
				request.setClassName(method.getDeclaringClass().getName());
				request.setMethodName(method.getName());
				request.setParamTypes(method.getParameterTypes());
				request.setParams(args);
                return sock.invoke(request, ip, i);
			}
		};
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
				new Class<?>[]{clazz},handler);
	}
	/*private ATMcard object;
	
	public ProxyHandler1(ATMcard object){
		this.object = object;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		XmlReader.readXml("aop.xml");
		Class<?> clazz = check.class;
		Object result=null;
		if(method.getName().equals("login")){
			//处理before方法
			if(beforeMethod!=null&&beforeMethod.length()>0){
				Method m=clazz.getMethod(beforeMethod);
				Object obj = clazz.newInstance();
				m.invoke(obj,args);
			}

			//处理目标方法
			result= method.invoke(object, args);

			//处理after方法
			if(afterMethod!=null&&afterMethod.length()>0){
				Method m=clazz.getMethod(afterMethod,String.class,String.class);
				Object obj = clazz.newInstance();
				m.invoke(obj,args);
			}
		}
		else {
			result= method.invoke(object, args);
		}
		return result;
	}*/

}

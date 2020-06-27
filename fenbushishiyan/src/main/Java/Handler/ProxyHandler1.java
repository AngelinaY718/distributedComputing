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
}

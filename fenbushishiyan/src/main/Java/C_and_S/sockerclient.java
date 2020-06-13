package C_and_S;

import com.yky.entity.Card;
import com.yky.entity.request;
import com.yky.entity.response;
import com.yky.xmlandproxy.XmlReader;
import com.yky.xmlandproxy.check;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class sockerclient {
    private Socket sock;
    public static String beforeMethod = "";
    public static String afterMethod = "";
    public static String beforeMethod1 = "";
    public static String afterMethod1 = "";

    public sockerclient(){
    }

    public Socket check( String Ip, int port) {
        Socket socket= null;
        try {
            socket = new Socket(Ip,port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return socket;
    }

    public Object invoke(request request, String Ip, int port)
            throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object result=null;
        sock = check(Ip,port);
        if(sock!=null){
            InputStream in = sock.getInputStream();
            OutputStream out = sock.getOutputStream();
            ObjectOutputStream objOut;
            ObjectInputStream objIn;
            response response = null;
            if(request.getMethodName().equals("login")){
                XmlReader.readXml("aop.xml");
                Class<?> clazz = check.class;
                //处理before方法
                if(beforeMethod!=null&&beforeMethod.length()>0){
                    Method m=clazz.getMethod(beforeMethod);
                    Object obj = clazz.newInstance();
                    m.invoke(obj,request.getParams());
                }
                //处理目标方法
                try {
                    objOut = new ObjectOutputStream(out);
                    objOut.writeObject(request);
                    objOut.flush();
                    objIn = new ObjectInputStream(in);
                    Object res = objIn.readObject();
                    if (res instanceof response) {
                        response = (response) res;
                    } else {
                        throw new RuntimeException("返回對象不正确!!!");
                    }
                } catch (Exception e) {
                    System.out.println("error:   " + e.getMessage());
                } finally {
                    out.close();
                    in.close();
                    sock.close();
                }
                //处理after方法
                if(afterMethod!=null&&afterMethod.length()>0){
                    Method m=clazz.getMethod(afterMethod,String.class,String.class);
                    Object obj = clazz.newInstance();
                    m.invoke(obj,request.getParams());
                }
            }
           /* else if(request.getMethodName().equals("draw")){
                XmlReader.readXml("aop1.xml");
                Class<?> clazz = check.class;
                //处理before方法
                if(beforeMethod!=null&&beforeMethod.length()>0){
                    Method m=clazz.getMethod(beforeMethod);
                    Object obj = clazz.newInstance();
                    m.invoke(obj,request.getParams());
                }
                //处理目标方法
                try {
                    objOut = new ObjectOutputStream(out);
                    objOut.writeObject(request);
                    objOut.flush();
                    objIn = new ObjectInputStream(in);
                    Object res = objIn.readObject();
                    if (res instanceof response) {
                        response = (response) res;
                    } else {
                        throw new RuntimeException("返回對象不正确!!!");
                    }
                } catch (Exception e) {
                    System.out.println("error:   " + e.getMessage());
                } finally {
                    out.close();
                    in.close();
                    sock.close();
                }
                //处理after方法
                if(afterMethod!=null&&afterMethod.length()>0){
                    Method m=clazz.getMethod(afterMethod, Card.class,int.class);
                    Object obj = clazz.newInstance();
                    m.invoke(obj,request.getParams());
                }
            }*/
            else {
                try {
                    objOut = new ObjectOutputStream(out);
                    objOut.writeObject(request);
                    objOut.flush();
                    objIn = new ObjectInputStream(in);
                    Object res = objIn.readObject();
                    if (res instanceof response) {
                        response = (response) res;
                    } else {
                        throw new RuntimeException("返回對象不正确!!!");
                    }
                } catch (Exception e) {
                    System.out.println("error:   " + e.getMessage());
                } finally {
                    out.close();
                    in.close();
                    sock.close();
                }
            }
            result=response.getObj();
        }
        else{
            String s="无法连接";
            System.out.println(s);
            result=s;
        }
        return  result;

    }
}

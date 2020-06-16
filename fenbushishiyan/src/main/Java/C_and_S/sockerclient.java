package C_and_S;



import JavaBean.request;
import JavaBean.response;

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

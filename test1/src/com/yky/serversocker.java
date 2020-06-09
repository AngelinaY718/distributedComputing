package com.yky;

import com.yky.entity.request;
import com.yky.entity.response;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class serversocker implements Runnable{
    private Socket sockClient;
    private Map<String, Class> serviceRegistry = new HashMap<String, Class>();
    private response response = new response();

    public serversocker (Socket sock) {
        super();
        this.sockClient = sock;
    }

    public void run() {
        try {
            OutputStream out = sockClient.getOutputStream();
            // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
            InputStream in = sockClient.getInputStream();

            ObjectInputStream objIn = new ObjectInputStream(in);
            ObjectOutputStream objOut = new ObjectOutputStream(out);

            // 2. 获取请求数据，强转参数类型
            Object param = objIn.readObject();
            request request = null;
            if(!(param instanceof request)){
                response.setMessage("参数错误");
                objOut.writeObject(response);
                objOut.flush();
                return;
            }else{
                request = (request) param;
            }

            // 3. 查找并执行服务方法
            System.out.println("要執行的类型为：" + request.getClassName());
            Class<?>  service = serviceRegistry.get(request.getClassName());
            if(service != null) {
                Method method = service.getMethod(request.getMethodName(), request.getParamTypes());
                Object result = method.invoke(service.newInstance(), request.getParams());
                // 4. 得到结果并返回
                response.setObj(result);
            }
            objOut.writeObject(response);
            objOut.flush();
            out.close();
            in.close();
            sockClient.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void registerService(Class iface, Class Imp) {
        this.serviceRegistry.put(iface.getName(),Imp);
    }
}

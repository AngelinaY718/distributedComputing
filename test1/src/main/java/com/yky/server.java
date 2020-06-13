package com.yky;

import com.yky.iml.ATMcard;
import com.yky.iml.Atm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class server {
    private ServerSocket serverSocket;
    private int servPort;

    public server(int port) throws IOException {
        this.servPort = port;
        serverSocket = new ServerSocket(this.servPort);

    }
    public void start(){
        ThreadPoolExecutor threadPool =new ThreadPoolExecutor(5, 10,
                200, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
        while (true) {
            try {
                Socket sock = serverSocket.accept();
                serversocker service = new serversocker(sock);
                service.registerService( ATMcard.class,Atm.class);
                threadPool.execute(service);
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void main(String[] args) throws IOException {
        server server=new server(12000);
        System.out.println("端口号：12000");
        server.start();
    }
}

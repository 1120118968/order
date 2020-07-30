package com.main.activity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;


public class ClientThread implements Runnable{
	private Socket s;
    public String Attribute;
    public String content = null;
    String name;
    String password;
    String id;
    String commend;
    // 定义向UI线程发送消息的Handler对象

    private Handler handler;

    // 定义接收UI线程的消息的Handler对象

    public Handler revHandler;


    // 该线程所处理的Socket所对应的输入流


    BufferedReader br = null;


    OutputStream os = null;

    public ClientThread(Handler handler) {
        this.handler = handler;
        // 创建revHandler对象
//构造函数传值时实例化对象 确保进入页面时发送消息时对象不为空
        revHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {

                // 接收到UI线程中用户输入的数据

                if (msg.what == 0x345) {

                    // 将用户在文本框内输入的内容写入网络

                    String ip = s.getInetAddress().getHostAddress();
                    try {

                        os.write((msg.obj.toString()+" "+ip+ "\r\n").getBytes("utf-8"));

                    } catch (Exception
                            e) {

                        e.printStackTrace();

                    }

                }

            }

        };

    }

    public void run() {

        try {
            //192.168.191.2为本机的ip地址，30000为与MultiThreadServer服务器通信的端口
            s = new Socket("192.168.1.104", 9999);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            os = s.getOutputStream();
            // 启动一条子线程来读取服务器响应的数据
            new Thread() {
                @Override
                public void run() {
                    // 不断读取Socket输入流中的内容。
                    try {

                        while ((content = br.readLine()) != null) {
                            //每当读到来自服务器的数据之后，发送消息通知程序界面显示该数据
                            Message msg = new Message();
                            msg.obj = content;
                            String[] strarray = content.split(" ");
                            for (int i = 0; i < strarray.length; i++)
                                System.out.println(strarray[i] + " ");

                            System.out.println(content);

                            String command = strarray[2];

                            if (command.equals("Ys")) {//login
                                //if psd=s psd
                                msg.what = 0x123;
                                msg.obj = content;
                                if(handler!=null){
                                    handler.sendMessage(msg);}

                            } else if (command.equals("YRs")){//register
                                msg.what = 0x1234;
                                msg.obj = content;
                                if(handler!=null){
                                    handler.sendMessage(msg);}
                            } else if ( command.equals("SQ")){//qd
                                msg.what = 0x12;
                                msg.obj = content;
                                if(handler!=null){
                                    handler.sendMessage(msg);}
                            }else if (command.equals("SQY")){//签到成功
                                msg.what = 0x12345;
                                msg.obj = content;
                                if(handler!=null){
                                    handler.sendMessage(msg);}
                            }else if (command.equals("SR")){//得到题目成功
                                msg.what = 0x111;
                                msg.obj = content;
                                if(handler!=null){
                                handler.sendMessage(msg);}
                            }
                            else{
                                //warring
                                msg.what = 0x000;
                                msg.obj = content;
                                if(handler!=null){
                                    handler.sendMessage(msg);}
                            }




                        }

                    } catch (IOException
                            e) {

                        e.printStackTrace();

                    }

                }

            }.start();
            // 为当前线程初始化Looper

            Looper.prepare();



            // 启动Looper

            Looper.loop();


        } catch (SocketTimeoutException e1) {
            System.out.println("网络连接超时！！");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

	}



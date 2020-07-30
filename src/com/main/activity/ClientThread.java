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
    // ������UI�̷߳�����Ϣ��Handler����

    private Handler handler;

    // �������UI�̵߳���Ϣ��Handler����

    public Handler revHandler;


    // ���߳��������Socket����Ӧ��������


    BufferedReader br = null;


    OutputStream os = null;

    public ClientThread(Handler handler) {
        this.handler = handler;
        // ����revHandler����
//���캯����ֵʱʵ�������� ȷ������ҳ��ʱ������Ϣʱ����Ϊ��
        revHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {

                // ���յ�UI�߳����û����������

                if (msg.what == 0x345) {

                    // ���û����ı��������������д������

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
            //192.168.191.2Ϊ������ip��ַ��30000Ϊ��MultiThreadServer������ͨ�ŵĶ˿�
            s = new Socket("192.168.1.104", 9999);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            os = s.getOutputStream();
            // ����һ�����߳�����ȡ��������Ӧ������
            new Thread() {
                @Override
                public void run() {
                    // ���϶�ȡSocket�������е����ݡ�
                    try {

                        while ((content = br.readLine()) != null) {
                            //ÿ���������Է�����������֮�󣬷�����Ϣ֪ͨ���������ʾ������
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
                            }else if (command.equals("SQY")){//ǩ���ɹ�
                                msg.what = 0x12345;
                                msg.obj = content;
                                if(handler!=null){
                                    handler.sendMessage(msg);}
                            }else if (command.equals("SR")){//�õ���Ŀ�ɹ�
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
            // Ϊ��ǰ�̳߳�ʼ��Looper

            Looper.prepare();



            // ����Looper

            Looper.loop();


        } catch (SocketTimeoutException e1) {
            System.out.println("�������ӳ�ʱ����");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

	}



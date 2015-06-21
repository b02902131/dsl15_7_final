package com.example.mac.magiclock;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by bob on 2015/5/31.
 */
public class SocketClient {

//    private static int numByte = 512;

    public String cnnct (String address, int port, String msg, int type) {
        try {

            Log.d("happy", "0");
            Socket client = new Socket();
            InetSocketAddress isa = new InetSocketAddress(address, port);
            Log.d("happy", "1");
            client.connect(isa, 10000);
            BufferedOutputStream out = new BufferedOutputStream(client.getOutputStream());
            BufferedInputStream in = new BufferedInputStream(client.getInputStream());


//            // 送出字串
//            out.write((led_number).getBytes());
//            out.flush();
            out.write(msg.getBytes());
            out.flush();

            Log.d("happy", "2");

            String temp = new String();

            if(type == 0) {


                Log.d("happy", "2.54");
                int numByte = in.available();
                while (numByte == 0){
                    Log.d("happy", "2.55");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    numByte = in.available();
                }
                Log.d("happy", Integer.toString(numByte));
                byte[] buf = new byte[numByte];
                Log.d("happy", "2.56");
                in.read(buf);

                Log.d("happy", "2.7");
                temp = new String(buf);
                Log.d("happy", "2.8");
                Log.d(temp, "temp");
            }

            Log.d("happy", "3");

            out.close();
            client.close();
            return temp;
        } catch (java.io.IOException e) {
            Log.d("sad","0");
            System.out.println("Socket error");
            System.out.println("IOException :" + e.toString());
            return  "catch in socket";
        }
    }
}
package com.example.test_apple.Service;

import org.zeroturnaround.exec.ProcessExecutor;
import java.io.*;
import java.util.concurrent.TimeoutException;

public class IPservice {

    public void startIpservice(String ip) throws InterruptedException, TimeoutException, IOException {
        System.out.println("=================================");
        System.out.println(java.time.LocalDateTime.now() +" IP service Started");
        String com = "./ip >> ip_server.csv";
        String output = new ProcessExecutor().command("./start", ip)
                .readOutput(true).execute()
                .outputUTF8();
        System.out.println(java.time.LocalDateTime.now() +" IP adress is: " + ip);
        System.out.println(java.time.LocalDateTime.now() +" IP service Finished");
        System.out.println("=================================");
    }

}

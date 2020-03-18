package Github.Modules;

import com.github.opendevl.JFlat;
import org.zeroturnaround.exec.ProcessExecutor;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.TimeoutException;


public class IPservice {
    public String ip;
    private String output;


    public void startIpservice(String ip) throws IOException, TimeoutException, InterruptedException {
        System.out.println("=================================");
        System.out.println(java.time.LocalDateTime.now() +" IP service started");
        deleting();
        creating();
        try {
            output = jsonRequest(ip);
        } catch (InterruptedException | IOException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            System.out.println(java.time.LocalDateTime.now() +" Request finished");
        }
        try {
            saveOutputLog(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println(java.time.LocalDateTime.now() + " Writing finished");
        }

        deleteRows();
        try {
            toCsv();
        }
        catch (RuntimeException e){
            System.out.println(java.time.LocalDateTime.now() + "Error in JSON");
            deleting();

        }

        congate();
        deleting();
        System.out.println("=================================");

    }

    private String jsonRequest(String ip) throws InterruptedException, TimeoutException, IOException {
         output = new ProcessExecutor().command("curl","extreme-ip-lookup.com/json/" + ip)
                .readOutput(true).execute()
                .outputUTF8();
        return output;
    }

    private void saveOutputLog(String output) throws IOException {

        try (FileWriter nFile = new FileWriter("pre_request.json")) {
            nFile.write(output);
        }
    }

    private void deleteRows() throws IOException {
        String file =("/Users/fsociety/IdeaProjects/resume/pre_request.json");
        String rdyfile =("/Users/fsociety/IdeaProjects/resume/request.json");

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        line = br.readLine();
        line = br.readLine();
        line = br.readLine();
        line = br.readLine();
        line = br.readLine();
        line = br.readLine();
        while(line!= null)
        {
            String contentToAppend =line +"\n";
            Files.write(
                    Paths.get(rdyfile),
                    contentToAppend.getBytes(),
                    StandardOpenOption.APPEND);
            //System.out.println(java.time.LocalDateTime.now() + line);
            line = br.readLine();

        }
        fr.close();
        System.out.println(java.time.LocalDateTime.now() +" Preparing JSON finished");
    }

    private void toCsv() throws IOException, IllegalArgumentException {
        String str = new String(Files.readAllBytes(Paths.get("/Users/fsociety/IdeaProjects/resume/request.json")));

        JFlat flatMe = new JFlat(str);

        List<Object[]> json2csv = flatMe.json2Sheet().getJsonAsSheet();
        try {
            flatMe.headerSeparator(); //remove "/"
        } catch (Exception e) {
            e.printStackTrace();
        }
        flatMe.write2csv("/Users/fsociety/IdeaProjects/resume/file1.csv");

    }

    private void congate() throws IOException {
        String file_take =("/Users/fsociety/IdeaProjects/resume/file1.csv");
        String file_write=("/Users/fsociety/IdeaProjects/resume/file.csv");

        FileReader fr = new FileReader(file_take);
        BufferedReader br = new BufferedReader(fr);
        String line;
package com.example.test_apple.Service;

import com.github.opendevl.JFlat;
import org.zeroturnaround.exec.ProcessExecutor;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.TimeoutException;


        public class IPservice_test {
            public String ip;
            private String output;


            public void startIpservice(String ip) throws IOException, TimeoutException, InterruptedException {
                System.out.println("=================================");
                System.out.println(java.time.LocalDateTime.now() +" IP service started");
                deleting();
                creating();
                try {
                    output = jsonRequest(ip);
                } catch (InterruptedException | IOException | TimeoutException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(java.time.LocalDateTime.now() +" Request finished");
                }
                try {
                    saveOutputLog(output);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    System.out.println(java.time.LocalDateTime.now() + " Writing finished");
                }

                deleteRows();
                try {
                    toCsv();
                }
                catch (RuntimeException e){
                    System.out.println(java.time.LocalDateTime.now() + "Error in JSON");
                    deleting();

                }

                congate();
                deleting();
                System.out.println("=================================");

            }

            private String jsonRequest(String ip) throws InterruptedException, TimeoutException, IOException {
                output = new ProcessExecutor().command("curl","extreme-ip-lookup.com/json/" + ip)
                        .readOutput(true).execute()
                        .outputUTF8();
                return output;
            }

            private void saveOutputLog(String output) throws IOException {

                try (FileWriter nFile = new FileWriter("pre_request.json")) {
                    nFile.write(output);
                }
            }

            private void deleteRows() throws IOException {
                String file =("/Users/fsociety/IdeaProjects/Amazon_Deploy/pre_request.json");
                String rdyfile =("/Users/fsociety/IdeaProjects/Amazon_Deploy/request.json");

                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                line = br.readLine();
                line = br.readLine();
                line = br.readLine();
                line = br.readLine();
                line = br.readLine();
                line = br.readLine();
                while(line!= null)
                {
                    String contentToAppend =line +"\n";
                    Files.write(
                            Paths.get(rdyfile),
                            contentToAppend.getBytes(),
                            StandardOpenOption.APPEND);
//            System.out.println(java.time.LocalDateTime.now() + line);
                    line = br.readLine();

                }
                fr.close();
                System.out.println(java.time.LocalDateTime.now() +" Preparing JSON finished");
            }

            private void toCsv() throws IOException, IllegalArgumentException {
                String str = new String(Files.readAllBytes(Paths.get("/Users/fsociety/IdeaProjects/Amazon_Deploy/request.json")));

                JFlat flatMe = new JFlat(str);

                List<Object[]> json2csv = flatMe.json2Sheet().getJsonAsSheet();
                try {
                    flatMe.headerSeparator(); //remove "/"
                } catch (Exception e) {
                    e.printStackTrace();
                }
                flatMe.write2csv("/Users/fsociety/IdeaProjects/Amazon_Deploy/file1.csv");

            }

            private void congate() throws IOException {
                String file_take =("/Users/fsociety/IdeaProjects/Amazon_Deploy/file1.csv");
                String file_write=("/Users/fsociety/IdeaProjects/Amazon_Deploy/file.csv");

                FileReader fr = new FileReader(file_take);
                BufferedReader br = new BufferedReader(fr);
                String line;

                line = br.readLine();
                line = br.readLine();
//        System.out.println(line);

                String contentToAppend = "\n" +line;
                Files.write(
                        Paths.get(file_write),
                        contentToAppend.getBytes(),
                        StandardOpenOption.APPEND);



                fr.close();
                System.out.println("IP service finished");
            }
            private void deleting() throws InterruptedException, TimeoutException, IOException {
                new ProcessExecutor().command("rm","-rf","request.json")
                        .readOutput(true).execute()
                        .outputUTF8();
                new ProcessExecutor().command("rm","-rf","pre_request.json")
                        .readOutput(true).execute()
                        .outputUTF8();
            }

            private void creating() throws InterruptedException, TimeoutException, IOException {
                new ProcessExecutor().command("touch","request.json")
                        .readOutput(true).execute()
                        .outputUTF8();

                new ProcessExecutor().command("touch","pre_request.json")
                        .readOutput(true).execute()
                        .outputUTF8();
            }


        }

        line = br.readLine();
        line = br.readLine();
//        System.out.println(line);

        String contentToAppend = "\n" +line;
        Files.write(
                Paths.get(file_write),
                contentToAppend.getBytes(),
                StandardOpenOption.APPEND);



        fr.close();
        System.out.println("IP service finished");
    }
    private void deleting() throws InterruptedException, TimeoutException, IOException {
        new ProcessExecutor().command("rm","-rf","request.json")
                .readOutput(true).execute()
                .outputUTF8();
        new ProcessExecutor().command("rm","-rf","pre_request.json")
                .readOutput(true).execute()
                .outputUTF8();
    }

    private void creating() throws InterruptedException, TimeoutException, IOException {
        new ProcessExecutor().command("touch","request.json")
                .readOutput(true).execute()
                .outputUTF8();

        new ProcessExecutor().command("touch","pre_request.json")
                .readOutput(true).execute()
                .outputUTF8();
    }


}

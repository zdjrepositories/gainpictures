package main;

import util.GetPictures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ExtendsThread extends Thread {
    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("E:\\idea\\gainpictures\\src\\main\\java\\file\\"+Thread.currentThread().getName().substring(7,Thread.currentThread().getName().length()))),
                    "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                GetPictures.doGet(lineTxt);
            }
            br.close();
            System.out.println(Thread.currentThread().getName().substring(7,Thread.currentThread().getName().length())+" 工作完毕");
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }
    }
}

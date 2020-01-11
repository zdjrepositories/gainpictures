package main;

import util.ResolveSESA;

import java.io.*;

public class Main {
    public static void main(String[] args ){
//        int cnt = 0;
//        LineNumberReader reader = null;
//        try {
//            reader = new LineNumberReader(new FileReader("E:\\idea\\gainpictures\\src\\main\\java\\file\\sesa"));
//            @SuppressWarnings("unused")
//            String lineRead = "";
//            while ((lineRead = reader.readLine()) != null) {
//            }
//            cnt = reader.getLineNumber();
//        } catch (Exception ex) {
//            cnt = -1;
//            ex.printStackTrace();
//        } finally {
//            try {
//                reader.close();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        System.out.println(cnt);
//new ResolveSESA().resolve();
        for(int i=0;i<37;i++){
            new ExtendsThread().start();
        }
    }

}

package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class ResolveSESA {
    public void resolve(){
        try{

            FileReader fr = new FileReader("E:\\idea\\gainpictures\\src\\main\\java\\file\\sesa");
            BufferedReader br = new BufferedReader(fr);
            int readLineNum = 0;
            int processCount = 0;
            String line = "";
            StringBuffer sb = new StringBuffer();
            while((line = br.readLine()) != null){
                readLineNum ++ ;
                sb.append(line + "\r\n");
                if(readLineNum % 3000 == 0){
                    System.out.println("====第" + processCount + "次处理=====");
                    File file = new File("E:\\idea\\gainpictures\\src\\main\\java\\file\\"+processCount);
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(sb.toString().getBytes());
                    fos.flush();
                    sb.delete(0, sb.length());
                    System.out.println("=====第" + processCount + "次处理结束=====");
                    processCount ++;
                }
            }
            if(readLineNum % 3000 > 0){
                System.out.println("====第" + processCount + "次处理=====");
                File file = new File("E:\\idea\\gainpictures\\src\\main\\java\\file\\"+processCount);
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(sb.toString().getBytes());
                fos.flush();
                sb.delete(0, sb.length());
                System.out.println("=====第" + processCount + "次处理结束=====");
            }
        }catch (Exception e){

        }

    }
}

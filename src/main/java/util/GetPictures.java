package util;


import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
public class GetPictures {

    public static String doGet(String id) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String result = "";
        try {
            // 通过址默认配置创建一个httpClient实例
            httpClient = HttpClients.createDefault();
            // 创建httpGet远程连接实例
            HttpGet httpGet = new HttpGet("");
            // 设置请求头信息
            httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            httpGet.setHeader("Connection", "keep-alive");
            httpGet.setHeader("Upgrade-Insecure-Requests", "1");
            httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
            httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");
            httpGet.setHeader("Host", "outlook.office365.com");
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:72.0) Gecko/20100101 Firefox/72.0");
            httpGet.addHeader("Cookie", "");
            // 设置配置请求参数
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(700000)// 连接主机服务超时时间
                    .setConnectionRequestTimeout(700000)// 请求超时时间
                    .setSocketTimeout(1200000)// 数据读取超时时间
                    .build();
            // 为httpGet实例设置配置
            httpGet.setConfig(requestConfig);
            // 执行get请求得到返回对象
            response = httpClient.execute(httpGet);
            // 通过返回对象获取返回数据
            HttpEntity entity = response.getEntity();
            File file = new File("E:\\idea\\gainpictures\\src\\main\\java\\Pictures\\"+id+".jpg"); //图片下载的位置
            FileOutputStream op = new FileOutputStream(file);
            op.write(EntityUtils.toByteArray(entity));
            op.flush();
            op.close();
System.out.println(id);
        } catch (Exception e) {
            try {
                e.printStackTrace();
                System.out.println("报错"+id);
                FileOutputStream fos = new FileOutputStream("E:\\idea\\gainpictures\\src\\main\\java\\file\\出错",true);
                fos.write(( id+ "\r\n").getBytes());
                fos.flush();
            }catch (Exception e1){}
        } finally {
            try {
                System.out.println("完成"+id);
                FileOutputStream fos = new FileOutputStream("E:\\idea\\gainpictures\\src\\main\\java\\file\\完成",true);
                fos.write(( id+ "\r\n").getBytes());
                fos.flush();
            }catch (Exception e1){}
        }

        return result;
    }
}
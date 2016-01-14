package com.muzi.soap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 接口的链接（先根据用户号请求得到客户号，然后再根据客户号请求得到设备号及信息）----------返回值soapXml
 * 
 * @author 李泽宏
 * 
 */
public class SoapUrlConn {
    /**
     * soap 接口的链接方法
     * 
     * @param soapStr
     *            请求的字符串
     * @return 接口的返回值（soapXml）
     * @throws Exception
     */
    @SuppressWarnings("unused")
    public static String getSoapInputStream(String soapStr) throws Exception {
        HttpURLConnection connection;
        try {
            URL url = new URL("http://10.7.74.33:7804/openit/class_3");
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "text/xml");
            connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            connection.setRequestProperty("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
            connection.setRequestProperty("m", "http://www.shtel.com.cn/csb/v2/");
            connection.connect();
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            out.append(soapStr.toString());
            out.flush();
            out.close();

            BufferedReader reader;
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sbs = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sbs.append(lines);
                System.out.println("post返回值" + sbs);
            }
            reader.close();
            connection.disconnect();
            return sbs.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

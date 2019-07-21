package com.atguigu.gmall2019.mock.util;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author hzhstart
 * @since 2019-07-20 16:57
 */
public class LogUploader {

	public static void sendLogStream(String log){
		try{
			//不同的日志类型对应不同的URL

			URL url  =new URL("http://logserver/log");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//设置请求方式为post
			conn.setRequestMethod("POST");

			//时间头用来供server进行时钟校对的
			conn.setRequestProperty("clientTime",System.currentTimeMillis() + "");
			//允许上传数据
			conn.setDoOutput(true);
			//设置请求的头信息,设置内容类型为JSON
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			System.out.println("upload" + log);

			//输出流
			OutputStream out = conn.getOutputStream();
			out.write(("logString="+log).getBytes());
			out.flush();
			out.close();
			int code = conn.getResponseCode();
			System.out.println(code);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}

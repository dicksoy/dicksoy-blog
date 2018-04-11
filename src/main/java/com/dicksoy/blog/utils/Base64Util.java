package com.dicksoy.blog.utils;  

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;

import sun.misc.BASE64Decoder;  
import sun.misc.BASE64Encoder;  

@SuppressWarnings("restriction")
public class Base64Util {
	public static void main(String[] args) {  
		String strImg = "";
		try {
			strImg = getFileStrByPath("e://invite.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}  
		try {
			generateFile(strImg, "d://222.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 图片转化成base64字符串
	 * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	 * @param path 文件绝对路径 OR classPath
	 * @return
	 * @throws IOException
	 */
	public static String getFileStrByPath(String path) throws IOException {
		InputStream in = null;
		in = Base64Util.class.getClassLoader().getResourceAsStream(path);
		if (null == in)
			in = new FileInputStream(path);
		byte[] data = null;
		// 读取图片字节数组
		data = new byte[in.available()];
		in.read(data);
		in.close();
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);//返回Base64编码过的字节数组字符串 
	} 
	
	/**
	 * Base64转输出流
	 * @param imgStr Base64字符串
	 * @param outputStream 输出流 
	 * @return
	 * @throws IOException 
	 */
	public static void transitionStream(String imgStr, OutputStream outputStream) throws IOException{
		// 图像数据为空
		BASE64Decoder decoder = new BASE64Decoder();  
		// Base64解码  
		byte[] b = decoder.decodeBuffer(imgStr); 
		for (int i = 0; i < b.length; ++i) {
			// 调整异常数据  
			if (b[i] < 0) {
				b[i] += 256;  
			}
		}
		// 新生成的图片
		outputStream.write(b);
		outputStream.flush();
		outputStream.close();
	}  
	/**
	 * Base64转文件
	 * @param imgStr base64字符串
	 * @param filePath 生成文件路径
	 * @return
	 * @throws IOException 
	 */
	public static void generateFile(String imgStr, String filePath) throws IOException {
		OutputStream outputStream = new FileOutputStream(new File(filePath));
		transitionStream(imgStr, outputStream);
	}
}  
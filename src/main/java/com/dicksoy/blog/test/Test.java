package com.dicksoy.blog.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.dicksoy.blog.utils.QRCodeUtils;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class Test {
	
	private static String path = "image/" + "headshot.png";
	private static String content = "123123";
	private static int size = 300;
	@SuppressWarnings("unused")
	private static Integer frontColor = 0xFF000000;
	@SuppressWarnings("unused")
	private static Integer backgroundColor = 0xFFFFFFFF;
	private static InputStream logoIn = Test.class.getClassLoader().getResourceAsStream(path);
	private static OutputStream out = null;
	private static ErrorCorrectionLevel level = ErrorCorrectionLevel.M;
	
	public static void main(String[] args) throws FileNotFoundException {
		out = new FileOutputStream(new File("d:/123.jpg"));
		QRCodeUtils.generateQRImage(content, size, 0xFFFF8800, 0xFFFFF789, logoIn, out, level);
	}
	
	/*public static void main(String[] args) throws IOException {
	InputStream in = null;
	in = Test.class.getClassLoader().getResourceAsStream("qrCode123.jpg");
	System.out.println(in == null);
	in = Test.class.getClassLoader().getResourceAsStream("qrCode.jpg");
	System.out.println(in == null);
	byte[] data = null;
	try {
		data = new byte[in.available()];
		in.read(data);
		OutputStream out = new FileOutputStream(new File("e:/123123.jpg"));
		out.write(data);
		in.close();
		out.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}*/
}

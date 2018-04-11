package com.dicksoy.blog.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings({ "unused", "restriction" })
public class QRCodeUtils {

	static final String HB_TEMPLATE_1 ="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RGSitA2LyAOKapleUmHWegkos5vdDCIiIkpD6RsWAeA6GwrvMLsR05vjesB+m8PsZhAREVGaSu+wCMB6swOFm9N4n+IMlrcKyLsnZ3IvaCIiIqKp0j4sAoB1XQ7mbrVyDGOiSMDsTRIctbmAlUGciIiI9GXOoMDr7Cj6K2DsIxeGjyOjlwI0U85SIP+2bGCeBfwiEhERUSTpuc5iJH1ejB4eh+sMd3oxKqccyF9n5UQWIqKZJrsMyC4xuxUULbkXGDtvahOUdRYzMywqxn1Ah4zxDi8meoGJQcAnA94ZvLW0lAVY7IA1D8gqAnIWZAGLJSA/c4rIREREZL70XpTbqGwJWJaN7GUAhzMSERERJV5GTHAhIiIiInMwLBIRERGRLoZFIiIiItLFsEhEREREuhgWiYiIiEgXwyIRERER6WJYJCIiIiJdDItEREREpIthkYiIiIh0MSwSERERkS6GRSIiIiLSxbBIRERERLoYFomIiIhIF8MiEREREeliWCQiIiIiXQyLRERERKSLYZGIiIiIdDEsEhEREZEuhkUiIiIi0sWwSERERES6GBaJiIiISBfDIhERERHpYlgkIiIiIl0Mi0RERESki2GRiIiIiHQxLBIRERGRLoZFIiIiItLFsEhEREREuhgWiYiIiEgXwyIRERER6WJYJCIiIiJdDItEREREpIthkYiIiIh0MSwSERERka6sk1WvAgAsksktISIiIqK04fWJt1keay4AwGNiY4iIiIgoPWUpBxs3bjSzHURERESURj744AMAmrCYlZWlezIRERERzUyc4EJEREREuhgWiYiIiEgXwyIRERER6WJYJCIiIiJdDItEREREpIthkYiIiIh0MSwSERERkS6GRSIiIiLSxbBIRERERLoYFomIiIhIV9qExc7OzpAf7+npQWtrK9rb20O+PjAwgNbWVvT09MT03HD3Dm5fc3NzTM8I1t7eDrfbnZB7RaOzsxNNTU1ob2/H6Ohoyp9PREREmSctNoTu6enBhx9+iPz8fNx6662YPXu2/7Vr166hqakJTqcTZWVlU67t7u5GU1MT8vPzcc8990T97NOnT0OWZVy6dAm33XZbyHNaW1vR1NQEAJg3bx7mzp0b9XMUPT09OHr0KOx2O1atWoWKioqY7xWtEydOYHh4GADw5S9/OWXPJSIiosyVFmGxpaUFACDLMnJz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";
	/**
	 * 前景色
	 */
	private static final int ONCOLOR = 0xFF000000;
	/**
	 * 背景色
	 */
	private static final int OFFCOLOR = 0xFFFFFFFF;

	/**
	 * 默认黑白色二维码
	 * @param content 内容
	 * @param size 尺寸
	 * @param out 输出流
	 * @param level 纠错等级
	 */
	public static void generateQRImage(String content, int size, OutputStream out, ErrorCorrectionLevel level) {
		generateQRImage(content, size, null, null, null, out, level);
	}

	/**
	 * 默认纠错等级
	 * @param content
	 * @param size
	 * @param out
	 */
	public static void generateQRImage(String content, int size, OutputStream out) {
		generateQRImage(content, size, out, ErrorCorrectionLevel.M);
	}

	/**
	 * 加入logo二维码
	 * @param content
	 * @param size
	 * @param logoIn
	 * @param out
	 */
	public static void generateQRImageWithLogo(String content, int size, InputStream logoIn, OutputStream out) {
		generateQRImage(content, size, null, null, logoIn, out, ErrorCorrectionLevel.M);
	}
	/**
	 * 加入logo二维码
	 * @param content 二维码内容
	 * @param size 尺寸
	 * @param logoData logo数据byte[]
	 * @param out 输出流
	 */
	public static void generateQRImageWithLogo(String content, int size, byte[] logoData, OutputStream out) {
		InputStream logoIn = new ByteArrayInputStream(logoData);
		try {
			generateQRImage(content, size, null, null, logoIn, out, ErrorCorrectionLevel.M);
		} finally {
			IOUtils.closeQuietly(logoIn);
		}
	}

	/**
	 * 生成二维码图片
	 * @param content 二维码内容
	 * @param size 尺寸
	 * @param frontColor 前景色
	 * @param backgroundColor 背景色
	 * @param logoIn logo输入流
	 * @param out 输出流
	 * @param level 纠错等级
	 */
	public static void generateQRImage(String content, int size, Integer frontColor, Integer backgroundColor, InputStream logoIn, OutputStream out,
			ErrorCorrectionLevel level) {
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		// 指定纠错等级
		hints.put(EncodeHintType.ERROR_CORRECTION, level);
		// 指定编码格式
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		// 设置白边
		hints.put(EncodeHintType.MARGIN, 1); 
		try {
			int fColor = ONCOLOR;
			int bColor = OFFCOLOR;
			if (frontColor != null) {
				fColor = frontColor;
			}
			if (backgroundColor != null) {
				bColor = backgroundColor;
			}
			MatrixToImageConfig config = new MatrixToImageConfig(fColor, bColor);
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, size, size, hints);
			if (logoIn == null) {
				MatrixToImageWriter.writeToStream(bitMatrix, "png", out, config);
			} else {
				writeLogo(bitMatrix, logoIn, out);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static BufferedImage generateQRCodeImage(String content, int size, ErrorCorrectionLevel level)
			throws WriterException {
		Hashtable<EncodeHintType, Object> hashtable = new Hashtable<EncodeHintType, Object>();
		// 指定纠错等级
		hashtable.put(EncodeHintType.ERROR_CORRECTION, level);
		// 指定编码格式
		hashtable.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hashtable.put(EncodeHintType.MARGIN, 1); // 设置白边
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, size, size, hashtable);
		return toBufferedImage(bitMatrix);
	}

	public static BufferedImage createQRCode(final String url, OutputStream out) throws WriterException, IOException {  
		BufferedImage image = null;  
		MultiFormatWriter multiFormatWriter = new MultiFormatWriter();  
		Map<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();  
		// 设置编码方式  
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
		// 设置QR二维码的纠错级别（H为最高级别）具体级别信息  
		/*hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);*/  
		BitMatrix bitMatrix = multiFormatWriter.encode(url, BarcodeFormat.QR_CODE, 110, 110,hints);  
		bitMatrix = updateBit(bitMatrix, 0);  
		image = MatrixToImageWriter.toBufferedImage(bitMatrix);  
		return image;  
	}
	
	private static BitMatrix updateBit(final BitMatrix matrix, final int margin) {  
		int tempM = margin * 2;  
		//获取二维码图案的属性  
		int[] rec = matrix.getEnclosingRectangle();  
		int resWidth = rec[2] + tempM;  
		int resHeight = rec[3] + tempM;  
		// 按照自定义边框生成新的BitMatrix  
		BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);  
		resMatrix.clear();  
		//循环，将二维码图案绘制到新的bitMatrix中  
		for (int i = margin; i < resWidth - margin; i++) {  
			for (int j = margin; j < resHeight - margin; j++) {  
				if (matrix.get(i - margin + rec[0], j - margin + rec[1])) {  
					resMatrix.set(i, j);  
				}  
			}  
		}  
		return resMatrix;  
	}
	
	/**
	 * 写入带logo的二维码
	 * @param matrix
	 * @param logoin
	 * @param out
	 * @throws IOException
	 */
	public static void writeLogo(BitMatrix matrix, InputStream logoin, OutputStream out) throws IOException {
		BufferedImage bufferedImage = toBufferedImage(matrix);
		Graphics2D graphics2d = bufferedImage.createGraphics();
		int ratioWidth = bufferedImage.getWidth() * 2 / 10;
		int ratioHeight = bufferedImage.getHeight() * 2 / 10;
		// 载入logo
		Image img = ImageIO.read(logoin);
		int logoWidth = img.getWidth(null) > ratioWidth ? ratioWidth : img.getWidth(null);
		int logoHeight = img.getHeight(null) > ratioHeight ? ratioHeight : img.getHeight(null);

		int x = (bufferedImage.getWidth() - logoWidth) / 2;
		int y = (bufferedImage.getHeight() - logoHeight) / 2;

		graphics2d.drawImage(img, x, y, logoWidth, logoHeight, null);
		graphics2d.setColor(Color.black);
		graphics2d.setBackground(Color.WHITE);
		graphics2d.dispose();
		img.flush();
		ImageIO.write(bufferedImage, "png", out);
	}

	/**
	 * 生成二维码
	 * @param content 二维码内容
	 * @param size 大小
	 * @param level 纠错等级
	 * @return
	 * @throws WriterException
	 */
	public static BufferedImage generateQRImage(String content, int size, ErrorCorrectionLevel level)
			throws WriterException {
		Hashtable<EncodeHintType, Object> hashtable = new Hashtable<EncodeHintType, Object>();
		// 指定纠错等级
		hashtable.put(EncodeHintType.ERROR_CORRECTION, level);
		// 指定编码格式
		hashtable.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hashtable.put(EncodeHintType.MARGIN, 1); // 设置白边
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, size, size, hashtable);
		return toBufferedImage(bitMatrix);
	}
	
	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? ONCOLOR : OFFCOLOR);
			}
		}
		return image;
	}
	
	/**
	 * 生成带二维码的图片
	 * @param imagePath 图片路径
	 * @param content 二维码内容
	 * @param out 输出流
	 */
	public static void generateQRCodeImage(int x, int y, String imagePath, String content, OutputStream out) {
		try {
			InputStream in = QRCodeUtils.class.getClassLoader().getResourceAsStream(imagePath);
			if (null == in)
				in = new FileInputStream(new File(imagePath));
			BufferedImage qrCodeImage = generateQRImage(content, 10, ErrorCorrectionLevel.M);
			byte[] bytes = null;
			bytes = new byte[in.available()];
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
			BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
			Graphics graphics = bufferedImage.getGraphics();
			graphics.drawImage(qrCodeImage, x, y, null);
			ImageIO.write(bufferedImage, "png", out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

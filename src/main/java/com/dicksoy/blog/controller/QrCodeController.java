package com.dicksoy.blog.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.dicksoy.blog.utils.Base64Util;
import com.dicksoy.blog.utils.QRCodeUtils;

@Controller
@RequestMapping("/qrCode")
public class QrCodeController {

	@RequestMapping("/getQrcodess")
	public void getQrcodess(HttpServletRequest req, HttpServletResponse resp, String url, boolean isDownLoad)
			throws IOException {
		if (StringUtils.isNotEmpty(url)) {
			if (isDownLoad) {
				resp.setContentType("application/octet-stream");
				resp.setHeader("Content-Disposition", "attachment; filename=51zantuiguan.png");
			}
			ServletOutputStream stream = null;
			try {
				stream = resp.getOutputStream();
				String imageStr = Base64Util.getFileStrByPath("qrCode.jpg");
				QRCodeUtils.generateQRCodeImage(0, 0, imageStr, url, stream);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stream != null) {
					stream.flush();
					stream.close();
				}
			}
		}
	}
}

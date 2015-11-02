package cn.saymagic.weixin.server;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.saymagic.weixin.server.bean.MsgRequest;
import cn.saymagic.weixin.server.handler.BaseHandler;
import cn.saymagic.weixin.server.handler.EventHandler;
import cn.saymagic.weixin.server.handler.TextHandler;
import cn.saymagic.weixin.server.util.MsgXmlUtil;

public class WxApiServlet extends HttpServlet {
	Logger logger = Logger.getLogger(WxApiServlet.class.getName());

	public WxApiServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.info("##### valid url ");
		response.setContentType("text/plain");
		response.setStatus(200);
		response.setCharacterEncoding("UTF-8");
		if (request.getParameter("timestamp") == null) {
			response.getWriter().write("ª∂”≠∑√Œ !");
		} else {
			String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");

			if (validSign(signature, Config.TOKEN, timestamp, nonce)) {
				response.getWriter().write(echostr);
			} else {
				response.getWriter().write("Token–£—È ß∞‹£¨πˆµ∞!");
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BaseHandler handler = null;
		try {
			MsgRequest msgRequest = MsgXmlUtil.parseXml(request);
			if ("event".equals(msgRequest.getMsgType())) {
				handler = new EventHandler();
			} else if ("text".equals(msgRequest.getMsgType())) {
				handler = new TextHandler();
			} else if ("voice".equals(msgRequest.getMsgType())) {
				handler = new TextHandler();
			} else {
				handler = new EventHandler();
			}
			response.getWriter().write(handler.doHandleMsg(msgRequest));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean validSign(String signature, String tocken,
			String timestamp, String nonce) {
		String[] paramArr = new String[] { tocken, timestamp, nonce };
		Arrays.sort(paramArr);
		StringBuilder sb = new StringBuilder(paramArr[0]);
		sb.append(paramArr[1]).append(paramArr[2]);
		String ciphertext = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(sb.toString().getBytes());
			ciphertext = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return ciphertext != null ? ciphertext.equals(signature.toUpperCase())
				: false;
	}

	private static String byteToStr(byte[] byteArray) {
		String rst = "";
		for (int i = 0; i < byteArray.length; i++) {
			rst += byteToHex(byteArray[i]);
		}
		return rst;
	}

	private static String byteToHex(byte b) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(b >>> 4) & 0X0F];
		tempArr[1] = Digit[b & 0X0F];
		String s = new String(tempArr);
		return s;
	}

}
package cn.edu.zust.util;

import java.security.MessageDigest;

public class MD5Secrity {

	public static void main(String[] args) throws Exception {
		// String secret = data2secret("admin");
		// System.out.println(secret);
		// System.out.println(secret.length());
	}

	/**
	 * MD5: 单向加密 16位加密 通常应用在本地,一般加密私有数据,如密码. 保证管理员也看不到明文(原数据).
	 */
	public static String data2secret(String data) {
		try {
			// 获得MessageDigest实例
			MessageDigest digest = MessageDigest.getInstance("MD5");
			// 类似注册明文.
			digest.update(data.getBytes());
			// 加密
			byte[] bs = digest.digest();
			return byte2Hex(bs);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * byte数组转化成十六进制数字串
	 */
	public static String byte2Hex(byte[] bs) {
		StringBuffer sb = new StringBuffer();
		String temp = null;
		for (int i = 0; i < bs.length; i++) {
			temp = Integer.toHexString(bs[i] & 0xFF);
			if (temp.length() == 1) {
				sb.append("0");
				sb.append(temp);
			} else {
				sb.append(temp);
			}
		}
		return sb.toString().toUpperCase();
	}

}
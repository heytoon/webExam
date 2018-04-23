package com.http.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Tool {
	public static void Md5(String plainText){
		try { 
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(plainText.getBytes()); 
			byte b[] = md.digest(); 
			int i; 
			StringBuffer buf = new StringBuffer(""); 
			for (int offset = 0; offset < b.length; offset++) { 
				i = b[offset]; 
				if(i<0) i+= 256; 
				if(i<16) 
				buf.append("0"); 
				buf.append(Integer.toHexString(i)); 
			} 
			System.out.println("result: " + buf.toString());//32位的加密 
			System.out.println("result: " + buf.toString().substring(8,24));//16位的加密 
		} catch (NoSuchAlgorithmException e) { 
		e.printStackTrace(); 
		} 
	}

    // MD5加码。32位   
	public static String MD5(String inStr) {   
		MessageDigest md5 = null;   
			try {   
				md5 = MessageDigest.getInstance("MD5");   
			} catch (Exception e) {   
				System.out.println(e.toString());   
				e.printStackTrace();   
				return "";   
			}   
		char[] charArray = inStr.toCharArray();   
		byte[] byteArray = new byte[charArray.length];   
		for (int i = 0; i < charArray.length; i++){
			byteArray[i] = (byte) charArray[i];  
		}   
		byte[] md5Bytes = md5.digest(byteArray);   
		StringBuffer hexValue = new StringBuffer();   
		for (int i = 0; i < md5Bytes.length; i++) {   
			int val = ((int) md5Bytes[i]) & 0xff;   
			if (val < 16)   
			hexValue.append("0");   
			hexValue.append(Integer.toHexString(val));   
		}   
		return hexValue.toString();   
	}   

    //加密md5数据   
	public static String JMmd5(String inStr) {   
		char[] a = inStr.toCharArray();   
		for (int i = 0; i < a.length; i++) {   
			a[i] = (char) (a[i] ^ 't');   
		}   
		String s = new String(a);   
		return s;   
	}  

    // 解密md5
	public static String JM(String inStr) {   
		char[] a = inStr.toCharArray();   
		for (int i = 0; i < a.length; i++) {   
			a[i] = (char) (a[i] ^ 't');   
		}   
		String k = new String(a);   
		return k;   
	}

	public static void main(String[] args) {
			Md5("123456");
			String s = new String("123456");   
			System.out.println("原始：" + s);   
			System.out.println("MD5后：" + MD5(s));   
			System.out.println("MD5后再加密：" + JMmd5(MD5(s)));   
			System.out.println("解密为MD5后的：" + JM(JMmd5(MD5(s))));   
		}
	}

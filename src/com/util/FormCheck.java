package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FormCheck {
	public static boolean isPhoneLegal(String str) throws PatternSyntaxException {
		Pattern p = Pattern.compile("1\\d{10}");
		Matcher m = p.matcher(str);
		boolean b = m.matches();
		return b;
	}

	public static boolean isName(String str) {
		String regExp = "^(([\u4e00-\u9fa5]{2,8})|([a-zA-Z]{2,16}))$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	public static boolean isSno(String str) {
		String regExp = "^[\\d]{10}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	public static boolean isTno(String str) {
		String regExp = "^[\\d]{10}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	public static boolean isMark(String str) {
		String regExp = "^[\\d]{1}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	public static boolean isCno(String str) {
		String regExp = "^[\\d]{5}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	public static boolean isBirth(String str) {
		String regExp = "/^(19|20)\\d{2}-(1[0-2]|0?[1-9])-(0?[1-9]|[1-2][0-9]|3[0-1])$/";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	public static void main(String[] args) {
		System.out.println(isBirth("∏Ò Ω£∫xxxx-x-xx"));
	}
}

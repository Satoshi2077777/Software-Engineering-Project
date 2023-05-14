package com.util;

public class CommboxData {
	public static String[] getDepartments() {
		String[] departments = { "理学院", "文法学院", "信息学院", "材料学院", "经管学院", "国教学院", "机电学院" };
		return departments;
	}

	public static String[] getPlanYear() {
		String[] PlanYear = { "2015-2016", "2016-2017", "2017-2018", "2018-2019" };
		return PlanYear;
	}

	public static String[] getPlanTerm() {
		String[] PlanTerm = { "第一学期", "第二学期", "第三学期" };
		return PlanTerm;
	}

	public static String[] getMajor(int i) {
		String[] math = { "信息与计算科学", "物理", "应用数学" };
		String[] chinese = { "文学", "语文教育" };
		String[] computer = { "软件工程", "计算机网络" };
		String[] cailiao = { "高分子材料", "化学材料", "材料化学" };
		String[] fina = { "会计", "国际贸易", "信息管理与信息系统" };
		String[] guojiao = { "国际文化", "音乐教育" };
		String[] jidian = { "机械", "光电" };

		if (i == 1)
			return math;
		else if (i == 2)
			return chinese;
		else if (i == 3)
			return computer;
		else if (i == 4)
			return cailiao;
		else if (i == 5)
			return fina;
		else if (i == 6)
			return guojiao;
		else if (i == 7)
			return jidian;
		else {
			return null;
		}
	}

	public static String[] getProvinces() {
		String[] provinces = { "天津", "上海", "重庆", "河北", "河南", "云南", "辽宁", "黑龙江", "湖南", "安徽", "山东", "新疆", "江苏", "浙江",
				"江西", "湖北", "广西", "甘肃", "山西", "内蒙古", "陕西", "吉林", "福建", "贵州", "广东", "青海", "西藏", "宁夏", "海南", "台湾", "香港",
				"澳门" };
		return provinces;
	}

	public static String[] getSubjects() {
		String[] subjects = { "哲学", "经济学", "法学", "教育学", "文学", "历史学", "理学", "工学", "农学", "医学", "军事学", "管理学", "艺术学" };
		return subjects;
	}

	public static String[] getWeeks() {
		String[] weeks = { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天" };
		return weeks;
	}

	public static String[] getDays() {
		String[] days = { "12", "34", "56", "78" };
		return days;
	}

	public static String[] getPstatu() {
		String[] statu = { "空闲", "预约中", "预约成功", "已被占用" };
		return statu;
	}

	public static String[] getNations() {
		String[] nation = { "汉族", "蒙古族", "回族", "藏族", "维吾尔族", "苗族", "彝族", "壮族", "布依族", "朝鲜族", "满族", "侗族", "瑶族", "白族",
				"土家族", "哈尼族", "哈萨克族", "傣族", "黎族", "傈僳族", "佤族", "畲族", "高山族", "拉祜族", "水族", "东乡族", "纳西族", "景颇族", "柯尔克孜族",
				"土族", "达斡尔族", "仫佬族", "羌族", "布朗族", "撒拉族", "毛南族", "仡佬族", "锡伯族", "阿昌族", "普米族", "塔吉克族", "怒族", "乌孜别克族",
				"俄罗斯族", "鄂温克族", "德昂族", "保安族", "裕固族", "京族", "塔塔尔族", "独龙族", "鄂伦春族", "赫哲族", "门巴族", "珞巴族", "基诺族" };
		return nation;
	}
}

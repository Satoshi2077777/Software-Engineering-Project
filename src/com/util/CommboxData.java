package com.util;

public class CommboxData {
	public static String[] getDepartments() {
		String[] departments = { "��ѧԺ", "�ķ�ѧԺ", "��ϢѧԺ", "����ѧԺ", "����ѧԺ", "����ѧԺ", "����ѧԺ" };
		return departments;
	}

	public static String[] getPlanYear() {
		String[] PlanYear = { "2015-2016", "2016-2017", "2017-2018", "2018-2019" };
		return PlanYear;
	}

	public static String[] getPlanTerm() {
		String[] PlanTerm = { "��һѧ��", "�ڶ�ѧ��", "����ѧ��" };
		return PlanTerm;
	}

	public static String[] getMajor(int i) {
		String[] math = { "��Ϣ������ѧ", "����", "Ӧ����ѧ" };
		String[] chinese = { "��ѧ", "���Ľ���" };
		String[] computer = { "�������", "���������" };
		String[] cailiao = { "�߷��Ӳ���", "��ѧ����", "���ϻ�ѧ" };
		String[] fina = { "���", "����ó��", "��Ϣ��������Ϣϵͳ" };
		String[] guojiao = { "�����Ļ�", "���ֽ���" };
		String[] jidian = { "��е", "���" };

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
		String[] provinces = { "���", "�Ϻ�", "����", "�ӱ�", "����", "����", "����", "������", "����", "����", "ɽ��", "�½�", "����", "�㽭",
				"����", "����", "����", "����", "ɽ��", "���ɹ�", "����", "����", "����", "����", "�㶫", "�ຣ", "����", "����", "����", "̨��", "���",
				"����" };
		return provinces;
	}

	public static String[] getSubjects() {
		String[] subjects = { "��ѧ", "����ѧ", "��ѧ", "����ѧ", "��ѧ", "��ʷѧ", "��ѧ", "��ѧ", "ũѧ", "ҽѧ", "����ѧ", "����ѧ", "����ѧ" };
		return subjects;
	}

	public static String[] getWeeks() {
		String[] weeks = { "����һ", "���ڶ�", "������", "������", "������", "������", "������" };
		return weeks;
	}

	public static String[] getDays() {
		String[] days = { "12", "34", "56", "78" };
		return days;
	}

	public static String[] getPstatu() {
		String[] statu = { "����", "ԤԼ��", "ԤԼ�ɹ�", "�ѱ�ռ��" };
		return statu;
	}

	public static String[] getNations() {
		String[] nation = { "����", "�ɹ���", "����", "����", "ά�����", "����", "����", "׳��", "������", "������", "����", "����", "����", "����",
				"������", "������", "��������", "����", "����", "������", "����", "���", "��ɽ��", "������", "ˮ��", "������", "������", "������", "�¶�������",
				"����", "���Ӷ���", "������", "Ǽ��", "������", "������", "ë����", "������", "������", "������", "������", "��������", "ŭ��", "���α����",
				"����˹��", "���¿���", "�°���", "������", "ԣ����", "����", "��������", "������", "���״���", "������", "�Ű���", "�����", "��ŵ��" };
		return nation;
	}
}

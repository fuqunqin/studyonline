package cn.edu.zust.web.form;

public class Test {

	public static void main(String[] args) {
		String fileName = "����ѧϰ����ƽ̨�Ĺ���dfsdfs.doc";
		System.out.println(fileName);
		System.out.println(fileName.indexOf("."));
		System.out.println(fileName.substring(fileName.indexOf("."), fileName
				.length()));
	}

}

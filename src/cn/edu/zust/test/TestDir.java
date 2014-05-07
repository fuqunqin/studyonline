package cn.edu.zust.test;

public class TestDir {
	public static void main(String[] args) {
		String dir="D:progrom";
		String filePath="haha"+dir+"/share.jsp";
		String[] fs=filePath.split(dir);
		System.out.println(fs[1]);
	}
}

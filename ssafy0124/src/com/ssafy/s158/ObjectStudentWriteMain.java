package com.ssafy.s158;
import java.io.IOException;
import java.util.Vector;
public class ObjectStudentWriteMain {
	public static void main(String[] args) {
		ObjectStudentRWG<Student> osw=new ObjectStudentRWG< > ();
		Vector<Student> v=new Vector<>();
		v.add(new Student("ȫ�浿",17,"�Ѿ�"));
		v.add(new Student("ȫ���",15,"��õ"));
		v.add(new Student("����",20,"ȭõ"));
		v.add(new Student("����",18,"��ô"));
		try {
			osw.write("kisul\\stu.obj",v);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

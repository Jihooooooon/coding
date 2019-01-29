package com.ssafy.s158;
import java.io.*;
import java.util.Vector;
public class ObjectStudentRWG<T> {
 public int write(String fname, Vector<T> v) throws IOException{
	int objectNumber=0;
	try {
		FileOutputStream fos=new FileOutputStream(fname);
		ObjectOutputStream oos=new ObjectOutputStream(fos);//throws
		objectNumber=v.size();
		oos.writeInt(objectNumber);
		System.out.println(objectNumber+"���� Data�� �Էµ�");
		for(int i=0;i<objectNumber;i++){
			oos.writeInt(i);
			oos.writeObject(v.get(i));
			oos.flush();
			System.out.println(i+"��°��  Data�� �Էµ�");
		}
		oos.close();   fos.close();
	} catch (FileNotFoundException e) {
		System.out.println("�߸��� �����̸��� �Է��߽��ϴ�.");
	} catch(Exception ee){
		throw new IOException("Ÿ���� �̻��մϴ�."+ee);
	}
	return objectNumber;
 }
 public void read(String fname) throws IOException{
	try {
		FileInputStream fis = new FileInputStream(fname);
		ObjectInputStream ois=new ObjectInputStream(fis);//throws
		int objectNumber=ois.readInt();
		System.out.println(objectNumber+"���� Data�� ����");
		for(int i=0;i<objectNumber;i++){
			try {
				System.out.print(ois.readInt()+"��° :");
				System.out.println(ois.readObject());
			} catch (ClassNotFoundException e1) {
				System.out.println("�߸��� Ÿ���Դϴ�..");
			}
		}
		ois.close();  fis.close();
	} catch (FileNotFoundException e) {
		System.out.println("�߸��� �����̸��� �Է��߽��ϴ�.");
	}
 }
}
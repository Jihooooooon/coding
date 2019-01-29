package com.ssafy.edu.w23g;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StudentSchool {
	
	public static final String sp="|";
	public ArrayList<Student> readObj(String fname){
		ArrayList<Student> sts = new ArrayList<>();
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fname);
			ois = new ObjectInputStream(fis);
			int count=ois.readInt();
			for (int i = 0; i < count; i++) {
				int k=ois.readInt();
				Student ss;
				try {
					ss = (Student)ois.readObject();
					sts.add(ss);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		
		
		return sts;
	}
	public ArrayList<Student> read(String fname){
		ArrayList<Student> sts = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fname));
			String msg="";
			while((msg=br.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(msg, "|");
				sts.add(new Student(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken().trim())));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		
		
		return sts;
	}
	public void save(String fname, ArrayList<Student> sts) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(fname,false),true);
			for(int i=0; i< sts.size(); i++) {
				Student s = sts.get(i);
				String msg =String.format("%s%s%s%s", s.getId(),sp,s.getName(),sp, s.getBan());
				pw.println(msg);
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(pw!=null)pw.close();
		}
	}
	
 
	public void saveObj(String fname, ArrayList<Student> sts) {
		FileOutputStream fos=null;
		ObjectOutputStream oos = null;
		int count=sts.size();
		
		try {
			fos= new FileOutputStream(fname, false);
			oos = new ObjectOutputStream(fos);
			oos.writeInt(count);
			int k=0;
			for(Student s:sts) {
	
				oos.writeInt(k++);
				oos.writeObject(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

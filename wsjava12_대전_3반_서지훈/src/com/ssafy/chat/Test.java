package com.ssafy.chat;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		JButton button = new JButton("버튼입니다.");
		button.addActionListener(new MyListener());
		f.setLayout(new FlowLayout());//레이어 배치
		f.add(button);
		f.setSize(400, 300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	static class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//버튼이 클릭됐을 때 실행시키고 싶은 문장
			System.out.println("test");
		}
		
	}

}

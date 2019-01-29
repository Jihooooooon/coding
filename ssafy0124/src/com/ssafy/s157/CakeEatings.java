package com.ssafy.s157;
public class CakeEatings {
	public static void main(String[] args) {
		CakePlate cake=new CakePlate();//Cake ���� �غ�
		CakeEater eater=new CakeEater(cake);//cake ���� ����
		CakeMaker baker=new CakeMaker(cake);//cake ���� ����
		// �켱������ ������ �� ���� ȣ�Ⱑ�ɼ�-> �� ���� ���� ���ɼ��� ����.
		//baker.setPriority(6); 
		baker.start(); //���� ���� ����� �����Ѵ�.
		eater.start();
	}
}

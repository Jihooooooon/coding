package com.ssafy;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class ReservMgr {
	private static ReservMgr reservMgr;
	public MemMgr memMgr;
	public MovieMgr movieMgr;
	private ArrayList<Data> reservList;
	private Iterator<Data> iterator;
	private ReservMgr() {
		this.memMgr = MemMgr.getInstance();
		this.movieMgr = MovieMgr.getInstance();
		reservList = new ArrayList<>();
		
	}
	
	public ArrayList<Data> getReserveList(){
		return this.reservList;
	}
	
	public static synchronized ReservMgr getInstance() {
		if(reservMgr==null) {
			return reservMgr = new ReservMgr(); 
		}
		else {
			return reservMgr;
		}
	}
	public boolean reserve(Movie movie, Member member) {
		reservList.add(new Data(movie,member));
		return true;
	}
	
	public void print() {
		iterator = reservList.iterator();
		while(iterator.hasNext()) {
			Data temp = iterator.next();
			System.out.println("영화 예매자 :"+temp.getMember().getId()+" 이름 :"+temp.getMember().getName()+" 영화 정보 :"+temp.getMovie().getTitle());
		}
	}
	public boolean cancel(int id) {
		iterator = reservList.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getMember().getId()==id) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}
	


	private class Data{
		private Movie movie;
		private Member member;
		public Movie getMovie() {
			return movie;
		}
		public void setMovie(Movie movie) {
			this.movie = movie;
		}
		public Member getMember() {
			return member;
		}
		public void setMember(Member member) {
			this.member = member;
		}
		public Data(Movie movie, Member member) {
			
			this.movie = movie;
			this.member = member;
		}
		
		
	}
	
}

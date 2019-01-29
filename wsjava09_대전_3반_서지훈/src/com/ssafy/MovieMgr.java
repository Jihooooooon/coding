package com.ssafy;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class MovieMgr {
	private static MovieMgr movieMgr;
	private ArrayList<Movie> movies;
	private int index;
	private SortByName sortN;
	private SortByTime sortT;
	private Iterator<Movie> iterator;
	private MovieMgr() {
		this.movies = new ArrayList<>();
		sortN = new SortByName();
		sortT = new SortByTime();
	}
	
	public static synchronized MovieMgr getInstance() {
		if(movieMgr==null) {
			return movieMgr = new MovieMgr();
		}
		else return movieMgr;
	}

	public void add(Movie m) {

		if (this.isExist(m.getTitle(), m.getDirector(), m.getTime(),m.getNo())) {
			System.out.println("동일한 영화정보가 존재합니다.");
			return;
		}
		this.movies.add(m);
	}

	private boolean isExist(String title, String director, int time,int no) {
		boolean isE = false;
		for (int i = 0; i < this.getSize(); i++) {
			if (movies.get(i).getNo()==no) {
				isE = true;
				break;
			}
		}
		return isE;
	}

	public ArrayList<Movie> search() {
		ArrayList<Movie> temp = new ArrayList<>();
		for (int i = 0; i < this.movies.size(); i++) {
			temp.add(this.movies.get(i)) ;
		}
		return temp;
	}

	public Movie[] search(String title) {
		ArrayList<Movie> temp = new ArrayList<>();
		for (int i = 0; i < this.getSize(); i++) {
			if (this.movies.get(i).getTitle().contains(title)) {
				temp.add(this.movies.get(i));
			}
		}
		return temp.toArray(new Movie[temp.size()]);

	}

	public Movie[] searchDirector(String name) {
		ArrayList<Movie> temp = new ArrayList<>();
		for (int i = 0; i < this.getSize(); i++) {
			if (this.movies.get(i).getDirector().equals(name)) {
				temp.add(this.movies.get(i));
			}
		}
		return temp.toArray(new Movie[temp.size()]);
	}
	
	public ArrayList<Movie> searchTime(int time){
		ArrayList<Movie> temp = new ArrayList<>();
		iterator = movies.iterator();
		while(iterator.hasNext()) {
			Movie temp2=iterator.next();
			if(temp2.getTime()==time) {
				temp.add(temp2);
			}
		}
		return temp;
	} 
	
	public Movie searchNo(int no){
		
		iterator = movies.iterator();
		while(iterator.hasNext()) {
			Movie temp2=iterator.next();
			if(temp2.getNo()==no) {
				return temp2;
			}
		}
		return null;
	} 

	public Movie[] searchGenre(String genre) {
		ArrayList<Movie> temp = new ArrayList<>();
		for (int i = 0; i < this.getSize(); i++) {
			if (this.movies.get(i).getGenre().equals(genre)) {
				temp.add(this.movies.get(i));
			}
		}
		return temp.toArray(new Movie[temp.size()]);
	}

	public void delete(String title) {
		for (int i = 0; i < this.getSize(); i++) {
			if (movies.get(i).getTitle().equals(title)) {
				movies.remove(i);
			}
		}
	}
	
	public ArrayList<Movie> sortName(){
		Collections.sort(movies, sortN);
		return this.movies;
	}
	
	public ArrayList<Movie> sortTime(){
		Collections.sort(movies, sortT);
		return this.movies;
	}

	public int getSize() {
		return this.movies.size();
	}
	private class SortByName implements Comparator<Movie>{

		@Override
		public int compare(Movie o1, Movie o2) {
			// TODO Auto-generated method stub
			return o1.getTitle().compareTo(o2.getTitle());
		}}
	private class SortByTime implements Comparator<Movie>{

		@Override
		public int compare(Movie o1, Movie o2) {
			// TODO Auto-generated method stub
			Integer temp1 = new Integer(o1.getTime());
			Integer temp2 = new Integer(o2.getTime());
			return temp1.compareTo(temp2);
		}}
}

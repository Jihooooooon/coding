package com.ssafy;

import java.util.ArrayList;

public class MovieMgr {
	private Movie[] movies = new Movie[100];
	private int index;
	
	public void add(Movie m) {
		if(this.getSize()>=100) {
			System.out.println("배열이 꽉차서 더이상 넣을 수 없습니다!!!");
			return;
		}
		
		if(this.isExist(m.getTitle(), m.getDirector())) {
			System.out.println("동일한 영화정보가 존재합니다.");
			return;
		}
		this.movies[index++]=m;
	}
	
	private boolean isExist(String title, String director) {
		boolean isE=false;
		for(int i=0; i< this.getSize(); i++) {
			if(movies[i].getTitle().equals(title)&& movies[i].getDirector().equals(director)) {
				isE=true;
				break;
			}
		}
		return isE;
	}
	
	public Movie[] search() {
		Movie[] temp = new Movie[this.getSize()];
		for(int i=0; i<this.getSize(); i++) {
			temp[i]=this.movies[i];
		}
		return temp;
	}
	
	public Movie[] search(String title) {
		ArrayList<Movie> temp = new ArrayList<>();
		for(int i=0; i<this.getSize(); i++) {
			if(this.movies[i].getTitle().contains(title)) {
				temp.add(this.movies[i]);
			}
		}
		return temp.toArray(new Movie[temp.size()]);
		
	}
	public Movie[] searchDirector(String name) {
		ArrayList<Movie> temp = new ArrayList<>();
		for(int i=0; i<this.getSize(); i++) {
			if(this.movies[i].getDirector().equals(name)) {
				temp.add(this.movies[i]);
			}
		}
		return temp.toArray(new Movie[temp.size()]);
	}
	public Movie[] searchGenre(String genre) {
		ArrayList<Movie> temp = new ArrayList<>();
		for(int i=0; i<this.getSize(); i++) {
			if(this.movies[i].getGenre().equals(genre)) {
				temp.add(this.movies[i]);
			}
		}
		return temp.toArray(new Movie[temp.size()]);
	}
	
	public void delete(String title) {
		for(int i=0; i<this.getSize(); i++) {
			if(movies[i].getTitle().equals(title)) {
				movies[i]=null;
				for(int j=i+1; j<this.getSize(); j++) {
					movies[j-1]=movies[j];
				}
				this.index--;
			}
		}
	}
	public int getSize() {
		return this.index;
	}

}

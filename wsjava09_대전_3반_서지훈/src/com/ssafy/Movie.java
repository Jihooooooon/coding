package com.ssafy;

public class Movie {

	private int no;
	private int time;
	private String title;
	private String director;
	private int grade;
	private String genre;
	private String summary;

	
	public Movie() {
	}

	public Movie(int no,String title, String director, int grade, String genre) {
		this.no = no;
		this.title = title;
		this.director = director;
		this.grade = grade;
		this.genre = genre;
	}

	public Movie(int no,String title, String director, int grade, String genre, String summary) {
		this.no = no;
		this.title = title;
		this.director = director;
		this.grade = grade;
		this.genre = genre;
		this.summary = summary;
	}
	
	

	public Movie(int no,int time, String title, String director, int grade, String genre, String summary) {
	
		this(no,title,director,grade,genre,summary);

		this.time = time;

	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int no) {
		this.time = no;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String toString() {
		if (this.summary.equals(null)) {
			return String.format("타이틀 : %s 감독 : %s 등급 : %d 장르 : %s", this.getTitle(), this.getDirector(),
					this.getGrade(), this.getGenre());
		} else {
			return String.format("넘버 : %d 타이틀 : %s 시간 : %d 감독 : %s 등급 : %d 장르 : %s 요약 : %s", this.getNo(),this.getTitle(), this.getTime(),this.getDirector(),
					this.getGrade(), this.getGenre(),this.getSummary());
		}
	}

}

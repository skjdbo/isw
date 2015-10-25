package com.schuetz_tuschen.aufgabe2_1;

/***
 * Class to realize movie management.
 * @author manuel
 *
 */
public class MyFirstMovieManager {

	/***
	 * The main method.
	 * @param args The command line arguments
	 */
	public static void main(String[] args) {
		
		
		// add some movies to my library
		Movie m1 = new Movie("Movie1", 100);
		Movie m2 = new Movie("Movie2", 120);
		Movie m3 = new Movie("Movie3", 130);
		Movie m4 = new Movie("Movie4", 140);
		Movie m5 = new Movie("Movie5", 110);
		Movie m6 = new Movie("Movie6", 200);
		
		//create some customer		
		Customer c1 = new Customer("Peter");
		Customer c2 = new Customer("Petra");
		
		c1.loanMovie(m1);
		c1.loanMovie(m2);
		c1.loanMovie(m3);
		c1.loanMovie(m4);
		c1.loanMovie(m5);
		c1.loanMovie(m6);
		
		c2.loanMovie(m4);
	}

}

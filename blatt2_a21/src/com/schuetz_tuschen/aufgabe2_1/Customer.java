package com.schuetz_tuschen.aufgabe2_1;

import java.util.HashSet;

/***
 * Class to manage a movie customer.
 * 
 * @author chisitan schütz
 * @author manuel tuschen
 *
 */
public class Customer {
	
	/***
	 * The customer's name.
	 */
	private String name;
	/***
	 * A collection to store all movies loaned by this customer.
	 */
	private HashSet<Movie> loanedMovies = new HashSet<Movie>();
	
	
	
	/**
	 * Constructor creating a new customer by its name.
	 * @param name String last name of Customer
	 */
	public Customer(String name){
		this.name = name;
	}
	
	
	/**
	 * Getter for field name.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter for field name.
	 * @param name String name of customer
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter for loanedMovies.
	 * @return HashSet loanedMovies
	 */
	public HashSet<Movie> getLoanedMovies() {
		return loanedMovies;
	}
	/**
	 * Setter for loanedMovies.
	 * @param loanedMovies HashMap<String>
	 */
	public void setLoanedMovies(HashSet<Movie> loanedMovies) {
		this.loanedMovies = loanedMovies;
	}
	
	
	/**
	 * Allows the customer to loan a movie if it hasn't been loaned yet.
	 * @param movie Movie to be loaned
	 */
	public void loanMovie(Movie movie){
		if(loanedMovies.size() < 5) {
			if (movie.getCustomer() == null ) {
				loanedMovies.add(movie);
				movie.setCustomer(this);
			} else {
				System.out.println("Film ist schon an " + 
				movie.getCustomer().getName() + " verliehen!" );
			}
		} else {
			System.out.println("Kunde " + getName() + " hat schon 5 Filme " +
					"ausgeliehen.");
		}
	}

}

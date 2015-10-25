package de.unihd.isw.tuschen_schuetz_a22;

import java.util.HashSet;
import java.util.Set;

/**
 * This class models a Customer according to the specifications
 * on Blatt 2, Aufgabe 2.1.
 *
 * @version 20151022
 * @authors Manuel Tuschen, Christian Schütz
 * @project ISW Blatt 02
 * @email christian.schuetz@stud.uni-heidelberg.de
 *
 */
public class Customer {
	/**
	 * Name of customer.
	 */
	private String name;
	/**
	 * List of movies the customer has loaned.
	 */
	private Set<Movie> loanedMovies;

	/**
	 * Constructor for this class.
	 * @param name last name of Customer
	 */
	public Customer(final String name) {
		this.name = name;
		loanedMovies = new HashSet<Movie>();
	}
	/**
	 * Getter for field name.
	 * @return name
	 */
	public final String getName() {
		return name;
	}
	/**
	 * Setter for field name.
	 * @param name name of customer
	 */
	public final void setName(final String name) {
		this.name = name;
	}
	/**
	 * Getter for loanedMovies.
	 * @return Set<Movie> loanedMovies
	 */
	public final Set<Movie> getLoanedMovies() {
		return loanedMovies;
	}
	/**
	 * Setter for loanedMovies.
	 * @param loanedMovies HashSet<Movie>
	 */
	public final void setLoanedMovies(final Set<Movie> loanedMovies) {
		this.loanedMovies = loanedMovies;
	}
	/**
	 * Allows the customer to loan a movie if it hasn't been loaned yet.
	 * @param movie movie to be loaned
	 */
	public final void loanMovie(final Movie movie) {
		// customer is only allowed to loan 5 movies at once
		if (loanedMovies.size() < 5) {
			if (movie.getCustomer() == null) {
				// add movie to list of loaned movies
				loanedMovies.add(movie);
				// add this customer to the movie
				movie.setCustomer(this);
			} else {
				System.out.println("Film \""+movie.getTitle()+"\" ist schon an "
				+ movie.getCustomer().getName() + " verliehen!");
			}
		} else {
			System.out.println("Kunde " + getName() + " hat schon 5 Filme "
					+ "ausgeliehen.");
		}
	}

}

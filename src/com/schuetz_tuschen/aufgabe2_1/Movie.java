package com.schuetz_tuschen.aufgabe2_1;

import java.util.HashSet;

/***
 * A new class to store movies in a library.
 * @author manuel tuschen
 *
 */
public class Movie {

	/***
	 * A class variable with the number for the next entry.
	 */
	private static int nextNumber = 1;
	/***
	 * The number of the movie in the collection.
	 */
	private int number;
	/***
	 * The movies title.
	 */
	private String title;
	/***
	 * The duration of the movie in minutes.
	 */
	private int time;
	/***
	 * A collection of all the actors in the movie.
	 */
	private HashSet<Performer> performerList = new HashSet<Performer>();
	 /***
	 * The customer who has loaned the movie currently. If nobody has the movie 
	 * loaned the value is none.
	 */
	private Customer customer;


	
	/***
	 * A constructor for a new movie adding one performer.
	 * @param title The movies title
	 * @param time The movies duration
	 */
	public Movie(String title, int time) {
		this.title = title;
		this.time = time;
		this.number = Movie.nextNumber;
		Movie.nextNumber++;
	}
	
	
	/***
	 * Set a new title for the movie.
	 * @param title The new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/***
	 * Get the movies title.
	 * @return The movie title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/***
	 * Set a new duration time in minutes.
	 * @param time The new duration
	 */
	public void setTime(int time) {
		this.time = time; // this is required to make clear that time belongs to
						  // the instance object
	}
	/***
	 * Get the movies duration time in minutes.
	 * @return The duration time
	 */
	public int getTime() {
		return this.time;
	}
	
	
	/***
	 * Add a performer to the movie.
	 * @param performer The additional performer
	 */
	public void addPerformer(Performer performer) {
		this.performerList.add(performer);
	}
	/***
	 * Test if a specific performer is part of the this movie.
	 * @param performer the performer to check for
	 * @return true if the performer is part of the movie
	 */
	public boolean doesPerformerPlayInMovie(Performer performer) {
		return this.performerList.contains(performer);
	}
	/***
	 * Get all the movie's performer.
	 * @return HashSet with all the performer
	 */
	public HashSet<Performer> getAllPerformer() {
		return this.performerList;
	}
	/***
	 * Get all the outstanding performer.
	 * @return HashSet with all the outstanding performer
	 */
	public HashSet<Performer> getAllOutstandingPerformer() {
		HashSet<Performer> tmp = new HashSet<Performer>();
		for (Performer p : this.performerList) {
			if (p.getOutstanding()) {
				tmp.add(p);
			}
		}
		return tmp;
	}
	/***
	 * Delete one performer from a movie; Deleting the last one fails.
	 * @param performer The performer to delete
	 */
	public void deletePerformerFromMovie(Performer performer) {
		if (this.performerList.size() > 1) {
			this.performerList.remove(performer);
		} else {
			System.out.println("Last performer can not be deleted");
		}
	}
	
	
	/***
	 * Setter for customer.  
	 * @param customer The new customer who loaned the movie
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/***
	 * Getter for customer. 
	 * @return The customer who loaned the movie
	 */
	public Customer getCustomer() {
		return customer;
	}
	

	/***
	 * Print out movie information.
	 */
	public void showInformation() {
		System.out.println("Titel: " + this.title);
		System.out.println("Time: " + this.time);
		System.out.println("Number: " + this.number);
	}
}

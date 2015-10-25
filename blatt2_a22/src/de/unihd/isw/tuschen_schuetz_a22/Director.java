package de.unihd.isw.tuschen_schuetz_a22;

import java.util.Map;

/**
 * This class models a Director as subclass of Performer according to the 
 * specifications on Blatt 2.
 *
 * @version 20151024
 * @authors Manuel Tuschen, Christian Schütz
 * @project ISW Blatt 02
 * @email christian.schuetz@stud.uni-heidelberg.de
 *
 */
public class Director extends Performer 
{
	
	private Integer counterDirectedMovies;
	
	/**
	 * Standard constructor.
	 */
	public Director() {}
	/**
	 * Constructor without given movies.
	 * @param firstName Director's firstName
	 * @param lastName Director's lastName
	 * @param gender Director's gender
	 * @param outstanding Director's outstanding characteristic
	 */
	public Director(String firstName, String lastName, Gender gender,
			boolean outstanding) 
	{
		super(firstName, lastName, gender, outstanding);
		counterDirectedMovies = 0;
	}
	/**
	 * Constructor with all parameters.
	 * @param firstName Director's firstName
	 * @param lastName Director's lastName
	 * @param gender Director's gender
	 * @param movies All movies the director has made
	 * @param outstanding Director's outstanding characteristic
	 */
	public Director(String firstName, String lastName, Gender gender,
			Map<String, Movie> movies, boolean outstanding) 
	{
		super(firstName, lastName, gender, movies, outstanding);
		counterDirectedMovies = movies.size();
	}
	/**
	 * Getter for counterDirectedMovies.
	 * @return the counterDirectedMovies
	 */
	public Integer getCounterDirectedMovies() {
		return counterDirectedMovies;
	}
	/**
	 * Setter for counterDirectedMovies.
	 * @param counterDirectedMovies the counterDirectedMovies to set
	 */
	public void setCounterDirectedMovies(Integer counterDirectedMovies) {
		this.counterDirectedMovies = counterDirectedMovies;
	}
	/**
	 * Adds movie to director's list of directed movies and increases the number
	 * of directed movies by 1.
	 * @param newMovie new movie to be added.
	 */
	public void addMovie(Movie newMovie)
	{
		super.addMovie(newMovie);
		counterDirectedMovies += 1;
	}

	
}

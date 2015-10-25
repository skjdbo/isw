package com.schuetz_tuschen.aufgabe2_1;

/***
 * This class contains all the important attributes of an film actor.
 * @author manuel tuschen
 *
 */
public class Performer {
	
	/***
	 * His/Her firstname.
	 */
	private String firstname;
	/***
	 * His/Her lastname.
	 */
	private String lastname;
	/***
	 * His/Her sex.
	 */
	private Gender gender;
	/***
	 * Note if the performer is extra-ordinary good.
	 */
	private boolean outstanding;
	/***
	 * The movie he/she is actually plying for.
	 */
	private Movie movie;
	
	
	
	/***
	 * 
	 * Constructor which directly initializes all attributes.
	 * @param firstname His/Her firstname
	 * @param lastname His/Her lastname
	 * @param gender His/Her sex
	 * @param outstanding Note if the performer is extra-ordinary good
	 */
	public Performer(String firstname, String lastname, Gender gender, boolean outstanding) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.outstanding = outstanding;
	}



	/***
	 * Set a new value to firstname.
	 * @param firstname His/Her new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/***
	 * Get the performers firstname.
	 * @return His/Her firstname
	 */
	public String getFirstname() {
		return this.firstname;
	}
	
	/***
	 * Set a new value for lastname. 
	 * @param lastname His/Her new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/***
	 * Get the performers lastname.
	 * @return His/Her new lastname
	 */
	public String getLastname() {
		return this.lastname;
	}
	
	/***
	 * Set the performers new gender to either MALE or FEMALE.
	 * @param gender His/Her new gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	/***
	 * Get the performers gender.
	 * @return His/Her gender
	 */
	public Gender getGender() {
		return this.gender;
	}
	
	/***
	 * Set a new current movie.
	 * @param movie Reference to a movie
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	/***
	 * Get the performers current movie.
	 * @return Reference to the current movie object
	 */
	public Movie getMovie() {
		return movie;
	}
	/***
	 * Declare a performer as outstanding or not.
	 * @param isOutstanding true if performer is outstanding
	 */
	public void setOutstanding(boolean isOutstanding) {
		this.outstanding = isOutstanding;
	}
	/***
	 * See if the performer is outstanding.
	 * @return true if the performer is outstanding
	 */
	public boolean getOutstanding() {
		return this.outstanding;
	}
}

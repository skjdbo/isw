package de.unihd.isw.tuschen_schuetz_a22;

import java.util.HashMap;
import java.util.Map;

/**
 * This class models a Performer according to the specifications
 * on Blatt 1 and 2.
 *
 * @version 20151022
 * @authors Manuel Tuschen, Christian Schütz
 * @project ISW Blatt 02
 * @email christian.schuetz@stud.uni-heidelberg.de
 *
 */
public class Performer
{
	private String firstName;
	private String lastName;
	private Gender gender;
	protected Map<String, Movie> movies;
	private boolean outstanding;

	/**
	 * Standard constructor.
	 */
	public Performer(){};
	/**
	 * Constructor with all parameters except for HashMap movies.
	 * @param firstName Performer's first name
	 * @param lastName Performer's last name
	 * @param gender Performer's gender
	 * @param outstanding Indicated whether this performer is outstanding
	 */
	public Performer(String firstName, String lastName, Gender gender,
					boolean outstanding)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.outstanding = outstanding;
		movies = new HashMap<String, Movie>();
	}
	/**
	 * Constructor with all parameters given.
	 * @param firstName Performer's first name
	 * @param lastName Performer's last name
	 * @param gender Performer's gender
	 * @param movies List of movies this performer plays in
	 * @param outstanding Indicated whether this performer is outstanding
	 */
	public Performer(String firstName, String lastName, Gender gender,
					Map<String, Movie> movies, boolean outstanding)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.movies = movies;
		this.outstanding = outstanding;
	}
	/**
	 * Getter for performer's first name.
	 * @return firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}
	/**
	 * Setter for performer's first name.
	 * @param firstName Name to be set
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	/**
	 * Getter for performer's lastName.
	 * @return performer's lastName
	 */
	public String getLastName()
	{
		return lastName;
	}
	/**
	 * Setter for performer's lastName.
	 * @param lastName name to set as lastName
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	/**
	 * Getter for performer's gender.
	 * @return performer's gender
	 */
	public Gender getGender()
	{
		return gender;
	}
	/**
	 * Setter for performer's gender.
	 * @param gender Gender to set
	 */
	public void setGender(Gender gender)
	{
		this.gender = gender;
	}
	/**
	 * Setter for performer's movies.
	 * @param movies Movies to set
	 */
	public void setMovies(Map<String, Movie> movies)
	{
		this.movies = movies;
	}
	/**
	 * Getter for movies.
	 * @return performer's movies
	 */
	public Map<String, Movie> getMovies()
	{
		return movies;
	}
	/**
	 * Setter for field isOutstanding.
	 * @param isOutstanding Boolean to be set to
	 */
	public void setOutstanding(Boolean isOutstanding)
	{
		outstanding = isOutstanding;
	}
	/**
	 * Getter for field isOutstanding.
	 * @return isOutstanding
	 */
	public boolean getOutstanding()
	{
		return outstanding;
	}
	/**
	 * Adds a new movie to performer's list of movies, and also adds
	 * this performer to the list of performers that play in this movie.
	 * @param newMovie new movie to be added
	 */
	public void addMovie(Movie newMovie)
	{
		if(! movies.containsKey(newMovie.getTitle()))
		{
			System.out.println("The movie \""+newMovie.getTitle()+"\""
				+ " was added to performer \""+lastName+"\"'s play list.");
			movies.put(newMovie.getTitle(), newMovie);
			newMovie.addPerformer(this);
		}
		else
		{
			System.out.println("The performer does not need to be listed " +
					"twice in the same movie! Nothing was changed.");
		}
	}
	/**
	 * Removes a movie from performer's list of movies and also removes the
	 * performer from the movie's list of performers.
	 * @param title Title of movie to be removed
	 */
	public void removeMovie(String title)
	{
		if(movies.containsKey(title))
		{
			System.out.println("The movie \"" +title +"\" was removed"
					+ "from performer "+lastName+"'s play list.");
			movies.get(title).removePerformer(lastName);
			movies.remove(title);
		}
		else
		{
			System.out.println("This actor did not play in " +
						title + ". Nothing was changed.");
		}

	}
}

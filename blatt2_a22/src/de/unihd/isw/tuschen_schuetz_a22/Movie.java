package de.unihd.isw.tuschen_schuetz_a22;
import java.util.HashMap;
import java.util.Map;

/**
 * This class models a Movie according to the specifications
 * on Blatt 1 and 2.
 *
 * @version 20151022
 * @authors Manuel Tuschen, Christian Schütz
 * @project ISW Blatt 02
 * @email christian.schuetz@stud.uni-heidelberg.de
 *
 */
public class Movie {
	/**
	 * Movie title.
	 */
	private	String title;
	/**
	 * Movie duration.
	 */
	private int time;
	/**
	 * Object counter.
	 */
	private static int number = 1;
	/**
	 * Movie id.
	 */
	private final int nextNumber;
	/**
	 * List of Performers playing in this movie.
	 */
	private Map<String,Performer> performers;
	/**
	 * Customer who currently loans this movie.
	 */
	private Customer customer;
	
	private Director director;
	
	/**
	 * Constructor without parameters.
	 */
	public Movie() {
		nextNumber = number++;
	};
	/**
	 * Constructor with parameters, no director given.
	 * @param title Title of movie
	 * @param time Duration of movie
	 */
	public Movie(String title, int time)
	{
		this.title = title;
		this.time = time;
		performers = new HashMap<String, Performer>();
		nextNumber = number++;
	};
	/**
	 * Constructor with parameters.
	 * @param title Title of movie
	 * @param time Duration of movie
	 * @param director Movie's director
	 */
	public Movie(String title, int time, Director director)
	{
		this.title = title;
		this.time = time;
		this.director = director;
		nextNumber = number++;
	}
	
	/**
	 * Getter for number.
	 * @return Movie`s number
	 */
	public int getNumber()
	{
		return nextNumber;
	}
	/**
	 * Getter for title.
	 * @return Movie`s title
	 */
	public String getTitle()
	{
		return title;
	}
	/**
	 * Getter for time.
	 * @return Movie`s time
	 */
	public int getTime()
	{
		return time;
	}
	/**
	 * Getter for performers.
	 * @return Movie`s performers
	 */
	public Map<String,Performer> getPerformers()
	{
		return performers;
	}
	
	/**.
	 * Get performer specified by the lastName.
	 * @param lastName lastNime of performer to get
	 * @return Performer with the specified lastName or NULL if not present
	 */
	public Performer getSinglePerformer(String lastName)
	{
		return performers.get(lastName);
	}
	/**
	 * Setter for title.
	 * @param title New title of movie
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	/**
	 * Setter for time.
	 * @param time New time of movie
	 */
	public void setTime(int time)
	{
		this.time = time;
	}
	/**
	 * Setter for performers.
	 * @param performers New performer hashmap
	 */
	public void setPerformers(Map<String,Performer> performers)
	{
		this.performers = performers;
	}
	/**
	 * Getter for customer.
	 * @return The customer who loaned the movie
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * Setter for customer. 
	 * @param customer Customer who loans this movie
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * @return the director
	 */
	public Director getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(Director director) {
		this.director = director;
	}
	/**
	 * Add new performer to list.
	 * @param newPerformer New performer to be added
	 */
	public void addPerformer(Performer newPerformer)
	{
		if(!performers.containsKey(newPerformer.getLastName()))
		{
			System.out.println("Performer \""+ newPerformer.getLastName()
				+"\" was added to movie \""+title +"\"'s performer list.");
			performers.put(newPerformer.getLastName(), newPerformer);
			newPerformer.addMovie(this);
		}
		else
		{
			System.out.println("This movie already lists this performer. "
					+ "Nothing was changed.");
		}
	}
	/**
	 * Remove performer from list.
	 * @param lastName Last name of performer to be removed
	 */
	public void removePerformer(String lastName)
	{
		if(performers.containsKey(lastName))
		{
			System.out.println("Performer \"" + lastName +"\" was deleted "
					+ " from the movie \""+title+"\"'s performer list.");
			performers.get(lastName).removeMovie(title);
			performers.remove(lastName);
		}
		else
		{
			System.out.println("This performer did not play in this movie. "
					+ "Nothing was changed.");
		}
	}

	/**
	 * Print title, length and id (number) of current object.
	 */
	public void showInformation()
	{
		System.out.println("The movie you selected is called \"" +
				getTitle() + "\" and has a duration of " +
				getTime() + " minutes. It is the "+
				getNumber() + ". movie in the collection.");
	}

}

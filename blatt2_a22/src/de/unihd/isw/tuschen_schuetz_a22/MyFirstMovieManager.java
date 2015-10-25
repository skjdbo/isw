package de.unihd.isw.tuschen_schuetz_a22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class models a MovieManager according to the specifications
 * on Blatt 1 and 2.
 *
 * @version 20151022
 * @authors Manuel Tuschen, Christian Schütz
 * @project ISW Blatt 02
 * @email christian.schuetz@stud.uni-heidelberg.de
 *
 */
public class MyFirstMovieManager {
	private Map<String, Movie> movieCollection;
	private Map<String, Performer> performerCollection;
	private Set<Customer> customerCollection;

	
	/**
	 * Standard constructor for this class without parameters.
	 */
	public MyFirstMovieManager(){
		movieCollection = new HashMap<String, Movie>();
		performerCollection = new HashMap<String,Performer>();
		customerCollection = new HashSet<Customer>();
	};
	/**
	 * Constructor with parameters.
	 * @param newMovieCollection new movieCollection to be set for this class
	 * @param newPerformerCollection new performerCollection to be set for this
	 * class
	 */
	public MyFirstMovieManager(Map<String, Movie> newMovieCollection,
							Map<String, Performer> newPerformerCollection)
	{
		movieCollection = newMovieCollection;
		performerCollection = newPerformerCollection;
	}

	/**
	 * Getter for movieCollection.
	 * @return MovieManager's movieCollection
	 */
	public Map<String,Movie> getMovieCollection()
	{
		return movieCollection;
	}
	/**
	 * Setter for movieCollection.
	 * @param newMovieCollection new movieCollection to be set
	 */
	public void setMovieCollection(Map<String,Movie> newMovieCollection)
	{
		this.movieCollection = newMovieCollection;
	}
	/**
	 * Setter for performerCollection.
	 * @param newPerformerCollection new performerCollection to be set
	 */
	public void setPerformerCollection(Map<String, Performer>
										newPerformerCollection)
	{
		performerCollection = newPerformerCollection;
	}
	/**
	 * Getter for performerCollection.
	 * @return MovieManager's performerCollection
	 */
	public Map<String,Performer> getPerformerCollection()
	{
		return performerCollection;
	}
	/**
	 * getter for customerCollection.
	 * @return HashSet<Customer> customerCollection
	 */
	public Set<Customer> getCustomerCollection() {
		return customerCollection;
	}
	/**
	 * setter for customerColelcion.
	 * @param customerCollection HashSet<Customer>
	 */
	public void setCustomerCollection(Set<Customer> customerCollection) {
		this.customerCollection = customerCollection;
	}
	/**
	 * Gets movie from collection as identified by its title.
	 * 
	 * @param title Title of movie to get
	 * @return returns either the already existing movie, or a new
	 *  movie is created, added to the collection and then returned
	 */
	public Movie getMovie(String title)
	{
		if(movieCollection.containsKey(title))
		{
			return movieCollection.get(title);
		}
		else
		{
			System.out.println("The movie "+title+" does not exist in "
					+ "this collection. A new entry was generated. Please do "
					+ "not forget to fill in its details.");
			final Movie newMovie = new Movie();
			newMovie.setTitle(title);
			addMovie(title, newMovie);
			return newMovie;
		}
	}
	/**
	 * Adds movie to movieCollection.
	 * @param title Title of movie; is the key under which the movie is filed
	 * @param newMovie new movie to be added to movie collection
	 */
	public void addMovie(String title, Movie newMovie)
	{
		if(!movieCollection.containsKey(title))
		{
			System.out.println("The movie \""+title+"\" was added to "
					+ "the movie collection.");
			movieCollection.put(title, newMovie);
		}
		else
		{
			System.out.println("The movie collection alreasy contains a movie"
					+ " with that name.");
		}
	}
	/**
	 * Removes a movie from movieCollection if it is contained there. Otherwise
	 * it prints an error message.
	 * @param title Title of movie to be removed
	 */
	public void removeMovie(String title)
	{
		if(movieCollection.containsKey(title))
		{
			movieCollection.remove(title);
			System.out.println("The movie \""+title+"\" was deleted from the "
					+ "movie collection.");
		}
		else
		{
			System.out.println("No movie called \""+title+"\" is in the "
					+ "movie collection.");
		}
	}
	/**
	 * Gets performer from collection as identified by his/her last name.
	 * 
	 * @param lastName last name of performer to get
	 * @return returns either the already existing performer, or a new
	 *  performer is created, added to the collection and then returned
	 */
	public Performer getPerformer(String lastName)
	{
		if(performerCollection.containsKey(lastName))
		{
			return performerCollection.get(lastName);
		}
		else
		{
			System.out.println("The performer "+lastName+" does not exist "
					+ "in this collection. A new entry was generated. Please "
					+ "do not forget to fill in the details.");
			final Performer newPerformer = new Performer();
			newPerformer.setLastName(lastName);
			addPerformer(lastName, newPerformer);
			return newPerformer;
		}
	}

	/**
	 * Adds performer to performerCollection.
	 * @param lastName last name of performer; is the key under which the
	 * 	performer is filed in performerCollection
	 * @param newPerformer new performer to be added to performer collection
	 */
	public void addPerformer(String lastName,Performer newPerformer)
	{
		if(!performerCollection.containsKey(lastName))
		{
			System.out.println("The performer \""+lastName+"\" was added to "
					+ "the performer collection.");
			performerCollection.put(lastName, newPerformer);
		}
		else
		{
			System.out.println("The performer collection already contains a "
					+ "performer with that name.");
		}
	}
	/**
	 * Removes performer from performerCollection if he/she is listed there.
	 * Otherwise prints error message.
	 * @param lastName Last name of performer to be removed
	 */
	public void removePerformer(String lastName)
	{
		if(performerCollection.containsKey(lastName))
		{
			performerCollection.remove(lastName);
			System.out.println("The performer \""+lastName+"\" was deleted "
					+ "from the performer collection.");
		}
		else
		{
			System.out.println("No performer with the name \""+lastName+"\" "
					+ "is in the performer collection.");
		}
	}
	/**
	 * Iterates through performerCollection and checks their outstanding field.
	 * 
	 * @return returns HashMap of outstanding performers
	 */
	public Map<String, Performer> getOutstandingPerformers()
	{
		final Map<String, Performer> outstandingPerformers =
			new HashMap<String, Performer>();
		for( Performer currPerf : performerCollection.values())
		{
			if(currPerf.getOutstanding())
			{
				System.out.println(currPerf.getLastName() + ", " +
							currPerf.getFirstName());
				outstandingPerformers.put(currPerf.getLastName(), currPerf);
			}
		}
		return outstandingPerformers;
	}

	/**
	 * Main function of this class, implements some movie managing.
	 * 
	 * @param args required for CLI input of arguments, not used here
	 */
	public static void main(String[] args)
	{

		final Movie m1 = new Movie("Movie1", 100);
		final Movie m2 = new Movie("Movie2", 120);
		final Movie m3 = new Movie("Movie3", 130);
		final Movie m4 = new Movie("Movie4", 140);
		final Movie m5 = new Movie("Movie5", 110);
		final Movie m6 = new Movie("Movie6", 200);
		final Performer p1 = new Performer("Peter", "Pan", Gender.MALE, true);
		final Performer p2 = new Performer("Petra", "Pans", Gender.FEMALE, true);
		final Performer p3 = new Performer("Hans", "Wurst", Gender.MALE, true);
		final Performer p4 = new Performer("Henriette", "Wursta",Gender.FEMALE,false);
		final Performer p5 = new Performer("Horsta", "Weils", Gender.FEMALE,false);


		final MyFirstMovieManager movieManager = new MyFirstMovieManager();
		System.out.println("-- First, we add five new movies to our movie "
				+ "collection.");
		movieManager.addMovie("Movie1", m1);
		movieManager.addMovie("Movie2", m2);
		movieManager.addMovie("Movie3", m3);
		movieManager.addMovie("Movie4", m4);
		movieManager.addMovie("Movie5", m5);
		System.out.println("-- We then add five performers to our list of "
				+ "performers.");
		movieManager.addPerformer("Pan", p1);
		movieManager.addPerformer("Pans", p2);
		movieManager.addPerformer("Wurst", p3);
		movieManager.addPerformer("Wursta", p4);
		movieManager.addPerformer("Weils", p5);

		System.out.println("-- Next, we register for two different movies"
				+ "which performers played in them.");
		movieManager.getMovie("Movie5").addPerformer(p5);
		movieManager.getMovie("Movie4").addPerformer(p4);
		System.out.println("-- Since these two performers play in these movies"
				+ ", we also register this information in each of their "
				+ "play lists (a list of the movies they play in).");
		movieManager.getPerformer("Wursta").addMovie(m4);
		movieManager.getPerformer("Weils").addMovie(m5);
		System.out.println("-- Next, we check in our list of performers who "
				+ "currently has the status of being outstanding:");
		movieManager.getOutstandingPerformers();
		System.out.println("-- After we have watched the actress Henrietta "
				+ "Wursta play, we are convinced that she is outstanding, "
				+ "as well, so we change her status and check our list of"
				+ "outstanding performers again.");
		movieManager.getPerformer("Wursta").setOutstanding(true);
		movieManager.getOutstandingPerformers();
		System.out.println("-- We lost one movie, so we delete it from our "
				+ "movie collection.");
		movieManager.removeMovie("Movie5");
		
		final Customer c1 = new Customer("Peter");
		final Customer c2 = new Customer("Petra");
		movieManager.customerCollection.add(c1);
		movieManager.customerCollection.add(c2);
		
		c1.loanMovie(m1);
		c1.loanMovie(m2);
		c1.loanMovie(m3);
		c1.loanMovie(m4);
		c1.loanMovie(m5);
		c1.loanMovie(m6);
		
		c2.loanMovie(m4);
	}

}

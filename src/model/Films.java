package model;
public class Films extends Product{
    //Attributes
	private String producer;
    private int minimumAge;
    
    //Relationships
    private MovieCategory categoryMovie;

    //Constructor method
    /**
      * Description: this is the constructor method to create a Serie.
      * @param productName String, it represents the name of the film.
      * @param movieDirector String, it represents the name of the movie director.
      * @param synopsis String, it represents an abstract of the film.
      * @param day int, it represents the opening day of the film.
      * @param month int, it represents the opening month of the film.
      * @param year int, it represents the opening yeat of the film.
      * @param producer String, it represent of the film producer.
      * @param minimumAge int, it represent the recommended age to watch the movie.
      * @param numCategory int, it represents a number that correspons to 
      one movie category      */
    public Films(String productName, String movieDirector, String synopsis, int day,
        int month, int year, String producer, int minimumAge, int numCategory){

    	super(productName,movieDirector,synopsis,day,month,year);

    	this.producer = producer;
    	this.minimumAge = minimumAge;

    	if(numCategory == 0){
    		categoryMovie = MovieCategory.ROMANTIC;
    	}
    	else if(numCategory == 1){
    		categoryMovie = MovieCategory.ACTION;
    	}
    	else if(numCategory == 2){
    		categoryMovie = MovieCategory.SUSPENSE;
    	}
    	else if(numCategory == 3){
    		categoryMovie = MovieCategory.HORROR;
    	}
    	else if(numCategory == 4){
    		categoryMovie = MovieCategory.COMEDY;
    	}
    }

    //GETTERS
    public String getProducer(){
        return producer;
    }
    public int minimumAge(){
        return minimumAge;
    }
    public MovieCategory getMovieCategory(){
        return categoryMovie;
    }
    //SETTERS
    public void setProducer(String producer){
        this.producer = producer;
    }
    public void setMinimunAge(int minimumAge){
        this.minimumAge = minimumAge;
    }


    //TO STRING
    @Override
    public String toString(){
    	String out = "";
		out += "Name: "+ productName+"\n";
		out += "Director: "+  movieDirector +"\n";
		out += "Sypnosis: "+ "\n";
		out += synopsis + "\n";
		out += "Fecha de estreno: "+releaseaDate.toString()+"\n";
		out += "Producer: "+ producer+"\n";
		out += "Minimum age: "+ minimumAge+"\n";
        out += "Category: "+ categoryMovie + "\n";
		out += "";
		return out;

    }
    @Override
    public String exampleClase(int par){
		String out = "";
		out = "This is a film "+ par;
		
		return out;
	}



}
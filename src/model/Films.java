package model;
public class Films extends Product{
    //Attributes
	private String producer;
    private int minimumAge;
    
    //Relationships
    private MovieCategory categoryMovie;

    //Constructor method
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
        out += "Category: "+ categoryMovie;
		return out;

    }



}
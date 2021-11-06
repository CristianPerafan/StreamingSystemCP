package model;

public  abstract class Product{
	
	//Attributes
	protected String productName;
	protected String movieDirector;
	protected String synopsis;

	//RelationShips
	protected Date releaseaDate;


	//Constructor method
    /**
      * Description: this is the constructor method to create a product.
      * @param productName String, it represents the name of the product.
      * @param movieDirector String, it represents the director of the product. 
      * @param  synopsis String, it represents an abstract of the product. 
      * @param day int, it represents the opening day of the product
      * @param month int, it represents the opening month of the product.
      * @param year int, it represents the opening year of the product.
      */

	public Product(String productName, String movieDirector, String synopsis, int day,
		int month, int year){

		this.productName = productName;
		this.movieDirector = movieDirector;
		this.synopsis = synopsis;

		releaseaDate = new Date(day,month,year);

	}

	//GETTER
	public String getProductName(){
		return productName;
	}
	public String getMovieDirector(){
		return movieDirector;
	}
	public String getSynopsis(){
		return synopsis;
	}

	//SETTER
	public void setProductName(String productName){
		this.productName = productName;
	}
	public void setMovieDirector(String movieDirector){
		this.movieDirector = movieDirector;
	}
	public void setSypnosis(String synopsis){
		this.synopsis = synopsis;
	}
	
	public abstract String exampleClase(int par);


    //TO STRING
	public String toString(){
		String out = "";
		out += "Name: "+ productName+"\n";
		out += "Director: "+  movieDirector +"\n";
		out += "Sypnosis: "+ "\n";
		out += synopsis + "\n";
		out += "Fecha de estreno: "+releaseaDate.toString()+"\n";
		return out;
	}

	





}
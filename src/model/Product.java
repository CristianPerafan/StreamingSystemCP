package model;

public class Product{
	//Attributes
	protected String productName;
	protected String movieDirector;
	protected String synopsis;

	//RelationShips
	protected Date releaseaDate;

	//Constructor Method
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
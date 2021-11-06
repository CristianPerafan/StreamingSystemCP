package model;

public class Series extends Product {
    //Attributes
    private boolean censoredSerie;
    private String razonCensored;
    private String [] actor;

    //RelationShip
    private Season [] seasons;

    //Constructor method
    /**
      * Description: this is the constructor method to create a Serie.
      * @param productName String, it represents the name of the serie.
      * @param movieDirector String, it represents the director of the serie. 
      * @param  synopsis String, it represents an abstract of the serie. 
      * @param day int, it represents the opening day of the serie.
      * @param month int, it represents the opening month of the serie.
      * @param year int, it represents the opening year of the serie.
      * @param censoredSerie boolean, if censoredSerie = true the serie has been censored
      else the series has not been censored.
      * @param razonCensored String, if censoredSerie = true, it represents the censored
      reason why the serie was censored.
      * @param numActors int, it represents the amount of actors of the serie
      * @param scheduledEpisodes int, it represents the amount of scheduled episodes
      of the serie.
      * @param publishedEpisodes int,it represents the amount of published episodes
      of the serie.
      * @param pathTrailer String, it represents the link of the thrailer of the serie.
      * @param auxActors String [], it represents an array that contains the name 
      of the main actors of the serie.
      */

    public Series(String productName, String movieDirector, String synopsis, int day,
      int month, int year, boolean censoredSerie, String razonCensored, int numActors, 
    	int scheduledEpisodes, int publishedEpisodes, 
      String pathTrailer, String [] auxActors){

    	super(productName,movieDirector,synopsis,day,month,year);

		  this.censoredSerie = censoredSerie;

		  this.razonCensored = razonCensored;

		  actor = new String [numActors];
		  seasons = new Season [20];

      for(int i = 0; i<actor.length;i++){
        actor[i] = auxActors[i];
      }
		

      seasons [0] = new Season(scheduledEpisodes,publishedEpisodes,pathTrailer);
    }





    public void addSeason(int scheduledEpisodes, int publishedEpisodes, String pathTrailer){
      int i = thereIsSpaceInSeason(); 
      seasons [i] = new Season(scheduledEpisodes,publishedEpisodes,pathTrailer);
    }

	
	
    //GETTERS
    public boolean getCensoredSerie(){
      return censoredSerie;
    }
    public String getRazonCensored(){
      return razonCensored;
    }
    //SETTERS
    public void setCensoredSerie(boolean censoredSerie){
      this.censoredSerie = censoredSerie;
    }
    public void setRazonCensored(String razonCensored){
      this.razonCensored = razonCensored;
    }

    //TO STRING

    @Override
    public String toString(){
    	String out = "";
      out += "Name: "+ productName+"\n";
      out += "Director: "+  movieDirector +"\n";
      out += "Sypnosis: "+ "\n";
      out += synopsis + "\n";
      out += "Censoring razon: \n";
      out += razonCensored + "\n";
      out += "Fecha de estreno: "+releaseaDate.toString()+"\n";
      out += "Actors: \n";

      for(int i = 0; i<actor.length;i++){
        if(actor[i] != null){      
          out += actor[i]+"\n";
        }    
      }

      out += "Seasons: \n";
      out += "\n";
      for(int i = 0; i<seasons.length;i++){
        if(seasons[i] != null){
          out += "SEASON "+(i+1)+"\n";
          out += seasons[i].toString()+"\n";
        }
      }
    	return out;
    }
	
	@Override
    public String exampleClase(int par){
		String out = "";
		out = "This is a serie "+ par;
		
		return out;
	}

  ///Method Series:  thereIsSpaceInSeason(int) //
  /**
      * Description: in this method we will look one space to create a new season
      int the array of seasons.
      * @return pos int, it contains the space where we can create a new season,
      if pos = -1 , there is not a free space to create a new season
      */
	
	public int thereIsSpaceInSeason(){
		int pos = -1;
		boolean flag = false;
		
		for(int i =0; i<seasons.length && !flag;i++){
			if(seasons[i] == null){
        pos = i;
				flag = true;
			}
		}
		return pos;
	}

   ///Method Series: obtainLastSeasonSerien(String) //
  /**
      * Description: in this method we will obtain the information of the last
      season of one serie.
      * @return out String, it contains the information of the last season
      of one serie. 
      */

  public String obtainLastSeasonSerie(){
    String out = "";
    boolean flag = false;
    for(int i = (seasons.length-1); i>=0 && !flag;i--){
      if(seasons[i] != null){
        out += seasons[i].toString();
        flag = true;
      }
    }

    return out;
  }
}
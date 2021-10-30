package model;

public class Series extends Product {
    //Attributes
    private boolean censoredSerie;
    private String razonCensored;
    private String [] actor;

    //RelationShip
    private Season [] seasons;

    //Constructor method
    public Series(String productName, String movieDirector, String synopsis, int day,
        int month, int year, boolean censoredSerie, String razonCensored, int numActors, 
    	int numSeason, int num, int scheduledEpisodes, int publishedEpisodes, 
        String pathTrailer, String [] auxActors){

    	super(productName,movieDirector,synopsis,day,month,year);

		this.censoredSerie = censoredSerie;

		this.razonCensored = razonCensored;

		actor = new String [numActors];
		seasons = new Season [numSeason];

        for(int i = 0; i<actor.length;i++){
            actor[i] = auxActors[i];
        }

        seasons [0] = new Season(num,scheduledEpisodes,publishedEpisodes,pathTrailer);
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
        for(int i = 0; i<seasons.length;i++){
            if(seasons[i] != null){
                out += seasons[i].toString()+"\n";
            }
        }
    	return out;
    }

}
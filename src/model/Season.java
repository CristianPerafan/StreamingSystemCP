package model;

public class Season{
	private int scheduledEpisodes;
	private int publishedEpisodes;
	private String pathTrailer;

	//Constructor method
    /**
      * Description: this is the constructor method to create a Serie.
      * @param scheduledEpisodes int, it represents the amount of scheduled episodes
      of the season.
      * @param publishedEpisodes int, it represents the amount of published episodes
      of the season.
      * @param pathTrailer String, it represents the link to the thrailer video 
      of the season.
      */

	public Season(int scheduledEpisodes, int publishedEpisodes, String pathTrailer){
		this.scheduledEpisodes = scheduledEpisodes;
		this.publishedEpisodes = publishedEpisodes;
		this.pathTrailer = pathTrailer;
	}

	//GETTERS
	public int getScheduleEpisodes(){
		return scheduledEpisodes;
	}
	public int getPublishedEpisodes(){
		return publishedEpisodes;
	}
	public String getPathTrailer(){
		return pathTrailer;
	}

	//SETTERS
	public void setScheduleEpisodes(int scheduledEpisodes){
		this.scheduledEpisodes = scheduledEpisodes;
	}
	public void setPublishedEpisodes(int publishedEpisodes){
		this.publishedEpisodes = publishedEpisodes;
	}
	public void setPathTrailer(String pathTrailer){
		this.pathTrailer = pathTrailer;
	}

    //TO STRING
	public String toString(){
		String out = "";
		out += "Number of scheduled episodes : "+ scheduledEpisodes+ " episodes\n";
		out += "Number of published episodes: "+ publishedEpisodes +" episodes\n";
		out += "Thrailer link: "+pathTrailer+"\n";
		return out;
	}
}
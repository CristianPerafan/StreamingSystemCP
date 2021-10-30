package model;

public class Season{
	private int num;
	private int scheduledEpisodes;
	private int publishedEpisodes;
	private String pathTrailer;

	public Season(int num, int scheduledEpisodes, int publishedEpisodes, String pathTrailer){
		this.num = num;
		this.scheduledEpisodes = scheduledEpisodes;
		this.publishedEpisodes = publishedEpisodes;
		this.pathTrailer = pathTrailer;
	}

	//GETTERS
	public int getNum(){
		return num;
	}
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
	public void setNum(int num){
		this.num = num;
	}
	public void setScheduleEpisodes(int scheduledEpisodes){
		this.scheduledEpisodes = scheduledEpisodes;
	}
	public void setPublishedEpisodes(int publishedEpisodes){
		this.publishedEpisodes = publishedEpisodes;
	}
	public void setPathTrailer(String pathTrailer){
		this.pathTrailer = pathTrailer;
	}


	public String toString(){
		String out = "";
		out += "Season number: " + num + "\n";
		out += "Number of episodes scheduled: "+ scheduledEpisodes+ " episodes\n";
		out += "Number of published episodes: "+ publishedEpisodes +" episodes\n";
		out += "Thrailer link: "+pathTrailer+"\n";
		return out;
	}
}
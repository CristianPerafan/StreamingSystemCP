package model;

public class Channel{

	//Attributes
	private String name;
	private String nit;
	private String adress;
	private String adressWebSite;

	//RelationShips
	private Subscriber [] subscribers;
	private Product [] products;

	//Constructor method
	public Channel(String nit, String adress,String adressWebSite){
		name = "BlackNail";
		this.nit = nit;
		this.adress = adress;
		this.adressWebSite = adressWebSite;

		// initializing the array for Subscriber:
		subscribers = new Subscriber[50];
		//// initializing the array for Products:
		products = new Product[85];

	}

	//GETTERS
	public String getName(){
		return name;
	}
	public String getNit(){
		return nit;
	}
	public String getAdress(){
		return adress;
	}
	public String getAdressWebSite(){
		return adressWebSite;
	}

	//SETTERS
	public void setName(String name){
		this.name = name;
	}
	public void setNit(String nit){
		this.nit = nit;
	}
	public void setAdress(String adress){
		this.adress = adress;
	}
	public void setAdressWebSite(String adressWebSite){
		this.adressWebSite = adressWebSite;
	}

	///Method Channel: toString (String) //

	/**
      * Description: in this methodwe concatenate the attributes of the cana object
       to be able to show them to the user.
      * @return out String, in this variable we save the information of the Channel
      */
	public String toString(){
		String out = "";
		out += "Name: "+name+"\n";
		out += "Nit: "+nit+"\n";
		out += "Adress: "+adress+"\n";
		out += "Adress web site: "+adressWebSite;

		return out;
	}

	///Method Channel: addSubscriber (void) //

	/**
      * Description: in this method we will add a subscriber type object 
      to the subscriber class
      * @param id String, it represents the id of the suscriber. 
      * @param fullName String, it represents the full name the suscriber. 
      * @param age int, it represents the age of the suscriber. 
      * @param consumptionHours int, it represents the hours that the suscriber is willing
       to consume of the channel. 
      * @param numCustomerLevel int, it represents represents a number that corresponds 
      to a customer level
      */

    public void addSubscriber(String id, String fullName, int age, int consumptionHours, 
		int numCustomerLevel ){
		int i = thereIsSpaceForSubscriber();
		subscribers[i] = new Subscriber(id,fullName,age, consumptionHours, numCustomerLevel);
	}	

	///Method Channel: addFilm (void) //

	/**
      * Description: in this method we will add a film type object 
      to the product class, because by inheritance this object can behave as a subclass.
      * @param productName String, it represents the name of the product (film). 
      * @param movieDirector String, it represents the name of the director (film). 
      * @param synopsis int, it represents the abstract of the product (film) 
      * @param day int, it represents represents the day when the product was released.
      * @param month int, it represents represents the month when the product was released.
      * @param year int, it represents represents the year when the product was released.
      * @param producer String, it represents the name of the producer of the product.
      * @param minimumAge int, it  represents the recommended age to watch the movie.
      * @param numCategory int, it  represents a number that identifies the category 
       movie of the film.
      */

	public void addFilm(String productName, String movieDirector, String synopsis, int day,
        int month, int year, String producer, int minimumAge, int numCategory){

		int i = thereIsSpaceForProduct();
		products[i] = new Films(productName,movieDirector,synopsis,day,
        month,year,producer,minimumAge,numCategory);
	}

	///Method Channel: addSerie (void) //

	/**
      * Description: in this method we will add a serie type object 
      to the product class, because by inheritance this object can behave as a subclass.
      * @param productName String, it represents the name of the product (film). 
      * @param movieDirector String, it represents the name of the director (film). 
      * @param synopsis int, it represents the abstract of the product (film) 
      * @param day int, it represents represents the day when the product was released.
      * @param month int, it represents represents the month when the product was released.
      * @param year int, it represents represents the year when the product was released.
      * @param censoredSerie boolean, if censoredSerie = true the serie has been censored, 
      else the serie hasn´t been censored
      * @param razonCensored String, if censoredSerie = true, it represents the razon why
      the serie was censored.
      * @param numActors int, it  represents the number of principal actor that has the 
      serie.
      * @param numSeason int, it  represents the amount of seasons of the serie.
      * @param num int, it  represents the number of one season(Season 1, Season 2 ..etc).
      * @param scheduledEpisodes int, it  represents the amount of scheduled episodes
      of the serie.
      * @param publishedEpisodes int, it  represents the amount of published episodes of
      the serie.
      * @param  pathTrailer String, it  represents the link to the video of the thrailer.
      * @param  auxActors String [], it  represents an auxiliary array where the name 
      of the actors are saved .
      */

	public void addSerie(String productName, String movieDirector, String synopsis, int day,
        int month, int year, boolean censoredSerie, String razonCensored, int numActors, 
    	int numSeason, int num, int scheduledEpisodes, int publishedEpisodes, 
        String pathTrailer, String [] auxActors){

		int i = thereIsSpaceForProduct();
		products[i] = new Series(productName,movieDirector,synopsis, day,month,year,
		censoredSerie,razonCensored,numActors,numSeason,num,scheduledEpisodes,publishedEpisodes, 
        pathTrailer, auxActors);

	}


	///Method Channel: thereIsSpaceForSuscriber (int) //
	/**
      * Description: in this method we will ckek if there is a space
      in the object array for subscribers
      * @return pos int, if pos = -1, there isn´t a space in the array else there is space
      and we can save a new suscriber.
      */
	public int thereIsSpaceForSubscriber(){
		int pos = -1;
		boolean flag = false;

		for(int i = 0; i <subscribers.length && !flag;i++){
			if(subscribers[i] == null){
				flag = true;
				pos = i;
			}
		}
		return pos;

	}

	///Method Channel: verifyIdExist(boolean) //

	/**
      * Description: in this method we will ckek if the id that the user enter has been
      already registered before.
      * @param id String, it represents the id that the user entered 
      * @return out boolean, if boolean = true then the id has been already registered else
      the id hasn´t been alreayd registered
      */


	public boolean verifyIdExist(String id){

		boolean out = false;

		for(int i = 0; i<subscribers.length;i++){

			if(subscribers[i] != null){
				if(subscribers[i].getId().equals(id)){
					out = true;
				}
			}
		}

		return out;
	}

	///Method Channel: verifyIdExist(String) //
	/**
      * Description: in this method we will concatenate the information of the subscribers
      that have been already registered.
      * @return out String, it represent the information of the subscribers than have
      been already regustered.
      */

	public String showSubscriber(){
		String out = "";
		for(int i = 0; i<subscribers.length;i++){
			if(subscribers[i] != null){
				out += "Subscriber "+(i+1)+"\n";
				out += subscribers[i].toString()+"\n";
				out += "  \n";
			}
		}
		return out;
	}

	///Method Channel: showOneSubscriber (String) //

	/**
      * Description: in this method we will concatenate the information of only one
      subscriber
      * @param numDeactive String, it represents the position of the Subscriber array that
      we want to extract the information. 
      * @return out String, it contains the information of the Subscriber.
      */

	public String showOneSubscriber(int numDeactive){
		String out = "";
		if(subscribers[numDeactive] != null){
			out = subscribers[numDeactive].toString();
		}
		else{
			System.out.println("The subscriber has not been registered!!!");		
		}
		return out;
		
	}

    ///Method Channel: verifySubscriberExist (boolean) //
	/**
      * Description: in this method we will ckek if the object exist.
      * @param numDeactive int, it represents the position of object array of subscribers  
      * @return out boolean, if out = true then the subscriber exists else the subscriber 
      * does not exist.
      */
	public boolean verifySubscriberExist(int numDeactive){
		boolean out = true;
		if(subscribers[numDeactive] == null){
			out = false;
		}
		return out;
	}


    ///Method Channel: changesOfDeactivation (void) //
	/**
      * Description: In this method we will make the changes to the subscriber when 
      the user wishes to deactivate it.
      * @param numDeactive int, it represents the position of object array of subscribers  
      */

	public void changesOfDeactivation(int numDeactive){
		int numCustomerLevel = 1;
		boolean active = false;
		subscribers[numDeactive].setTypeLeve(numCustomerLevel);
		subscribers[numDeactive].setActive(active);
	}

    ///Method Channel: showAmountActiveSubscribers (String) //
	/**
      * Description: In this method we will concatenate the information of the number of active
       subscribers and their amount for each type of client 
      * @return out String, it contains the information of the number of active
       subscribers and their amount for each type of client 
      */

	public String showAmountActiveSubscribers(){
		String out = "";
		int activeAmount = 0;
		int normalAmount = 0;
		int platinumAmount = 0;
		int goldAmount = 0;
		int diamondAmount = 0;

		for(int i = 0;i<subscribers.length;i++){
			if(subscribers[i] != null){
				if(subscribers[i].getActive() == true){
					activeAmount += 1;
					if(subscribers[i].getTypeLevel() == CustomerType.NORMAL){
					    normalAmount += 1;
				    }
				    else if(subscribers[i].getTypeLevel() == CustomerType.PLATINUM){
				    	platinumAmount += 1;
				    }
				    else if(subscribers[i].getTypeLevel() == CustomerType.GOLD){
				    	goldAmount += 1;
				    }
				    else if(subscribers[i].getTypeLevel() == CustomerType.DIAMOND){
				    	diamondAmount += 1;
				    }
				}
				
			}

		}

		out += "Active subscribers: "+activeAmount+"\n";
		out += "Normal subscribers: "+normalAmount+"\n";
		out += "Platinum subscribers: "+platinumAmount+"\n";
		out += "Gold subscribers: "+goldAmount+"\n";
		out += "Diamond subscriber: "+diamondAmount;
		return out;
	}

	///Method Channel: verifySubscriberExist (boolean) //
	/**
      * Description: in this method we will find the minor with greater number of hours 
      willing to consume.  
      * @return out String, it contains the name and hours of the minor with greater number 
      of hours willing to consume.  
      */

	public String verifyMenor(){
		String out = "";
		int hoursMenor = 0;
		String name = "";

		for(int i = 0; i < subscribers.length; i++){
			if(subscribers[i] != null){
				if(subscribers[i].getAge() < 18){

					if(i == 0){
						hoursMenor = subscribers[i].getConsumptionHours();
					    name = subscribers[i].getFullName();
					}

					if(i > 0){
						if(subscribers[i].getConsumptionHours()>hoursMenor){
							hoursMenor = subscribers[i].getConsumptionHours();
							name = subscribers[i].getFullName();
						}
					}
				}	
			}
		}
		out += "///// SUBSCRIBER /////\n";

		out += "Name: "+name+"\n";
		out += "Hours: "+hoursMenor;
		return out;
	}

	///Method Channel: thereIsSpaceForProduct(int) //

	/**
      * Description: in this method we will ckek if there is a space to save a new 
      product
      * @return pos int, it represents the position in the array of products where
      we can save a new product, if pos = -1 there aren´t positions to save a new
      product.
      */


	public int thereIsSpaceForProduct(){
		int pos = -1;
		boolean flag = false;

		for(int i = 0; i <products.length && !flag;i++){
			if(products[i] == null){
				flag = true;
				pos = i;
			}
		}
		return pos;
	}

	///Method Channel:  verifyNameExist(boolean) //

	/**
      * Description: in this method we will ckek if the name of a new product has been
      registered.
      * @param productName String, it represents the name of the new product.  
      * @return out boolean, if out = true the name has been already registered, else
      the name hasn't been registered.
      */


	public boolean verifyNameExist(String productName){
		boolean  out = false;

		for(int i = 0; i<products.length;i++){
			if(products[i] != null){
				if(products[i].getProductName().equals(productName)){
					out = true;
				}
			}

		}

		return out;
	}

	///Method Channel: showInformationOfProducts(String) //

	/**
      * Description: in this method we will concatenate the information of all the
      products that have been registered . 
      * @return out String, it represents the information of the all products.
      */



	public String showInformationOfProducts(){
		String out = "";
		for(int i = 0; i<products.length; i++){
			if(products[i] != null){
				out += "*** Product "+(i+1)+" ***\n";
				out += products[i].toString()+"\n";
			}
		}
		return out;
	}
	
}

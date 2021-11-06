package ui; 

import java.util.Scanner;

import model.Channel;

public class StreamingSystem {
	
	private Channel streamingChannel;
	//Declaration of the lector object
	private Scanner sc; 


    
	public StreamingSystem() {
		
		sc= new Scanner(System.in);
	}
	

	public static void main(String[] args){
		StreamingSystem pc= new StreamingSystem();

		System.out.println("Starting the APP");

		int optionMenu = 0;

		do{
			optionMenu = pc.showMenu();
			pc.executeOperation(optionMenu);
			
		}while(optionMenu != 0);
	}

	///Method StreamingSystem:  showMenun(String) //
	/**
      * Description: in this method we will show to the user the information
      of the main menu of the system and we will ask to the user for one
      option.
      * @return optionMenu int, it contains the option entered by the user.
      */

	public int showMenu(){
		int optionMenu = 0;
		System.out.println(
			    "***** MAIN MENU *****\n"+
			    "1) Create a Channel\n"+
			    "2) Manage subscribers\n"+
			    "3) Show Channel information\n"+
			    "4) Manage products\n"+
			    "0) Exit"
			    );
		optionMenu= sc.nextInt();
		sc.nextLine();
		return optionMenu;
	}

	///Method StreamingSystem:  executeOperation(void) //
	/**
      * Description: in this method we will execute the option entered by the 
      user.
      @param operation int, it represents the option entered by the user.
      */

	public void executeOperation(int operation){
		switch(operation){
		case 0:
		    System.out.println("Bye, see you soon");
		    break;
		case 1:
		    createAChannel();
			
		    break;
		case 2:
		   
		    if(streamingChannel == null){
		        System.out.println("You must fill in the channel information first!!!!");	
		    }
		    else{
		    	showMenuSuscriber();
		    }
		    break;

		case 3:
		   System.out.println("/// CHANNEL INFORMATION ///");
		   if(streamingChannel == null){
		   	    System.out.println("You must fill in the channel information first!!!!");	
		   }
		   else{
		   	    System.out.println(streamingChannel.toString());
		   }
		   break;

		case 4:
		    if(streamingChannel == null){
		        System.out.println("You must fill in the channel information first!!!!");	
		    }
		    else{
		    	ShowMenuProducts();
		    }
		    break;

		default:
		    System.out.println("Invalid option!!!!");
		}
	}

	///Method StreamingSystem:  showMenuSuscriber (void) //
	/**
      * Description: in this method we will show the information of the 
      subscribers menu and we will ask to the user for one option
      */

	private void showMenuSuscriber(){
		int optionMenu = 0;
		System.out.println("/// MANAGE SUBSCRIBERS ///");

		System.out.println(
				"Suscriber Menu\n" +
				"(1) Create a suscriber\n" +
				"(2) Deactive a suscriber\n"+
				"(3) Show the information of all subscribers\n"+
				"(4) Active subscribers for each type of customer\n"+
				"(5) Minor with greater number of hours willing to consume\n"+
				"(0) Back"
				

				);	
		optionMenu = sc.nextInt();
		sc.nextLine();
		
		switch(optionMenu) {
		case 0:
		    break;
		    
		case 1:
			createASuscriber();
			break;
		case 2:
		    deactiveASubscriber();
		
			break;

		case 3:
		    System.out.println("///// SUBSCRIBERS INFORMATION /////");
		    System.out.println(streamingChannel.showSubscriber());
		    

		    break;

		case 4:
		    System.out.println("///// ACTIVE SUBSCRIBERS FOR EACH TYPE OF CUSTOMER /////");
		    System.out.println(streamingChannel.showAmountActiveSubscribers());
		    break;

		case 5:
		    System.out.println("///// MINOR SUSCRIBER WITH GREATER NUMBER OF HOURS WILLING TO CONSUME /////");
		    System.out.println(streamingChannel.verifyMenor());
		    break;

		default:
		    System.out.println("No valid option!!!!");
		}
	}

	///Method StreamingSystem:   ShowMenuProducts (void) //
	/**
      * Description: in this method we will show the information of the 
      products menu and we will ask to the user for one option
      */

	private void ShowMenuProducts(){
		int optionMenu = 0;
		System.out.println("///// MANAGE PRODUCTS /////");
		System.out.println(
			    "Products Menu \n"+
			    "(1) Create a serie\n"+
		 	    "(2) Create a film\n"+
		 	    "(3) Show all products\n"+
				"(4) Find a product\n"+
				"(5) Create the next season of a serie\n"+
				"(6) Show all the films according to a category\n"+
				"(7) Show all the series and its information of the last season\n"+
				"(0) Back"
		        );

		optionMenu = sc.nextInt();
		sc.nextLine();

		switch(optionMenu){
		case 0:
		    break;
		
		case 1:
		    createASerie();
			break;
	    case 2:
	        createAFilm();
			break;

		case 3:
		    if(streamingChannel.thereIsntProducts()){
				System.out.println("There are not products registered!!!!");
				
			}
			else{
				System.out.println("///// PRODUCTS INFORMATION /////");
		        System.out.println(streamingChannel.showInformationOfProducts());
			}
		    
		    break;
		case 4:
		    if(streamingChannel.thereIsntProducts()){
				System.out.println("There are not products registered!!!!");
				
			}
			else{
				findAProduct();
				


			}
		    break;
			
	    case 5:
		    if(streamingChannel.thereIsntProducts()){
				System.out.println("There are not products registered!!!!");
				
			}
			else{
				createANewSerie();
			}
		    break;
		case 6:
		    if(streamingChannel.thereIsntProducts()){
				System.out.println("There are not products registered!!!!");
				
			}
			else{
		        showAllTheFilmsAccordingToACategory();
		    }
		 
			break;
		case 7:
		    if(streamingChannel.thereIsntProducts()){
				System.out.println("There are not products registered!!!!");
				
			}
			else{
				showAllTheSeriesAndItsLastSeason();
		    }
		    break;
	    default:
		    System.out.println("No valid option!!!!");
		}
	}

	///Method StreamingSystem:    createASuscriber (void) //
	/**
      * Description: in this method we will ask the neccesary information 
      to create a subscriber and we will call the method addSubscriber
      of the controlling class
      */

	private void createASuscriber(){
		String id,fullName; 
		int age,consumptionHours,numCustomerLevel;
		boolean next = true;

		System.out.println("/////CREATE A SUSCRIBER/////");

        System.out.println("Please enter the following information");
	    System.out.println("Id:");
	    id = sc.nextLine();

	    next = streamingChannel.verifyIdExist(id);

	    while(next == true){
            System.out.println("The id has been already registered, please enter another id");
            id = sc.nextLine();
            next = streamingChannel.verifyIdExist(id);
	    }

	    

		System.out.println("Full name:");
		fullName = sc.nextLine();

		System.out.println("Age:");
		age = sc.nextInt();
		sc.nextLine();

		System.out.println("Number of hours that the client is willing to consume:");
		consumptionHours = sc.nextInt();
		sc.nextLine();

		System.out.println("Customer level: \n"+
			"1) Normal\n"+
			"2) Platinum\n"+
			"3) Gold \n"+
			"4) Diamond \n"
	    );

		numCustomerLevel = sc.nextInt();
		numCustomerLevel = (numCustomerLevel-1);
		sc.nextLine();

		if(streamingChannel.thereIsSpaceForSubscriber() == -1){
			System.out.println("You can't create more subscribers!!!!");
		}
		else{
			streamingChannel.addSubscriber(id,fullName,age,consumptionHours,numCustomerLevel);
		    System.out.println("The subscriber has been created successfully");
		}

	}

	///Method StreamingSystem:    createASuscriber (void) //
	/**
      * Description: in this method we will ask the neccesary information 
      to create a channel and we will call the constructor method to
      create a Channel of the controlling class
      */

	private void createAChannel(){
		String nit, adress, adressWebSite;

		System.out.println("///CREATE A CHANNEL///");
		System.out.println("Please enter the following information");

		System.out.println("Nit: ");
		nit = sc.nextLine();

		System.out.println("Adress:");
		adress = sc.nextLine();

		System.out.println("Adress web site: ");
		adressWebSite = sc.nextLine();

		streamingChannel = new Channel(nit,adress,adressWebSite);
		System.out.println("The channel has been created successfully");
	}

	///Method StreamingSystem: createAFilm (void) //
	/**
      * Description: in this method we will ask the neccesary information 
      to create a Film and we will call the method addFilm of the controlling class
      */

	private void createAFilm(){
		String productName, movieDirector, synopsis, producer;
		int day,month,year,numCategory, minimumAge;
		boolean next = true;

		System.out.println("///CREATE A FILM///");
		System.out.println("Please enter the following information");
		System.out.println("Name: ");
		productName = sc.nextLine();
		next = streamingChannel.verifyNameExist(productName);

		while(next == true){
			System.out.println("The name has been already registered, please enter another name");
			productName = sc.nextLine();
            next = streamingChannel.verifyNameExist(productName);
		}

		System.out.println("Name of the director: ");
		movieDirector = sc.nextLine();
		System.out.println("sypnosis: ");
		synopsis = sc.nextLine();

		System.out.println("*** RELEASE DATE***");

		System.out.println("Day: ");
		day = sc.nextInt();
		sc.nextLine();
		System.out.println("Month: ");
		month = sc.nextInt();
		sc.nextLine();
		System.out.println("Year: ");
		year = sc.nextInt();
		sc.nextLine();
		

		System.out.print("Name of the producer: \n");
		producer = sc.nextLine();

		System.out.println("Minimun age: ");
		minimumAge = sc.nextInt();
		sc.nextLine();

		System.out.println("Movie category: \n"+
			"1) Romantic\n"+
			"2) Action\n"+
			"3) Suspense\n"+
			"4) Horror\n"+
			"5) Comedy "
			);


		numCategory = sc.nextInt();
		numCategory = (numCategory-1);
		sc.nextLine();

		if(streamingChannel.thereIsSpaceForProduct() == -1){
			System.out.println("You can't create more products!!!!");
		}
		else{
			streamingChannel.addFilm(productName,movieDirector, synopsis,day,
				month, year,producer,minimumAge,numCategory);
			System.out.println("The film has been created successfully");
		}

	}

	///Method StreamingSystem: createASerie (void) //
	/**
      * Description: in this method we will ask the neccesary information 
      to create a Serie and we will call the method addSerie of the controlling class
      */

	private void createASerie(){
		String productName,movieDirector,synopsis,anwsCensored,razonCensored, pathTrailer;
		int day,month,year, numActors, numSeason, num, scheduledEpisodes;
		int publishedEpisodes;
		boolean censoredSerie ;
		boolean next = true;



		System.out.println("///CREATE A SERIE///");
		System.out.println("Please enter the following information");
		System.out.println("Name: ");
		productName = sc.nextLine();
		next = streamingChannel.verifyNameExist(productName);
		while(next == true){
			System.out.println("The name has been already registered, please enter another name");
			productName = sc.nextLine();
            next = streamingChannel.verifyNameExist(productName);
		}

		System.out.println("Name of the director: ");
		movieDirector = sc.nextLine();

		System.out.println("Synopsis: ");
		synopsis = sc.nextLine();

		System.out.println("*** RELEASE DATE***");
		System.out.println("Day: ");
		day = sc.nextInt();
		sc.nextLine();
		System.out.println("Month: ");
		month = sc.nextInt();
		sc.nextLine();
		System.out.println("Year: ");
		year = sc.nextInt();
		sc.nextLine();

		System.out.println("Has been the serie censored? Yes or No");
		anwsCensored = sc.nextLine().toUpperCase();
		if(anwsCensored.equals("YES")){
			censoredSerie = true;
			System.out.println("Why the serie was censored?");
			razonCensored = sc.nextLine();
		}
		else{
			censoredSerie = false;
			razonCensored = "The serie has not been censored!!!!";
		}

		System.out.println("Number of main actors: ");
		numActors = sc.nextInt();
		sc.nextLine();

		//Declaration of auxiliary arrangement of actors
		String[] auxActors = new String[numActors];

        System.out.println("Main actors: ");
		for(int i = 0; i<auxActors.length;i++){
			System.out.println("Please enter the name of the main actor "+(i+1)+":");
			auxActors[i] = sc.nextLine();

		}



		System.out.println("***SEASON 1***");
		System.out.println("Please enter the following information");
		num = 1;
		System.out.println("Number of scheduled episodes: ");
		scheduledEpisodes = sc.nextInt();
		sc.nextLine();
		System.out.println("Number of published episodes: ");
		publishedEpisodes = sc.nextInt();
		sc.nextLine();
		System.out.println("Thrailer link: ");
		pathTrailer = sc.nextLine();

		if(streamingChannel.thereIsSpaceForProduct() == -1){
			System.out.println("You can't create more products!!!!");
		}
		else{
			streamingChannel.addSerie(productName,movieDirector,synopsis, day,month,year,
		    censoredSerie,razonCensored,numActors,num,scheduledEpisodes,
		    publishedEpisodes, pathTrailer, auxActors);
		    System.out.println("The serie has been created successfully");
		}

	}

	///Method StreamingSystem: deactiveASubscriber (void) //
	/**
      * Description: in this method we will ask the number of the subscriber that
      the user want to delete and we will delete the subscriber.
      */

	private void deactiveASubscriber(){
		int numDeactive;
		String answer;
		System.out.println("///DEACTIVE A SUSBCRIBER///");
		System.out.println("please enter the subscriber number you wish to deactive:");
		numDeactive = sc.nextInt();
		sc.nextLine();
		numDeactive = (numDeactive-1);

		if(streamingChannel.verifySubscriberExist(numDeactive)){
			System.out.println("*** Information of the subscriber: ***");
			System.out.println(streamingChannel.showOneSubscriber(numDeactive));
			System.out.println("Do you want to deactive the subscriber? Yes or No");
			answer = sc.nextLine().toUpperCase();

			if(answer.equals("YES")){
				streamingChannel.changesOfDeactivation(numDeactive);
				System.out.println("The subscriber has been deactived");

			}
			else{
				System.out.println("Ok");
			}

		}
		else{
			System.out.println("The subscriber has not been registered!!!");
		}
	}

	///Method StreamingSystem: findAProduct (void) //
	/**
      * Description: in this method we will ask to the user the name of a product
      and then we will show the information of that product.
      */


	private void findAProduct(){

        String pName;

		System.out.println("///// FIND A PRODUCT /////");
	    System.out.println("Please enter the name of the product: ");
	    pName = sc.nextLine();
	    if(streamingChannel.verifyNameExist(pName)){
	    	System.out.println( streamingChannel.consultInformationOfAProduct(pName));
	    }
	    else{
	    	System.out.println("The product has not been registered!!!!");
	    }
	}

	///Method StreamingSystem: createANewSerie (void) //
	/**
      * Description: in this method we will ask to the user the necessary
      information to create a new season and then we will create the season.
      */
	
	private void createANewSerie(){
		String productName, pathTrailer;
		int scheduledEpisodes,publishedEpisodes;

		System.out.println("///// CREATE THE NEXT SEASON OF A SERIE /////");
		System.out.println("Please, enter the name of the season: ");
		productName = sc.nextLine();
		if(streamingChannel.verifyNameExist(productName)){
			System.out.println("Enter the scheduled episodes of the serie: ");
			scheduledEpisodes = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the published episodes of the serie: ");
			publishedEpisodes = sc.nextInt();
			sc.nextLine();
			System.out.println("enter the link of the thrailer of the serie: ");
			pathTrailer = sc.nextLine();
			System.out.println(streamingChannel.createAnewSeason(productName,
				scheduledEpisodes,publishedEpisodes,pathTrailer));

		}
		else{
			System.out.println("The serie does not exists!!!!");
		}
	}

	///Method StreamingSystem: showAllTheFilmsAccordingToACategory (void) //
	/**
      * Description: in this method we will ask to the user one category film
      and then we will show all the films according to that category
      */

	private void showAllTheFilmsAccordingToACategory(){

		int numCategory;
		System.out.println("///// SHOW ALL THE FILMS ACORDING TO A CATEGORY /////");

		System.out.println("Movie category: \n"+
			"1) Romantic\n"+
			"2) Action\n"+
			"3) Suspense\n"+
			"4) Horror\n"+
			"5) Comedy "
			);



		numCategory = sc.nextInt();
		sc.nextLine();
		if(numCategory<1 || numCategory>5){
			System.out.println("No valid option!!!");
		}
		else{
			numCategory = (numCategory-1);
			System.out.println(streamingChannel.showFilsmAccorCategory(numCategory));
		}
	}

	///Method StreamingSystem: showAllTheSeriesAndItsLastSeason (void) //
	/**
      * Description: in this method we will show all the series registered and the
      information of its last season.
      */

	private void showAllTheSeriesAndItsLastSeason(){
		System.out.println("///// SHOW ALL THE SERIES AND ITS INFORMATION OF THE LAST SEASON /////");
		System.out.println(streamingChannel.showAllSeriesAndItsLastSeason());
	}
}
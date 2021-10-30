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
		   System.out.println("///CHANNEL INFORMATION///");
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

	private void showMenuSuscriber(){
		int optionMenu = 0;
		System.out.println("///MANAGE SUBSCRIBERS///");

		System.out.println(
				"Suscriber Menu\n" +
				"(1) Create a suscriber\n" +
				"(2) Deactive a suscriber\n"+
				"(3) Show the information of all subscribers\n"+
				"(4) Active subscribers for each type of customer\n"+
				"(5) Minor with greater number of hours willing to consume"

				);	
		optionMenu = sc.nextInt();
		sc.nextLine();
		
		switch(optionMenu) {
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

	private void ShowMenuProducts(){
		int optionMenu = 0;
		System.out.println("/////MANAGE PRODUCTS/////");
		System.out.println(
			    "Products Menu \n"+
			    "(1) Create a serie\n"+
		 	    "(2) Create a film\n"+
		 	    "(3) Show products"
		        );

		optionMenu = sc.nextInt();
		sc.nextLine();

		switch(optionMenu){
		case 1:
		    createASerie();
			break;
	    case 2:
	        createAFilm();
			break;

		case 3:
		    System.out.println("///// PRODUCTS INFORMATION/////");
		    System.out.println(streamingChannel.showInformationOfProducts());
		    break;

	    default:
		    System.out.println("No valid option!!!!");
		}
	}

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

	private void createAChannel(){
		String nit, adress, adressWebSite;

		System.out.println("///CREATE A CHANNEL///");
		System.out.println("Please enter the following information");

		System.out.println("Nit: ");
		nit = sc.nextLine();

		System.out.println("Adress::");
		adress = sc.nextLine();

		System.out.println("Adress web site: ");
		adressWebSite = sc.nextLine();

		streamingChannel = new Channel(nit,adress,adressWebSite);
		System.out.println("The channel has been created successfully");
	}

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

		System.out.println("Number of seasons: ");
		numSeason = sc.nextInt();
		sc.nextLine();


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
		    censoredSerie,razonCensored,numActors, numSeason,num,scheduledEpisodes,
		    publishedEpisodes, pathTrailer, auxActors);
		    System.out.println("The serie has been created successfully");
		}

	}

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



	

}
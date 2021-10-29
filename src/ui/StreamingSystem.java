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
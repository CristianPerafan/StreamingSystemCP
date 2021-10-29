package model;
public class Subscriber{

	//Attributes
	private String id;
	private String fullName;
	private int age;
	private int consumptionHours;
	private boolean active;

	//RelationShips
	private CustomerType typeLevel;

	//Constructor method
	public Subscriber(String id, String fullName, int age, int consumptionHours, 
		int numCustomerLevel){
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.consumptionHours = consumptionHours;
		active = true;
		if(numCustomerLevel == 0){
			typeLevel = CustomerType.NORMAL;
		}
		else if(numCustomerLevel == 1){
			typeLevel = CustomerType.PLATINUM;
		}
		else if(numCustomerLevel == 2){
			typeLevel = CustomerType.GOLD;
		}
		else if(numCustomerLevel == 3){
			typeLevel = CustomerType.DIAMOND;
		}
	}

	//GETTERS
	public String getId(){
	   return id;
	}	
	public String getFullName(){
		return fullName;
	}
	public int getAge(){
		return age;
	}
	
	public int getConsumptionHours(){
		return consumptionHours;
	}
	public boolean getActive(){
		return active;
	}
	public CustomerType getTypeLevel(){
		return typeLevel;
	}

	
	//SETTERS
	public void setId(String id){
		this.id = id;
	}
	public void setFullName(String fullName){
		this.fullName = fullName;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setConsumptionHours(int consumptionHours){
		this.consumptionHours = consumptionHours;
	}
	public void setActive(boolean active){
		this.active = active;
	}

	public void setTypeLeve(int numCustomerLevel){
		if(numCustomerLevel == 0){
			typeLevel = CustomerType.NORMAL;
		}
		else if(numCustomerLevel == 1){
			typeLevel = CustomerType.NORMAL;
		}
		else if(numCustomerLevel == 2){
			typeLevel = CustomerType.NORMAL;
		}
		else if(numCustomerLevel == 3){
			typeLevel = CustomerType.NORMAL;
		}
	}

	//Method to String

	public String toString(){
		String out = "";
		out += "Id: "+id+"\n";
		out += "Name: "+fullName+"\n";
		out += "Age: "+age+"\n";
		out += "Number of hours willing to consume:"+consumptionHours+" hours\n";
		out += "Active: "+active+"\n";
		out += "Customer level: "+typeLevel;

		return out;
	}
}
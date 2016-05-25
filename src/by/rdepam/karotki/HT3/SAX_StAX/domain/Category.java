package by.rdepam.karotki.HT3.SAX_StAX.domain;

import java.util.ArrayList;

public class Category {
	private ArrayList<Dish> Dishes=new ArrayList<Dish>();
	private String ID;
	private String name;
	
	
	public ArrayList<Dish> getDishes(){
		return Dishes;
	}
	
	public void addDish(Dish dish){
		Dishes.add(dish);
	}
	
	public String getID(){
		return ID;
	}
	
	public void setID(String ID){
		this.ID=ID;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}

}

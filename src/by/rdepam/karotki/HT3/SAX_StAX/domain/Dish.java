package by.rdepam.karotki.HT3.SAX_StAX.domain;

import java.util.ArrayList;

public class Dish {
	private String photo;
	private String name;
	private String portion;
	private ArrayList<String> description=new ArrayList<String>();
	private ArrayList<String> price =new ArrayList<String>();
	
	public void setPhoto(String photo){
		this.photo=photo;
	}
	
	public String getPhoto(){
		return photo;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPortion(String portion){
		this.portion=portion;
	}
	
	public String getPortion(){
		return portion;
	}
	
	public void setDescription (String description){
		this.description.add(description);
	}
	
	public String getDescription(int index){
		return description.get(index);
	}
	
	public ArrayList<String> getDescription(){
		return description;
	}
	
	public ArrayList<String> getPrice(){
		return price;
	}
	
	public void setPrice (String price){
		this.price.add(price);
	}
	
	public String getPrice(int index){
		return price.get(index);
	}

}

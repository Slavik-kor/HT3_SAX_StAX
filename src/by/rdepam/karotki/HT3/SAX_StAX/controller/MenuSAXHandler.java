package by.rdepam.karotki.HT3.SAX_StAX.controller;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.rdepam.karotki.HT3.SAX_StAX.domain.Category;
import by.rdepam.karotki.HT3.SAX_StAX.domain.Dish;
import by.rdepam.karotki.HT3.SAX_StAX.domain.MenuTagName;

public class MenuSAXHandler extends DefaultHandler{
	private ArrayList<Category> categories=new ArrayList<Category>();
	private Category category;
	private Dish dish;
	private StringBuilder text;
	private ArrayList<String> header;
	
	public ArrayList<String> getHeader(){
		return header;
	}
	
	public ArrayList<Category> getCategories(){
		return categories;
	}
	
	public void startDocument() throws SAXException{
		System.out.println("Parsing started");
	}
	
	public void endDocument() throws SAXException{
		System.out.println("Parsing finished");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes){
		//System.out.println("startElement -> "+"uri:"+uri+", localName:"+localName+", qName:"+qName);
		text=new StringBuilder();
		if (qName.equals("category")){
			category=new Category();
			category.setID(attributes.getValue("id"));
			category.setName(attributes.getValue("name"));
		}
		
		if (qName.equals("dish")){
			dish=new Dish();
		}
		
		if (qName.equals("header")){
			header=new ArrayList<String>();
		}
		
		
	}
	
	public void characters(char[] buffer, int start, int length){
		text.append(buffer,start,length);
	}
	
	public void endElement(String uri, String localName, String qName){
		MenuTagName tag=null;
		try
		{tag=MenuTagName.getElementTagName(qName);
		}catch(Exception e){e.printStackTrace();}
		
		switch(tag){
		case DISH:
			category.addDish(dish);
			dish=null;
			break;
		case PHOTO:
		    if(dish!=null){	dish.setPhoto(text.toString());
		    } else {
		    	header.add(text.toString());
		    } 
			break;
		case NAME:
			if(dish!=null){dish.setName(text.toString());
			}else {
		    	header.add(text.toString());
		    } 
			break;
		case PORTION:
			if(dish!=null){dish.setPortion(text.toString());
			}else {
		    	header.add(text.toString());
		    } 
			break;
		case ITEM_DISH:
			break;
		case DESCRIPTION:
			if(dish!=null){dish.setDescription(text.toString());
			} else {
		    	header.add(text.toString());
		    } 
			break;
		case PRICE:
			if(dish!=null){dish.setPrice(text.toString());
			} else {
		    	header.add(text.toString());
		    } 
			break;
		case CATEGORY:
			categories.add(category);
			category=null;
			break;	
			
		default:
			break;
		}
	}
	
	
}

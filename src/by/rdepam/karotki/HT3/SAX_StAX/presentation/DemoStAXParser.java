package by.rdepam.karotki.HT3.SAX_StAX.presentation;

import java.io.FileInputStream;
import java.io.InputStream;

import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import by.rdepam.karotki.HT3.SAX_StAX.domain.Category;
import by.rdepam.karotki.HT3.SAX_StAX.domain.Dish;

import by.rdepam.karotki.HT3.SAX_StAX.domain.StAXProcessing;


public class DemoStAXParser {

	public static void main(String[] args) {
		XMLInputFactory inputFactory=XMLInputFactory.newInstance();
		try{
			InputStream input= new FileInputStream("menu.xml");
			XMLStreamReader reader=inputFactory.createXMLStreamReader(input);
			List<Category> menu = StAXProcessing.process(reader);
			
			for (Category cat: menu){
				System.out.println("**********************");
				System.out.println(cat.getName()+"   "+cat.getID());
				System.out.println("**********************");
				 for (Dish dish: cat.getDishes()){
					 System.out.println(dish.getName());
					 System.out.println(dish.getPhoto());
					 for (String i: dish.getDescription()) {
						 System.out.print(i+" | ");}
					 System.out.println();
					 System.out.println(dish.getPortion());
					 for (String j: dish.getPrice()) {
						 System.out.print(j+"  ");}
					 System.out.println();
					 System.out.println("-------------------");
				 }
			}
			
			
		}catch(Exception e){e.printStackTrace();}

	}
	
	
}

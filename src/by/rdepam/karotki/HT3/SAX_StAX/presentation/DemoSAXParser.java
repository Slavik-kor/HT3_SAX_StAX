package by.rdepam.karotki.HT3.SAX_StAX.presentation;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.rdepam.karotki.HT3.SAX_StAX.controller.MenuSAXHandler;
import by.rdepam.karotki.HT3.SAX_StAX.domain.Category;
import by.rdepam.karotki.HT3.SAX_StAX.domain.Dish;

public class DemoSAXParser {

	public static void main(String[] args) throws SAXException, IOException{
		XMLReader reader=XMLReaderFactory.createXMLReader();
		MenuSAXHandler handler=new MenuSAXHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("menu.xml"));
		
		
		
		List<Category> menu=handler.getCategories();
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

	}

}

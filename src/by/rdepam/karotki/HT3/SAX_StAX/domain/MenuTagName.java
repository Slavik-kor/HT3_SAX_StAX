package by.rdepam.karotki.HT3.SAX_StAX.domain;

public enum MenuTagName {
HEADER, CATEGORY, DISH, PHOTO, NAME, PORTION, DESCRIPTION, PRICE, ITEM_DISH, MAIN_MENU; 

public static MenuTagName getElementTagName (String element) throws Exception{
	switch(element){
	case "header":
		return HEADER;
		
	case "category":
		return CATEGORY;
			
	case "dish":
		return DISH;
		
	case "photo":
		return PHOTO;
		
	case "name":
		return NAME;
			
	case "portion":
		return PORTION;
			
	case "description":
		return DESCRIPTION;
			
	case "price":
		return PRICE;
			
	case "item-dish":
		return ITEM_DISH;
		
	case "main-menu":
		return MAIN_MENU;
			
	default: 
		throw new Exception();
		
	}
}
}

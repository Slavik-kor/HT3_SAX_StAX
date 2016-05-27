package by.rdepam.karotki.HT3.SAX_StAX.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamReader;

import by.rdepam.karotki.HT3.SAX_StAX.domain.Category;
import by.rdepam.karotki.HT3.SAX_StAX.domain.Dish;
import by.rdepam.karotki.HT3.SAX_StAX.domain.MenuTagName;
import by.rdepam.karotki.HT3.SAX_StAX.domain.XMLStreamConstants;

public class StAXProcessing {

	public static List<Category> process(XMLStreamReader reader) throws Exception {
		List<Category> menu = new ArrayList<Category>();
		Category category = null;
		Dish dish = null;
		MenuTagName elementName = null;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = MenuTagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case CATEGORY:
					category = new Category();
					category.setID(reader.getAttributeValue(null, "id"));
					category.setName(reader.getAttributeValue(null, "name"));
					break;
				case DISH:
					dish = new Dish();
					break;
				default:
					break;
				}

				break;

			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				switch (elementName) {
				case PHOTO:
					if (dish != null) {
						dish.setPhoto(text);
					}
					break;
				case NAME:
					if (dish != null) {
						dish.setName(text);
					}
					break;
				case PORTION:
					if (dish != null) {
						dish.setPortion(text);
					}
					break;
				case DESCRIPTION:
					if (dish != null) {
						dish.setDescription(text);
					}
					break;
				case PRICE:
					if (dish != null) {
						dish.setPrice(text);
					}
					break;
				default:
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				elementName = MenuTagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case CATEGORY:
					menu.add(category);
					category = null;
					break;
				case DISH:
					category.addDish(dish);
					dish = null;
					break;
				default:
					break;
				}
				break;
			}

		}

		return menu;
	}

}

package me.json.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class Province {
	private int id;

	private String name;
	private List<City> cities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public Province() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Province(int id, String name, List<City> cities) {
		super();
		this.id = id;
		this.name = name;
		this.cities = cities;
	}

	public static Province fromJsonParser(JsonParser jsonParser)
			throws JsonParseException, IOException {

		Province province = null;

		if (jsonParser.getCurrentToken() != JsonToken.VALUE_NULL) {

			while (jsonParser.nextToken() != JsonToken.END_OBJECT) {

				String fieldName = jsonParser.getCurrentName();

				if (fieldName == null) {
					continue;
				}

				if (province == null) {
					province = new Province();
				}

				if ("id".equals(fieldName)) {
					jsonParser.nextToken();
					province.id = jsonParser.getIntValue();
					continue;
				}

				if ("name".equals(fieldName)) {
					jsonParser.nextToken();
					province.name = jsonParser.getText();
					continue;
				}
				if ("cities".equals(fieldName)) {
					jsonParser.nextToken();
					province.cities = new ArrayList<City>();
					while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
						City city = City.fromJsonParser(jsonParser);
						province.cities.add(city);
					}
					continue;
				}

				jsonParser.skipChildren();
			}
		}

		return province;
	}

}

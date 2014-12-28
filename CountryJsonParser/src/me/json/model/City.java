package me.json.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class City {

	private int id;

	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City() {
		super();
	}

	public City(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public static City fromJsonParser(JsonParser jsonParser)
			throws JsonParseException, IOException {

		City city = null;

		if (jsonParser.getCurrentToken() != JsonToken.VALUE_NULL) {

			while (jsonParser.nextToken() != JsonToken.END_OBJECT) {

				String fieldName = jsonParser.getCurrentName();

				if (fieldName == null) {
					continue;
				}

				if (city == null) {
					city = new City();
				}

				if ("id".equals(fieldName)) {
					jsonParser.nextToken();
					city.id = jsonParser.getIntValue();
					continue;
				}

				if ("name".equals(fieldName)) {
					jsonParser.nextToken();
					city.name = jsonParser.getText();
					continue;
				}
				jsonParser.skipChildren();
			}
		}

		return city;
	}

}

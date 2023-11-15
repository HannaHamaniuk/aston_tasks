package org.example.constants;

public class AppConstants {
    public static final String QUERY_NAME = "SELECT id, name, capital, president,population FROM country WHERE name LIKE ?";
    public static final String QUERY_ID = "SELECT id, name, capital, president,population FROM country WHERE id>=? AND id<=?";
    public static final String QUERY_ALL = "SELECT  id, name, capital, president,population FROM country ";
    public static final String INSERT_COUNTRY = "INSERT INTO country(name, capital, president, population) VALUES (?, ?, ?, ?)";
    public static final String QUERY_CITY = "SELECT title, city.id from city join country_city on city.id = city_id join country on country.id=country_id where country.id=?";

}

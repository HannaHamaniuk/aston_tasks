package org.example.model.dao;

import org.example.model.db.ConnectionManager;
import org.example.model.entities.CityInCountry;
import org.example.model.entities.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.AppConstants.*;

public class CountryDao {
    public Country findByName(String name) {
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = cn.prepareStatement(QUERY_NAME)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String capital = resultSet.getString("capital");
                String president = resultSet.getString("president");
                int population = resultSet.getInt("population");
                return new Country(id, name, capital, president, population);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Country> findCountryByIds(int from, int to) {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(QUERY_ID)) {
            ps.setInt(1, from);
            ps.setInt(2, to);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String capital = rs.getString("capital");
                String president = rs.getString("president");
                int population = rs.getInt("population");
                countries.add(new Country(id, name, capital, president, population));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(QUERY_ALL)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String capital = resultSet.getString("capital");
                String president = resultSet.getString("president");
                int population = resultSet.getInt("population");
                countries.add(new Country(id, name, capital, president, population));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return countries;
    }

    public void saveCountry(Country country) {
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(INSERT_COUNTRY)) {
            ps.setString(1, country.getName());
            ps.setString(2, country.getCapital());
            ps.setString(3, country.getPresident());
            ps.setInt(4, country.getPopulation());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CityInCountry> getCityByCountryId(int id) {
        List<CityInCountry> cities = new ArrayList<>();
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(QUERY_CITY)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                cities.add(new CityInCountry(title, id));
                return cities;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

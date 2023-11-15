package org.example.model.services;

import org.example.model.dao.CountryDao;
import org.example.model.entities.CityInCountry;
import org.example.model.entities.Country;

import java.util.List;

public class CountryService {
    private CountryDao countryDao;

    public CountryService() {
        countryDao = new CountryDao();
    }

    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }

    public void saveCountry(Country country) {
        countryDao.saveCountry(country);
    }


    public List<CityInCountry> getCityByCountryId(int id) {
        return countryDao.getCityByCountryId(id);

    }
}

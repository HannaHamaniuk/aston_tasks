package org.example.controllers;

import org.example.model.entities.Country;
import org.example.model.services.CountryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "saveCountryController", urlPatterns = "/save")
public class SaveCountryController extends HttpServlet {
    private CountryService countryService;

    @Override
    public void init() throws ServletException {
        countryService = new CountryService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String capital = req.getParameter("capital");
        String president = req.getParameter("president");
        int population = Integer.parseInt(req.getParameter("population"));
        Country country = new Country( name,capital,president,population);
        countryService.saveCountry(country);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/all");
        requestDispatcher.forward(req,resp);


    }
}

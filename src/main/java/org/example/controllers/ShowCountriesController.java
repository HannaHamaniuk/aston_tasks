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
import java.util.List;

@WebServlet(name = "showCountriesController",urlPatterns = "/all")
public class ShowCountriesController extends HttpServlet {
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
        List<Country> countries = countryService.getAllCountries();
        req.setAttribute("countries",countries);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(req,resp);

    }
}

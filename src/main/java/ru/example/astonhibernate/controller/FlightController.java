package ru.example.astonhibernate.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.example.astonhibernate.model.dto.flight.FlightDtoRq;
import ru.example.astonhibernate.service.impl.FlightServiceImpl;

@Controller
@RequestMapping("/flight")
public class FlightController {
    private final FlightServiceImpl flightServiceImpl;

    @Autowired
    public FlightController(FlightServiceImpl flightServiceImpl) {
        this.flightServiceImpl = flightServiceImpl;
    }

    @GetMapping
    public String getAllFlight(Model model) {
        model.addAttribute("flights", flightServiceImpl.getAllFlight());
        return "get-all-flights";
    }

    @GetMapping("/create")
    public String createFlight(Model model) {
        model.addAttribute("flight", new FlightDtoRq());
        return "create-flight";
    }

    @PostMapping("/create")
    public String createFlight(FlightDtoRq flightDtoRq) {
        flightServiceImpl.saveOrUpdateFlight(flightDtoRq);
        return "redirect:/flight";
    }

    @GetMapping("/update/{id}")
    public String updateFlight(@PathVariable Integer id, Model model) {
        model.addAttribute("flight", flightServiceImpl.getFlightById(id));
        return "update-flight";
    }

    @PostMapping("/update/{id}")
    public String updateFlight(FlightDtoRq flightDtoRq) {
        flightServiceImpl.saveOrUpdateFlight(flightDtoRq);
        return "redirect:/flight";
    }

    @PostMapping("/delete/{id}")
    public String deleteFlight(@PathVariable Integer id) {
        flightServiceImpl.deleteFlight(id);
        return "redirect:/flight";
    }

    @GetMapping("/userflights")
    public String getUsersFlights(Model model) {
        model.addAttribute("flights", flightServiceImpl.getUsersFlights());
        return "get-users-flights";
    }
}
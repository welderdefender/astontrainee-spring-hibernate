package ru.example.astonhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.example.astonhibernate.model.dto.airportCodes.AirportCodesDtoRq;
import ru.example.astonhibernate.service.impl.AirportCodesServiceImpl;

@Controller
@RequestMapping("/airportcodes")
public class AirportCodesController {
    private final AirportCodesServiceImpl airportCodesServiceImpl;

    @Autowired
    public AirportCodesController(AirportCodesServiceImpl airportCodesServiceImpl) {
        this.airportCodesServiceImpl = airportCodesServiceImpl;
    }

    @GetMapping()
    public String getAllAirportCodes(Model model) {
        model.addAttribute("airportcodes", airportCodesServiceImpl.getAllAirportCodes());
        return "get-all-airportcodes";
    }

    @GetMapping("/{id}")
    public String findCode(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("airportcodes", airportCodesServiceImpl.getAirportCodesById(id));
        return "find-airportcode";
    }

    @GetMapping("/create")
    public String createAirportCodes(Model model) {
        model.addAttribute(new AirportCodesDtoRq());
        return "create-airportcodes";
    }

    @PostMapping("/create")
    public String createAirportCodes(AirportCodesDtoRq airportCodesDtoRq) {
        airportCodesServiceImpl.saveOrUpdateAirportCodes(airportCodesDtoRq);
        return "redirect:/airportcodes";
    }

    @GetMapping("/update/{id}")
    public String updateAirportcodes(@PathVariable Integer id, Model model) {
        model.addAttribute("airportcode", airportCodesServiceImpl.getAirportCodesById(id));
        return "update-airportcodes";
    }

    @PostMapping("/update/{id}")
    public String updateAirportcodes(AirportCodesDtoRq airportCodesDtoRq) {
        airportCodesServiceImpl.saveOrUpdateAirportCodes(airportCodesDtoRq);
        return "redirect:/airportcodes";
    }

    @PostMapping("/delete/{id}")
    public String deleteAirportCodes(@PathVariable Integer id) {
        airportCodesServiceImpl.deleteAirportCodes(id);
        return "redirect:/airportcodes";
    }
}
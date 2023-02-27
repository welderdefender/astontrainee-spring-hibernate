package ru.example.astonhibernate.service.impl;

import org.springframework.stereotype.Service;
import ru.example.astonhibernate.dao.AirportCodeDao;
import ru.example.astonhibernate.model.AirportCodes;
import ru.example.astonhibernate.service.AirportCodesService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AirportCodesServiceImpl implements AirportCodesService {
    private AirportCodeDao airportCodeDao;


    public void setAirportCodeDao(AirportCodeDao airportCodeDao) {
        this.airportCodeDao = airportCodeDao;
    }

    @Transactional
    public void addAirportCode(AirportCodes airportCodes) {
        this.airportCodeDao.addAirportCode(airportCodes);
    }

    @Transactional
    public void updateAirportCode(AirportCodes airportCodes) {
        this.airportCodeDao.updateAirportCode(airportCodes);

    }

    @Transactional
    public void removeAirportCode(int id) {
        this.airportCodeDao.removeAirportCode(id);

    }

    @Transactional
    public AirportCodes getById(int id) {
        return this.airportCodeDao.getById(id);
    }

    @Transactional
    public List<AirportCodes> listOfAirportCodes() {
        return this.airportCodeDao.listOfAirportCodes();
    }
}
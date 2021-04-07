package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.hibernate.event.spi.ResolveNaturalIdEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    private WhiskyRepository whiskyRepository;



    @GetMapping(value = "/whisky")
    public ResponseEntity<List<Whisky>> getWhiskyByYear(@RequestParam(name = "year", required = false) String year){
        if (year != null){
            return new ResponseEntity<>(whiskyRepository.findByYear(Integer.parseInt(year)), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whisky")
    public ResponseEntity<List<Whisky>> getByDistilleryNameAndWhiskyAge(
            @RequestParam(name = "name") String name, @RequestParam(name = "year")String year){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryNameAndAge(
                name, Integer.parseInt(year)), HttpStatus.OK);

    }

    @GetMapping(value = "/whisky")
    public ResponseEntity<List<Whisky>> getByDistilleryRegion(
            @RequestParam(name = "region", required = false) String region){
        if (region != null){
            return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

}

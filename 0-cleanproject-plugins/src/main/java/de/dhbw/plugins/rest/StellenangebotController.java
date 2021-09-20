package de.dhbw.plugins.rest;

import de.dhbw.cleanproject.application.stellenangebot.StellenangebotApplicationService;
import de.dhbw.cleanproject.stellenangebot.StellenangebotResource;
import de.dhbw.cleanproject.stellenangebot.StellenangebotToStellenangebotResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/stellenangebot")
public class StellenangebotController {

    private StellenangebotApplicationService stellenangebotApplicationService;

    private StellenangebotToStellenangebotResourceMapper stellenangebotToStellenangebotResourceMapper;

    @Autowired
    public StellenangebotController(StellenangebotApplicationService stellenangebotApplicationService, StellenangebotToStellenangebotResourceMapper stellenangebotToStellenangebotResourceMapper) {
        this.stellenangebotApplicationService = stellenangebotApplicationService;
        this.stellenangebotToStellenangebotResourceMapper = stellenangebotToStellenangebotResourceMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<StellenangebotResource> getStellenangebote() {
        return this.stellenangebotApplicationService.findAllStellenangebote().stream()
                .map(stellenangebotToStellenangebotResourceMapper)
                .collect(Collectors.toList());
    }
}

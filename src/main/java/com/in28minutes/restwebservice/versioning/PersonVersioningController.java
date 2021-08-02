package com.in28minutes.restwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Nacho Peralta");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Nach", "Peralta"));
    }

    // REQUEST PARAM
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Nacho Peralta");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Nacho", "Peralta"));
    }


    // HEADER PARAM
    @GetMapping(value = "/person/headers", headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Nacho Peralta");
    }

    @GetMapping(value = "/person/headers", headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Nacho", "Peralta"));
    }

    // PRODUCES or ACCEPT HEADER VERSIONING or MIME TYPE
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1(){
        return new PersonV1("Nacho Peralta");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Nacho", "Peralta"));
    }

}

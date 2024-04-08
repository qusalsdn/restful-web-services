package com.qusalsdn.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping(path = "/v1/person")
    public PersonV1 getFirstVersioningOfPerson() {
        return new PersonV1("qusalsdn");
    }

    @GetMapping(path = "/v2/person")
    public PersonV2 getSecondVersioningOfPerson() {
        return new PersonV2(new Name("byun", "min"));
    }
}

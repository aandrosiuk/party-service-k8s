package com.aan.partyservice.controller;

import com.aan.partyservice.model.PartyList;
import com.aan.partyservice.model.PartyMember;
import com.aan.partyservice.service.PartyService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/party")
@AllArgsConstructor
@Slf4j
public class PartyController {

    private final PartyService partyService;

    @GetMapping
    public ResponseEntity<PartyList> getAll() {
        var partyMembers = partyService.listAllMembers();

        return new ResponseEntity<>(
                new PartyList(
                        partyMembers.size(),
                        partyMembers),
                HttpStatus.OK
        );
    }

    @PostMapping
    @SneakyThrows
    public ResponseEntity<String> goToParty(@RequestBody PartyMember partyMember) {
        Thread.sleep(5000);
        log.debug(String.format("%s has attended party!", partyMember.toString()));
        return new ResponseEntity<>(
                partyService.goToParty(partyMember),
                HttpStatus.ACCEPTED
        );
    }

}

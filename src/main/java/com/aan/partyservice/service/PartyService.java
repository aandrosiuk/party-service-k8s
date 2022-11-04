package com.aan.partyservice.service;

import com.aan.partyservice.model.PartyMember;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PartyService {

    private static final Set<PartyMember> partyMembers = ConcurrentHashMap.newKeySet();

    public String goToParty(PartyMember partyMember) {
        partyMembers.add(partyMember);
        return String.format(
                "%s %s is partying!",
                partyMember.getFirstName(),
                partyMember.getLastName()
        );
    }

    public List<PartyMember> listAllMembers() {
        return new ArrayList<>(partyMembers);
    }

}

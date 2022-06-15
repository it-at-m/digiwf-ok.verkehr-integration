package io.muenchendigital.digiwf.okverkehr.integration.service;

import io.muenchendigital.digiwf.okverkehr.integration.exception.OkVerkehrIntegrationClientErrorException;
import io.muenchendigital.digiwf.okverkehr.integration.exception.OkVerkehrIntegrationException;
import io.muenchendigital.digiwf.okverkehr.integration.exception.OkVerkehrIntegrationServerErrorException;
import io.muenchendigital.digiwf.okverkehr.integration.gen.model.HalterPersonAnfrage;
import io.muenchendigital.digiwf.okverkehr.integration.gen.model.HalterPersonAntwort;
import io.muenchendigital.digiwf.okverkehr.integration.repository.OkVerkehrHalterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class OkVerkehrHalterService {

    private final OkVerkehrHalterRepository okVerkehrHalterRepository;

    public HalterPersonAntwort getHalter(final String kennzeichen, final String suchzeitpunkt, final String benutzer, final String verfahren, final String anfrageid) throws OkVerkehrIntegrationClientErrorException, OkVerkehrIntegrationServerErrorException, OkVerkehrIntegrationException {
        final HalterPersonAnfrage halterPersonAnfrage = new HalterPersonAnfrage();
        halterPersonAnfrage.setKennzeichen(kennzeichen);
        halterPersonAnfrage.setSuchzeitpunkt(suchzeitpunkt);
        halterPersonAnfrage.setBenutzer(benutzer);
        halterPersonAnfrage.setVerfahren(verfahren);
        halterPersonAnfrage.setAnfrageid(anfrageid);

        return getHalter(halterPersonAnfrage);
    }

    public HalterPersonAntwort getHalter(final HalterPersonAnfrage request) throws OkVerkehrIntegrationClientErrorException, OkVerkehrIntegrationServerErrorException, OkVerkehrIntegrationException {
        return okVerkehrHalterRepository.getHalter(request);
    }
}

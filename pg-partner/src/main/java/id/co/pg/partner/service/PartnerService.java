package id.co.pg.partner.service;

import id.co.pg.partner.dto.PartnerDto;
import id.co.pg.partner.dto.PartnerWebhookDto;
import id.co.pg.partner.entity.Partner;
import id.co.pg.partner.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartnerService {

    @Autowired
    PartnerRepository partnerRepository;

    public PartnerDto findPartnerById(String id) {
        Optional<Partner> partner = partnerRepository.findById(id);
        if (partner.isPresent()) {
            return convertToPartnerDto(partner.get());
        }
        return new PartnerDto();
    }

    public List<PartnerDto> findAllPartner() {
        List<Partner> partnerList = partnerRepository.findAll();
        if (!partnerList.isEmpty()) {
            return partnerList.stream().map(a -> convertToPartnerDto(a)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public PartnerWebhookDto findPartnerWebhookById(String id) {
        Optional<Partner> partner = partnerRepository.findById(id);
        if (partner.isPresent()) {
            return convertToPartnerWebhookDto(partner.get());
        }
        return new PartnerWebhookDto();
    }

    PartnerDto convertToPartnerDto(Partner partner) {
        return PartnerDto.builder()
                .id(partner.getId())
                .name(partner.getName())
                .sellPercentage(partner.getSellPercentage())
                .status(partner.getStatus())
                .build();
    }

    PartnerWebhookDto convertToPartnerWebhookDto(Partner partner) {
        return PartnerWebhookDto.builder()
                .id(partner.getId())
                .webhookUrl(partner.getWebhookUrl())
                .build();
    }
}

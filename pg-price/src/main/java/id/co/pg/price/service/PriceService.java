package id.co.pg.price.service;

import id.co.pg.price.dto.PriceDto;
import id.co.pg.price.entity.Price;
import id.co.pg.price.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PriceService {

    @Autowired
    PriceRepository priceRepository;

    public PriceDto findPriceById(String id) {
        Optional<Price> partner = priceRepository.findByPriceId(id);
        if (partner.isPresent()) {
            return convertToPriceDto(partner.get());
        }
        return new PriceDto();
    }

    public PriceDto findPriceByDate(String date) {
        Optional<Price> partner = priceRepository.findByPriceDate(date);
        if (partner.isPresent()) {
            return convertToPriceDto(partner.get());
        }
        return new PriceDto();
    }

    PriceDto convertToPriceDto(Price price) {
        return PriceDto.builder()
                .id(price.getId())
                .sell(price.getSell())
                .buy(price.getBuy())
                .priceDate(price.getPriceDate())
                .build();
    }

    public List<PriceDto> findAllPrice() {
        List<Price> priceList = priceRepository.findAll();
        if (!priceList.isEmpty()) {
            return priceList.stream().map(a -> convertToPriceDto(a)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}

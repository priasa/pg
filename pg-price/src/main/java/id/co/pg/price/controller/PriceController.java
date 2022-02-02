package id.co.pg.price.controller;

import id.co.pg.price.dto.PriceDto;
import id.co.pg.price.service.PriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/price")
@Api("Price API")
public class PriceController {

    Logger LOGGER = LoggerFactory.getLogger(PriceController.class);

    @Autowired
    PriceService priceService;

    @ApiOperation(value = "Find All Price")
    @GetMapping(
            value = "",
            produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<PriceDto>> findAllPaginated() {
        try {
            List<PriceDto> priceList = priceService.findAllPrice();

            return new ResponseEntity<>(priceList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get By Price Id")
    @GetMapping(
            value = "/findById/{id}",
            produces = "application/json; charset=UTF-8")
    public ResponseEntity<PriceDto> findById(
            @PathVariable(value = "id") String id) {
        try {
            PriceDto priceDto = priceService.findPriceById(id);
            return new ResponseEntity<>(priceDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Find by Price Date")
    @GetMapping(
            value = "/findByDate/{price_date}",
            produces = "application/json; charset=UTF-8")
    public ResponseEntity<PriceDto> findByPriceDate(
            @PathVariable(value = "price_date") String price_date) {
        try {
            PriceDto priceDto = priceService.findPriceByDate(price_date);
            return new ResponseEntity<>(priceDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

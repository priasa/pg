package id.co.pg.partner.controller;


import id.co.pg.partner.dto.PartnerDto;
import id.co.pg.partner.dto.PartnerWebhookDto;
import id.co.pg.partner.service.PartnerService;
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
@RequestMapping("/partner")
@Api("PG Partner API")
public class PartnerController {

    Logger LOGGER = LoggerFactory.getLogger(PartnerController.class);

    @Autowired
    PartnerService partnerService;

    @ApiOperation(value = "Find All Partner")
    @GetMapping(
            value = "/info",
            produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<PartnerDto>> findAllPartner() {
        try {
            List<PartnerDto> partnerList = partnerService.findAllPartner();
            return new ResponseEntity<>(partnerList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get Partner By Id")
    @GetMapping(
            value = "/info/{id}",
            produces = "application/json; charset=UTF-8")
    public ResponseEntity<PartnerDto> findPartnerById(
            @PathVariable(value = "id") String id) {
        try {
            PartnerDto partnerDto = partnerService.findPartnerById(id);
            return new ResponseEntity<>(partnerDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get Partner By Id")
    @GetMapping(
            value = "/webhook/{id}",
            produces = "application/json; charset=UTF-8")
    public ResponseEntity<PartnerWebhookDto> findPartnerWebhookById(
            @PathVariable(value = "id") String id) {
        try {
            PartnerWebhookDto partnerWebhookDto = partnerService.findPartnerWebhookById(id);
            return new ResponseEntity<>(partnerWebhookDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

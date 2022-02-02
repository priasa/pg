package id.co.pg.order.controller;

import id.co.pg.order.dto.OrderDto;
import id.co.pg.order.request.UpdateOrderStatusRequest;
import id.co.pg.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Api("Order API")
public class OrderController {

    Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @ApiOperation(value = "Get By Order Id")
    @GetMapping(
            value = "/findById/{id}",
            produces = "application/json; charset=UTF-8")
    public ResponseEntity<OrderDto> findById(
            @PathVariable(value = "id") String id) {
        try {
            OrderDto orderDto = orderService.findOrderById(id);
            return new ResponseEntity<>(orderDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Update Order Status")
    @PutMapping(
            value = "/updateOrderStatus",
            consumes = "application/json; charset=UTF-8",
            produces = "application/json; charset=UTF-8")
    public ResponseEntity<OrderDto> updateOrderStatus(@RequestBody UpdateOrderStatusRequest updateOrderStatusRequest) {
        try {
            OrderDto orderDto = orderService.updateOrderStatus(updateOrderStatusRequest.getOrderId(),
                    updateOrderStatusRequest.getStatus(),
                    updateOrderStatusRequest.getPartnerId());
            return new ResponseEntity<>(orderDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

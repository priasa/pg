package id.co.pg.order.service;

import id.co.pg.order.dto.OrderDto;
import id.co.pg.order.entity.Order;
import id.co.pg.order.repository.OrderRepository;
import id.co.pg.order.request.AddOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public OrderDto findOrderById(String id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return convertOrderToOrderDto(order.get());
        }
        return new OrderDto();
    }

    @Transactional
    public OrderDto updateOrderStatus(String orderId, Integer status, String partnerId) throws Exception {
        Optional<Order> order = orderRepository.findByIdAndPartnerId(orderId, partnerId);
        if (order.isPresent()) {
            Order currentOrder = order.get();
            currentOrder.setStatus(status);
            currentOrder.setModifiedDate(new Date().getTime()/1000);
            currentOrder.setModifiedBy(partnerId);
            Order savedOrder = orderRepository.saveAndFlush(currentOrder);
            return convertOrderToOrderDto(savedOrder);
        } else {
            throw new Exception("Order not found");
        }

    }

    @Transactional
    public OrderDto addOrder(AddOrderRequest addOrderRequest) {
        Order order = orderRepository.saveAndFlush(convertAddOrderRequestToOrder(addOrderRequest));
        return convertOrderToOrderDto(order);
    }

    OrderDto convertOrderToOrderDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate())
                .amount(order.getAmount())
                .buyPrice(order.getBuyPrice())
                .partnerId(order.getPartnerId())
                .priceDate(order.getPriceDate())
                .partnerName(order.getPartnerName())
                .partnerSellPercentage(order.getPartnerSellPercentage())
                .partnerSellPrice(order.getPartnerSellPrice())
                .priceId(order.getPriceId())
                .sellPrice(order.getSellPrice())
                .status(order.getStatus())
                .weight(order.getWeight())
                .build();
    }

    Order convertAddOrderRequestToOrder(AddOrderRequest addOrderRequest) {
        Long currUnixTimestamp = new Date().getTime()/1000;
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setOrderDate(currUnixTimestamp);
        order.setAmount(addOrderRequest.getAmount());
        order.setBuyPrice(addOrderRequest.getBuyPrice());
        order.setPartnerId(addOrderRequest.getPartnerId());
        order.setPriceDate(addOrderRequest.getPriceDate());
        order.setPartnerName(addOrderRequest.getPartnerName());
        order.setPartnerSellPercentage(addOrderRequest.getPartnerSellPercentage());
        order.setPartnerSellPrice(addOrderRequest.getPartnerSellPrice());
        order.setPriceId(addOrderRequest.getPriceId());
        order.setSellPrice(addOrderRequest.getSellPrice());
        order.setStatus(1);
        order.setWeight(addOrderRequest.getWeight());
        order.setModifiedDate(currUnixTimestamp);
        order.setModifiedBy(addOrderRequest.getPartnerId());
        order.setCreatedDate(currUnixTimestamp);

        return order;
    }
}

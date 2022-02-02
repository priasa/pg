package id.co.pg.order.service;

import id.co.pg.order.dto.OrderDto;
import id.co.pg.order.entity.Order;
import id.co.pg.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public OrderDto findOrderById(String id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return convertToOrderDto(order.get());
        }
        return new OrderDto();
    }

    public OrderDto updateOrderStatus(String orderId, Integer status, String partnerId) throws Exception {
        Optional<Order> order = orderRepository.findByIdAndPartnerId(orderId, partnerId);
        if (order.isPresent()) {
            Order currentOrder = order.get();
            currentOrder.setStatus(status);
            currentOrder.setModifiedDate(new Date().getTime()/1000);
            currentOrder.setModifiedBy(partnerId);
            Order savedOrder = orderRepository.saveAndFlush(currentOrder);
            return convertToOrderDto(savedOrder);
        } else {
            throw new Exception("Order not found");
        }

    }

    OrderDto convertToOrderDto(Order order) {
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

}

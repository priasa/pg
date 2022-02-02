package id.co.pg.order.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private String id;
    private BigDecimal amount;
    private Double weight;
    private Long orderDate;
    private Integer status;
    private String priceId;
    private String priceDate;
    private Long sellPrice;
    private Long buyPrice;
    private Long partnerSellPrice;
    private String partnerId;
    private String partnerName;
    private Double partnerSellPercentage;
}

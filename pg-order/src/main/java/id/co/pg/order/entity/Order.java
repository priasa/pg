package id.co.pg.order.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "tbl_order")
public class Order {
    @Id
    @Column(name = "order_id")
    private String id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(precision = 10, scale = 2, name = "weight")
    private Double weight;

    @Column(name = "order_date")
    private Long orderDate;

    @Column(name = "order_status")
    private Integer status;

    @Column(name = "price_id")
    private String priceId;

    @Column(name = "price_date")
    private String priceDate;

    @Column(name = "sell_price")
    private Long sellPrice;

    @Column(name = "buy_price")
    private Long buyPrice;

    @Column(name = "partner_sell_price")
    private Long partnerSellPrice;

    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "partner_name")
    private String partnerName;

    @Column(precision = 10, scale = 2, name = "partner_sell_percentage")
    private Double partnerSellPercentage;

    @Column(name = "created_date")
    private Long createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_date")
    private Long modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;
}

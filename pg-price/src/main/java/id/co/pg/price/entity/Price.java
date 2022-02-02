package id.co.pg.price.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tbl_price")
public class Price {
    @Id
    @Column(name = "price_id")
    private String id;

    @Column(precision = 10, scale = 2, name = "sell_price")
    private Double sell;

    @Column(precision = 10, scale = 2, name = "buy_price")
    private Double buy;

    @Column(name = "price_date", unique = true)
    private String priceDate;

    @Column(name = "created_date")
    private Long createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_date")
    private Long modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;
}

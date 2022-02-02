package id.co.pg.partner.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tbl_partner")
public class Partner {
    @Id
    @Column(name = "partner_id")
    private String id;

    @Column(length = 32, name = "partner_name")
    private String name;

    @Column(precision=10, scale=2, name = "partner_sell_percentage")
    private Double sellPercentage;

    @Column(name = "partner_status")
    private Integer status;

    @Column(name = "webhook_url")
    private String webhookUrl;

    @Column(name = "created_date")
    private Long createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_date")
    private Long modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;

}

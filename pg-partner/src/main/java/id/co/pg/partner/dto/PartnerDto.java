package id.co.pg.partner.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerDto {

    private String id;
    private String name;
    private Double sellPercentage;
    private Integer status;
}

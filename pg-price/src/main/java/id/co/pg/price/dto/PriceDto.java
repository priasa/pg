package id.co.pg.price.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto {

    private String id;
    private Double sell;
    private Double buy;
    private String priceDate;
}

package id.co.pg.order.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderStatusRequest {
    private String orderId;
    private Integer status;
    private String partnerId;
}

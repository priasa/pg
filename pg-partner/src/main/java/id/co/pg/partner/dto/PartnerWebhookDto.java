package id.co.pg.partner.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerWebhookDto {

    private String id;
    private String webhookUrl;
}

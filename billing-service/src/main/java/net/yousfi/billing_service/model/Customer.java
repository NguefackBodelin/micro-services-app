package net.yousfi.billing_service.model;

import lombok.*;

@Getter
@Setter
@Builder @NoArgsConstructor @AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String email;
}

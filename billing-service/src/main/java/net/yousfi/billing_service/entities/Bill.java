package net.yousfi.billing_service.entities;

import jakarta.persistence.*;
import lombok.*;
import net.yousfi.billing_service.model.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private Long customerId;

    @OneToMany(mappedBy="bill")
    private List<ProductItem> productItems=new ArrayList<>();

    @Transient
    private Customer customer;
}

package net.yousfi.inventory_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class Product {
    @Id
    private String Id;
    private String name;
    private double price;
    private int quantity;

}

package org.sami.inventoryservice.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Getter
@Setter @AllArgsConstructor @NoArgsConstructor @Builder

public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}
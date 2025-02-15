package org.sami.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.sami.billingservice.models.Customer;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;

    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems = new ArrayList<>();
    private long customerID;

    @Transient
    private Customer customer;
}
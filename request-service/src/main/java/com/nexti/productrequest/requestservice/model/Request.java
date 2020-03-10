package com.nexti.productrequest.requestservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "request")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;
    @ManyToOne(optional = false)
    @JoinColumn (name = "id_cliente")
    private Client client;
    @Column(name = "preco_total")
    private Double totalPrice;
    @Column(name = "data_pedido")
    private LocalDateTime requestDate;
    @OneToMany
    @JoinColumn(name="id_pedido", referencedColumnName = "id_pedido")
    private Set<Product> products;
}

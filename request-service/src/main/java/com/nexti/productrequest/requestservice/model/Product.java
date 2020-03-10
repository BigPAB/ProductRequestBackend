package com.nexti.productrequest.requestservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @Column(name = "id_produto")
    private Integer id;
    @Column(name = "sku")
    private String sku;
    @Column(name = "nome")
    private String name;
    @Column(name = "descricao")
    private String description;
    @Column(name = "preco")
    private Double price;
    @Column(name = "quantidade")
    private Integer quantity;
}

package com.example.homework7and8p1;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String goodName;
    private String company;
    private Double price;

    public Goods(){}

    public Goods(String goodName, Double price, String company) {
        this.goodName = goodName;
        this.company = company;
        this.price = price;
    }

    @ManyToMany(mappedBy = "goods")
    private Set<Orders> orders = new HashSet<>();

    public void addOrders(Orders order) {
        orders.add(order);
        order.getGoods().add(this);
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", productName='" + goodName + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                '}';
    }
}

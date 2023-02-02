package com.example.homework6;

import javax.persistence.*;

@Entity
@Table(name = "housings")
public class Housing {
    @Id
    @GeneratedValue
    @Column(name = "myid")
    private int id;

    private String area;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private double space;
    @Column(nullable = false)
    private int room;
    private int price;

    public Housing() {
    }

    public Housing(String area, String address, double space, int room, int price) {
        this.area = area;
        this.address = address;
        this.space = space;
        this.room = room;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSpace() {
        return space;
    }

    public void setSpace(double space) {
        this.space = space;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Housing{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", space=" + space +
                ", room=" + room +
                ", price=" + price +
                '}';
    }
}

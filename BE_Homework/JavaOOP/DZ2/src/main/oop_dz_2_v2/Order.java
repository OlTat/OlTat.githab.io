package oop_dz_2_v2;

public class Order {
    final String type; // тип заказа (срочный или предварительный) //

    public Order(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        if (type.equals("Срочный")) {
            return "Срочный заказ.";
        }
        return "Предварительный заказ.";
    }
}

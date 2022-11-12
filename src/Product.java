import java.util.*;

public class Product {
    private String name;
    private double price;
    private double weight;
    private boolean bought=false;

    public Product(String name, double price, double weight) {
        if (!name.isEmpty() && !name.isBlank() && name != null) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Заполните полностью карточку товара");
        }
        if (price != 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Заполните полностью карточку товара");
        }
        if (weight != 0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Заполните полностью карточку товара");
        }
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " куплен: " + isBought()+ " вес: "+ getWeight() + " кг";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (Double.compare(product.price, price) != 0) return false;
        if (Double.compare(product.weight, weight) != 0) return false;
        if (bought != product.bought) return false;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (bought ? 1 : 0);
        return result;
    }
}

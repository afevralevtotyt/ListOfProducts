import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Recipe {


    private HashMap<Product, Integer> productsList =new HashMap<>();
    private String name;
    private double amount;

    public Recipe( String name, Product product, int quantity) {
        this.name = name;
        addProductToList(product, quantity);
    }

    public void addProductToList(Product product, int quantity) {
        productsList.put(product, Math.max(quantity, 1));
    }
    public String getName() {
        return name;
    }


    public HashMap<Product, Integer> getProductsList() {
        return productsList;
    }

    public double getAmount() {
        for (Product key: productsList.keySet()
             ) { amount+= productsList.get(key)*key.getPrice();
        } return amount;
    }

    @Override
    public String toString() {
        return  "Рецепт "+ name + " состоит из: " + productsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;

        Recipe recipe = (Recipe) o;

        return name.equals(recipe.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

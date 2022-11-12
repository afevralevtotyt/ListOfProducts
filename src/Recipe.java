import java.util.HashSet;
import java.util.Set;

public class Recipe {


    private Set<Product> productsList =new HashSet<>();
    private String name;
    private double amount;

    public Recipe( String name, Product...product) {
        for (Product x: product
             ) {
            productsList.add(x);
        }
        this.name = name;
        if (!productsList.isEmpty()) {
            for (Product x: productsList
                 ) {
                this.amount+=x.getPrice();
            }
        }
    }


    public void addProductToList(Product product) {

        if (!productsList.contains(product)) {
            productsList.add(product);
        } else {
            throw new IllegalArgumentException("Такой продукт уже есть в рецепте");
        }
    }
    public String getName() {
        return name;
    }


    public Set<Product> getProductsList() {
        return productsList;
    }

    public double getAmount() {
        return amount;
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

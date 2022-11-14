import javax.management.ObjectName;
import java.lang.reflect.ParameterizedType;
import java.util.*;

public class Main {
    public static void addProduct(List list, Product... product) {
        for (Product x : product)
            if (list.contains(x)) {
                throw new IllegalArgumentException("Продукт уже есть в списке");
            } else {
                list.add(x);
                x.setBought(false);
            }
    }

    public static void addProduct(Set set, Recipe... recipes) {
        for (Recipe x : recipes)
            if (set.contains(x)) {
                throw new IllegalArgumentException("Рецепт уже есть в списке");
            } else {
                set.add(x);
            }
    }

    public static void removeProduct(Product product, List<Product> list) {
        if (list.contains(product)) {
            list.remove(product);
        } else {
            System.out.println("Данного продукта нет в списке");
        }
    }

        public static void removeProduct(String title, List<Product> list){
        Iterator<Product> iter = list.iterator();
        while (iter.hasNext()){
            if(title.equals(iter.next().getName())){
                iter.remove();
            }

        }}

    public static void markAsBought(String title, List<Product> list) {
        for (Product product : list
        ) {
            if (product.getName().equals(title)) {
                product.setBought(true);
            }
        }}




    public static void main(String[] args) {
        Set<Recipe> myCollection = new HashSet<>();

        List<Product> list = new ArrayList<>();
        Product bananas = new Product("Бананы", 100, 2);
        Product milk = new Product("Молоко", 90, 2);
        Product eggs = new Product("Яйца", 100, 2);
        Product flour = new Product("Мука", 200, 3);
        addProduct(list, bananas, milk);
        System.out.println(list);
        markAsBought("Бананы", list);
        removeProduct("Бананы", list);
        System.out.println(list);
        Recipe bananaShake = new Recipe("Банановый шейк", bananas, 1);
        bananaShake.addProductToList(milk, 2);

       /* Recipe pancakes = new Recipe("Блинчики", milk, eggs, flour);
        Recipe cake =  new Recipe("Кекс", milk, eggs, flour);
*/
        addProduct(myCollection, bananaShake);
        System.out.println(bananaShake.getAmount());






//        Set<Integer> setOfInts = new HashSet<>();
//
//        Random random = new Random();
//        for (int i = 0; i < 20; i++) {
//            setOfInts.add(random.nextInt(1001));
//        }
//
/*
        System.out.println(setOfInts);
         Iterator<Integer> iterator = setOfInts.iterator();
         while (iterator.hasNext()){
             if (iterator.next()%2==1){
                 iterator.remove();
             }
         }

        System.out.println(setOfInts);*/


         // Или так
//        for (Object x: setOfInts.toArray())
//              { if ((int)x%2==1) {
//                  setOfInts.remove(x)
//              }
//
//        } или так
      /*  setOfInts.removeIf(i->(i%2==1));*/


}}
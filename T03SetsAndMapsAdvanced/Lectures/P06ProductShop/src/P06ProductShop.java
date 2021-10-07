import java.util.*;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Product>> storesInSofia = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String[] storeData = input.split(",\\s+");
            String storeName = storeData[0];
            String productName = storeData[1];
            double productPrice = Double.parseDouble(storeData[2]);

            storesInSofia.putIfAbsent(storeName, new ArrayList<>());
            List<Product> currentListWithProducts = storesInSofia.get(storeName);
            Product product = new Product(productName, productPrice);
            currentListWithProducts.add(product);

            input = scanner.nextLine();
        }

        storesInSofia.forEach((key, value) -> {
            System.out.printf("%s->%n", key);
            value.forEach(System.out::println);
        });
    }

    private static class Product {
        String name;
        double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return String.format("Product: %s, Price: %.1f", this.name, this.price);
        }
    }
}

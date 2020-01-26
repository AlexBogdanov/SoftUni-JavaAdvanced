import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class ProductShop {

    public static void main (String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> shops = createMap(scanner);

        StringBuilder sb = new StringBuilder();
        formOutput(sb, shops);

        System.out.println(sb);

    }

    private static Map<String, Map<String, Double>> createMap (Scanner scanner) {
        Map<String, Map<String, Double>> shops = new TreeMap<>();
        String input = scanner.nextLine();

        while (!"Revision".equals(input)) {
            String[] tokens = input.split(", +");
            String shop = tokens[0].trim();
            String product = tokens[1].trim();
            double price = Double.parseDouble(tokens[2].trim());

            if (shops.containsKey(shop)) {
                Map<String, Double> products = shops.get(shop);
                products.put(product, price);
                shops.put(shop, products);
            } else {
                Map<String, Double> products = new LinkedHashMap<>();
                products.put(product, price);
                shops.put(shop, products);
            }

            input = scanner.nextLine();
        }

        return shops;
    }

    private static void formOutput (StringBuilder sb, Map<String, Map<String, Double>> shops) {
        for (String shop : shops.keySet()) {
            sb.append(shop + "->");
            sb.append(System.lineSeparator());

            Map<String, Double> products = shops.get(shop);

            for (String product : products.keySet()) {
                sb.append(String.format("Product: %s, Price: %.1f", product, products.get(product)));
                sb.append(System.lineSeparator());
            }
        }
    }

}

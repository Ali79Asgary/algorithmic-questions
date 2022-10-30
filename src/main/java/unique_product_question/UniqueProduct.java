package unique_product_question;

import java.util.HashMap;

public class UniqueProduct {
    public static String firstUniqueProduct(String[] products) {
        HashMap<String, Integer> counts = new HashMap<String, Integer>();

        for (int i = 0; i < products.length; i++) {
            if (!counts.containsKey(products[i]))
                counts.put(products[i], 1);
            else
                counts.put(products[i], counts.get(products[i]) + 1);
        }

        for (int i = 0; i < products.length; i++)
            if (counts.get(products[i]) == 1)
                return products[i];

        return null;
    }
}

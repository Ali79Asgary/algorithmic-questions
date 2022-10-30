package shelf_question;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private List<String> items = new ArrayList<>();

    public void put(String item) {
        if (item != null && !item.isEmpty()) {
            this.items.add(item);
        }
    }

    public boolean take(String item) {
        if (items.contains(item)) {
            items.remove(item);
            return true;
        }

        return false;
    }
}

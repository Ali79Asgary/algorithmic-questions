package veterinarian_question;

import java.util.*;

public class Veterinarian {
    private Queue<String> pets = new LinkedList<String>();

    public void accept(String petName) {
        this.pets.add(petName);
    }

    public String heal() {
        return this.pets.poll();
    }
}

package veterinarian_question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class VeterinarianTest {
    @Test
    public void heal_exampleCase_returnPetsName() {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.accept("Barkley");
        veterinarian.accept("Mittens");
        String firstPet = veterinarian.heal();
        String secondPet = veterinarian.heal();
        Assertions.assertEquals(firstPet, "Barkley");
        Assertions.assertEquals(secondPet, "Mittens");
    }

    @Test
    public void heal_smallFlowOfPatients_returnPetsName() {
        String[] petsArray = createArray(10);
        Veterinarian veterinarian = new Veterinarian();
        for (String pet : petsArray) {
            veterinarian.accept(pet);
        }
        for (int i = 1; i < petsArray.length; i++) {
            veterinarian.heal();
        }
        Assertions.assertEquals(veterinarian.heal(), "10");
    }

    @Test
    public void heal_manyOfPatients_returnPetsName() {
        String[] petsArray = createArray(1000);
        Veterinarian veterinarian = new Veterinarian();
        for (String pet : petsArray) {
            veterinarian.accept(pet);
        }
        for (int i = 1; i < petsArray.length; i++) {
            veterinarian.heal();
        }
        Assertions.assertEquals(veterinarian.heal(), "1000");
    }

    private String[] createArray(int arraySize) {
        int[] intArray = IntStream.rangeClosed(1, arraySize).toArray();
        String[] strArray = new String[arraySize];
        int i = 0;
        for (int num : intArray) {
            strArray[i] = String.valueOf(num);
            i++;
        }
        return strArray;
    }
}

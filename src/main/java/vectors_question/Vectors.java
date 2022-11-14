package vectors_question;

public class Vectors {
    public static int[] findShortest(int[][] vectors) {
        int[] shortest = null;
        double shortestValue = Double.MAX_VALUE;

        for (int[] vector : vectors) {
            double value = Math.sqrt(Math.pow(vector[0], 2) + Math.pow(vector[1], 2) + Math.pow(vector[2], 2));
            if (value < shortestValue) {
                shortest = vector;
                shortestValue = value;
            }
        }
        return shortest;
    }
}

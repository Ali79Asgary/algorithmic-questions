import java.util.Scanner;
import java.util.Stack;

public class WaterQuestion {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int stock = scanner.nextInt();
        int sum = 0, temp;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(stock);
        for (int i = 1; i < n; i++) {
            temp = scanner.nextInt();
            stack.push(temp);
            if (temp >= stock) {
                stock = temp;
            } else {
                sum += (stock - temp);
            }
        }
        int last = stack.lastElement();
        if (stack.lastElement() < stock) {
            while (stack.lastElement() != stock) {
                if (stack.lastElement() > last) {
                    sum = sum - (stock - stack.lastElement());
                    last = stack.lastElement();
                } else {
                    sum = sum - (stock - last);
                }
                stack.pop();
            }
        }
        System.out.println(sum);
    }
}

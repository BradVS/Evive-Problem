import java.util.Scanner;

public class Problem{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your order: ");
        Menu meal = Menu.getMeal(in.nextLine());
        System.out.println(meal.assembleOrder());
        in.close();
    }
}
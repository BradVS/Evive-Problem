import java.util.Scanner;

public class Problem{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your order: ");
        try{
            Menu meal = Menu.getMeal(in.nextLine());
            System.out.println(meal.assembleOrder());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        in.close();
    }
}
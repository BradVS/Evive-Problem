public class Test {
    public static void main(String[] args) {
        Menu din = Menu.getMeal("Dinner 1,2,3,4");
        System.out.println(din.assembleOrder());
        System.out.println(din.hasAllItems());
        System.out.println(din.hasValidQuantities());

        din = Menu.getMeal("Dinner 1,2,3");
        System.out.println(din.assembleOrder());
        System.out.println(din.hasAllItems());
        // System.out.println(din.hasValidQuantities());
        System.out.println(din.getMissingParts().toString());

        din = Menu.getMeal("Dinner 1,2,4");
        System.out.println(din.assembleOrder());
        System.out.println(din.hasAllItems());
        System.out.println(din.hasValidQuantities());

        din = Menu.getMeal("Breakfast 1,2,3,3,3,3,3,3");
        System.out.println(din.assembleOrder());
        System.out.println(din.hasAllItems());
        System.out.println(din.hasValidQuantities());

        din = Menu.getMeal("Lunch 1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2");
        System.out.println(din.assembleOrder());
        System.out.println(din.hasAllItems());
        System.out.println(din.hasValidQuantities());

        din = Menu.getMeal("Lunch");
        System.out.println(din.assembleOrder());
        System.out.println(din.hasAllItems());

        din = Menu.getMeal("Breakfast 1,2");
        System.out.println(din.assembleOrder());
        System.out.println(din.hasAllItems());

        din = Menu.getMeal("Lunch 1,2");
        System.out.println(din.assembleOrder());
        System.out.println(din.hasAllItems());

        din = Menu.getMeal("Dinner 1,2");
        System.out.println(din.assembleOrder());
        System.out.println(din.hasAllItems());
    }
}

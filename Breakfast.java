import java.util.ArrayList;
import java.util.HashMap;

public class Breakfast implements Menu {
    private final String[] menuItems = {"Eggs", "Toast", "Coffee"};
    private final String[] mealParts = {"Main", "Side", "Drink"};
    private int[] csvOrder;
    private HashMap<Integer, Integer> orderQuantities = new HashMap<>();

    Breakfast(String input){
        String[] inputSplit = input.split(" ");
        if(inputSplit.length != 2){
            // no items ordered
            csvOrder = new int[0];
        }else{
            String[] csvOrderStr = inputSplit[1].split(",");
            csvOrder = new int[csvOrderStr.length];
            for (int i = 0; i < csvOrderStr.length; i++) {
                csvOrder[i] = Integer.valueOf(csvOrderStr[i]);
            }
        }
        
    }

    @Override
    public String assembleOrder() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < csvOrder.length; i++) {
            if(orderQuantities.containsKey(csvOrder[i])){
                orderQuantities.replace(csvOrder[i], orderQuantities.get(csvOrder[i]) + 1);
            }else{
                orderQuantities.put(csvOrder[i], 1);
            }
        }
        if(hasAllItems()){
            if(hasValidQuantities()){
                output.append(getMainDish() + ", ");
                output.append(getSideDish() + ", ");
                output.append(getDrink());
            }else{
                ArrayList<Integer> invalidQuantities = getInvalidQuantities();
                output.append("Unable to Process:");
                for (Integer integer : invalidQuantities) {
                    output.append(" ");
                    output.append(menuItems[integer-1]);
                    output.append(" cannot be ordered more than once,");
                }
                output.deleteCharAt(output.length()-1);
            }
        }else{
            ArrayList<Integer> missingParts = getMissingParts();
            output.append("Unable to Process:");
            for (Integer integer : missingParts) {
                output.append(" ");
                output.append(mealParts[integer-1]);
                output.append(" is missing,");
            }
            output.deleteCharAt(output.length()-1);
        }
        return output.toString();
    }

    @Override
    public ArrayList<Integer> getMissingParts() {
        ArrayList<Integer> missingParts = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            if(!orderQuantities.containsKey(i)){
                missingParts.add(i);
            }
        }
        return missingParts;
    }

    @Override
    public boolean hasAllItems() {
        if(!orderQuantities.containsKey(1) || !orderQuantities.containsKey(2)){
            return false;
        }
        return true;
    }

    @Override
    public boolean hasValidQuantities() {
        if(orderQuantities.get(1) != 1 || orderQuantities.get(2) != 1){
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Integer> getInvalidQuantities() {
        ArrayList<Integer> badParts = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            if(orderQuantities.get(i) != 1){
                badParts.add(i);
            }
        }
        return badParts;
    }

    @Override
    public String getMainDish() {
        return menuItems[0];
    }

    @Override
    public String getSideDish() {
        return menuItems[1];
    }

    @Override
    public String getDrink() {
        String drinks = "Water";
        if(orderQuantities.containsKey(3)){
            drinks = menuItems[2];
            if(orderQuantities.get(3) > 1){
                drinks += "(" + orderQuantities.get(3) + ")";
            }
        }
        return drinks;
    }
    
}

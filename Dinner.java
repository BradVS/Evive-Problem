import java.util.ArrayList;
import java.util.HashMap;

public class Dinner implements Menu {
    private final String[] menuItems = {"Steak", "Potatoes", "Wine", "Cake"};
    private final String[] mealParts = {"Main", "Side", "Drink", "Dessert"};
    private int[] csvOrder;
    private HashMap<Integer, Integer> orderQuantities = new HashMap<>();
 
    Dinner(String input){
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
                output.append(getDrink() + ", ");
                output.append(getDessert());
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

    private String getDessert() {
        return menuItems[3];
    }

    @Override
    public ArrayList<Integer> getMissingParts() {
        ArrayList<Integer> missingParts = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            if(!orderQuantities.containsKey(i)){
                missingParts.add(i);
            }
        }
        if(!orderQuantities.containsKey(4)){
            missingParts.add(4);
        }
        return missingParts;
    }

    @Override
    public boolean hasAllItems() {
        if(!orderQuantities.containsKey(1) || !orderQuantities.containsKey(2) || !orderQuantities.containsKey(4)){
            return false;
        }
        return true;
    }

    @Override
    public boolean hasValidQuantities() {
        if(orderQuantities.get(1) != 1 || orderQuantities.get(2) != 1 || orderQuantities.get(4) != 1){
            return false;
        }
        if(orderQuantities.containsKey(3)){
            if(orderQuantities.get(3) != 1){
                return false;
            }
        }
        return true;
    }

    @Override
    public ArrayList<Integer> getInvalidQuantities() {
        ArrayList<Integer> badParts = new ArrayList<>();
        if(orderQuantities.get(1) != 1){
            badParts.add(1);
        }
        if(orderQuantities.get(2) != 1){
            badParts.add(2);
        }
        if(orderQuantities.containsKey(3)){
            if(orderQuantities.get(3) != 1){
                badParts.add(3);
            }
        }
        if(orderQuantities.get(4) != 1){
            badParts.add(4);
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
        String drink = "";
        if(orderQuantities.containsKey(3)){
            drink = menuItems[2] + ", ";
        }
        drink += "Water";
        return drink;
    }

}

import java.util.ArrayList;

public interface Menu {
    /**
     * Takes in the order numbers and assembles the order based on the input.
     * @param input
     * @return String of the order
     */
    String assembleOrder();
    /**
     * Checks to see if the order numbers are a valid combo for the meal being ordered.
     * @param input
     * @return true if valid, false otherwise
     */
    boolean hasAllItems();
    /**
     * Checks if the quantities of each item ordered are valid
     * @return true if valid, false otherwise
     */
    boolean hasValidQuantities();
    /**
     * Returns an array of the missing parts of the meal
     * @return int[] of missing meal parts
     */
    ArrayList<Integer> getMissingParts();
    ArrayList<Integer> getInvalidQuantities();
    String getMainDish();
    String getSideDish();
    String getDrink();

    /**
     * Returns an object that corresponds with the meal that is being ordered for.
     * @param input
     * @return Menu Object of type Breakfast, Lunch, or Dinner
     * @throws IllegalArgumentException thrown if the meal type is not valid
     */
    public static Menu getMeal(String input) throws IllegalArgumentException{
        String[] inSplit = input.split(" ");
        switch(inSplit[0]){
            case "Breakfast":
                return new Breakfast(input);
            case "Lunch":
                return new Lunch(input);
            case "Dinner":
                return new Dinner(input);
            default:
                throw new IllegalArgumentException("Not a valid meal type.");
        }
    }
}

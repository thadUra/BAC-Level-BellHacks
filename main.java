public class main {
    public static void main (String[] a) {
        //GUI.initialize();
        // Test initialization
        Alcohol user = new Alcohol("me", "male", 175, 155);
        System.out.println(user.getName());
        // Main screen 
        // Initilializing drink categories 
        Drink beer = new Drink(7, "Beer");
        Drink wine = new Drink(14, "Wine");
        Drink liquor = new Drink(40, "Hard Liquor");
        System.out.println(wine.getPercent());
        Timer time = new Timer();
        time.addDrinks(liquor, 1.5);
        System.out.println(time.calculateBAC(user));
    }
}


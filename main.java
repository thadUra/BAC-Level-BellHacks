public class main {
    public static void main (String[] a) {
        //GUI.initialize();
        // Test initialization
        Alcohol user = new Alcohol("me", "male", 175, 155);
        System.out.println(user.getName());
        // Main screen 
        // Initilializing drink categories 
        Drink beer = new Drink(5, "Beer");
        Drink wine = new Drink(12, "Wine");
        Drink liquor = new Drink(40, "Hard Liquor");
        Timer time = new Timer();
        time.addDrinks(beer, 48);
        System.out.println(time.calculateBAC(user));
        try {
			System.out.println(time.calculateTime());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}


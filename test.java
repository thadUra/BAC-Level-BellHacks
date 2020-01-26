public class test {
    public static void main (String[] a) {
        GUI.initialize();
        // Test initialization
        Alcohol user = GUI.currentProfile;
        
        System.out.println(user.getName());
        // Main screen 
        // Initilializing drink categories 
        Drink beer = new Drink(5, "Beer");
        Drink wine = new Drink(12, "Wine");
        Drink liquor = new Drink(40, "Hard Liquor");
        Timers time = new Timers();
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
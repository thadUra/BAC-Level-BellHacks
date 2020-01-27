public class test {
    public static Timers time = new Timers();
    public static final  Drink beer = new Drink(5, "Beer");
    public static final Drink wine = new Drink(12, "Wine");
    public static final Drink liquor = new Drink(40, "Hard Liquor");


    public static void main (String[] a) {
        GUI.initialize();
        // Test initialization
        Alcohol user = GUI.currentProfile;
        
        System.out.println(user.getName());
        // Main screen 
        // Initilializing drink categories 
       
        
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
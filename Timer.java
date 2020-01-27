import java.util.concurrent.TimeUnit;

public class Timer {
    private double gramsAlch; 
    private double bac;
 
    //private ArrayList<Drinks> drink;
    public Timer() {

    }

    public void addDrinks( Drink drink, double ounces ) {
        double percentAlch = drink.getPercent();
        double alchAmt = percentAlch * ounces;
        gramsAlch = alchAmt * 28.3495;


    }
    
    public double calculateBAC(Alcohol a) {
        
        //Transfer weight from lb to kg
        double weight = a.getWeight() * 0.453592;
        
        //Transfer height from cm to m
        double height = a.getHeight() * .01;
       
        //Calculate alcohol distribution based on male or female (these are constants)
        double malVolDist = 1.0178 - ((.012127 * weight) / (Math.pow(height, 2)));
        double femVolDist = .8736 - ((.012127 * weight) / (Math.pow(height, 2)));
        if (a.getGender().toLowerCase().equals("male")) {
            bac += (gramsAlch / ((weight *1000) * malVolDist)) * 100;
        }
        else {
            bac += (gramsAlch / ((weight *1000) * femVolDist)) * 100;
        }
        return bac;
    }

    public int calculateTime() throws InterruptedException {
        //Percent of BAC broken down per second
        double breakDown = .015 / 3600;
        int timeTilSafe = (int)(((bac - .08)/ .015) * 3600);
        for(int i = timeTilSafe; i > 0; i--) {
            System.out.println("\n" + "There are " + i + " seconds left");
            try {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            bac -= breakDown;
            System.out.println("The current BAC is ");
            System.out.format("%.4f", bac);
        }
        return 0;
    }
}
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Timer {
    private double gramsAlch; 
    private double bac;

    public static ActionListener beerpressed = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Add code to 
        }
    };
 
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
        double malVolDist = 1.0178 - ((.012127 * weight) / (Math. pow(height, 2)));
        double femVolDist = .8736 - ((.012127 * weight) / (Math. pow(height, 2)));
        if (a.getGender().toLowerCase().equals("male")) {
            bac += (gramsAlch / ((weight *1000) * malVolDist)) * 100;
        }
        else {
            bac += (gramsAlch / ((weight *1000) * femVolDist)) * 100;
        }
        return bac;
    }

    public double calculateTime() {
        //Percent of BAC broken down per second
        double breakDown = .015 / 3600;
        double timeTilSafe = ((bac - .08)/ .015) * 3600;
        return bac;
    }
    /**public static Thread counddown = new Thread(new Runnable() {
    public static safeTime = 0;
		@Override
		public void run() {
            safeTime = calculateTime();
            while (true) {
                safetime--;
                try {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
			
		}
    });*/
}
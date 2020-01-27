import java.util.concurrent.TimeUnit;

public class Timers {
    private double gramsAlch; 
    private double bac;
    private int timeTilSafe;
 
    //private ArrayList<Drinks> drink;
    public Timers() {

    }

    public String militaryTime(int time, double bac2) {
        String t = bac2 +"";
        double bac3 = Double.parseDouble((t.substring(0,7)));
        int h = time / 3600;
        time = time%3600;
        int m = time / 60;
        time = time%60;
        int s = time;
        if (h < 10) {
            if (m < 10) {
                if (s<10) {
                    return "0" + h + ":0" + m + ":0" + s + "        Current BAC = " + bac3;
                }
                return "0" + h + ":0" + m + ":" + s + "        Current BAC = " + bac3;
            }
            else if (s<10) {
                return "0" + h + ":" + m + ":0" + s + "        Current BAC = " + bac3;
            }
            return "0" + h + ":" + m + ":" + s + "        Current BAC = " + bac3;
        }
        else if (m<10) {
            if (s<10) {
                return h + ":0" + m + ":0" + s + "        Current BAC = " + bac3; 
            }
            return h + ":0" + m + ":" + s + "        Current BAC = " + bac3;
        }
        else if(s<10) {
            return h + ":" + m + ":0" + s + "        Current BAC = " + bac3;
        }
        else {
            return "Time in H:M:S = " + h + ":" + m + ":" + s + "        Current BAC = " + bac3;
        }
    }

    public void addDrinks( Drink drink, double ounces ) {
        double percentAlch = drink.getPercent();
        double alchAmt = percentAlch * ounces;
        gramsAlch = alchAmt * 28.3495;


    }
    
    public void calculateBAC(Alcohol a) {
        
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
    }

    public int calculateTime() throws InterruptedException {
        //Percent of BAC broken down per second
        double breakDown = .015 / 3600;
        timeTilSafe = (int)(((bac - .08)/ .015) * 3600);
        if (timeTilSafe <= 0) {
            return 0;
        }
        for(int i = timeTilSafe; i > 0; i--) {
            timeTilSafe = i;
            GUI.timerArea.setText(militaryTime(i, (float) bac));
            
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
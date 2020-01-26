public class main {
    public static void main (String[] a) {
        GUI.initialize();
        // Test initialization
        Alcohol user = new Alcohol("me", "male", 175, 155);
        System.out.println(user.getName());
        // Main screen 
        // Keyword search box
    }
}

class Alcohol {
    // Instance variables
    private String name;
    private String gender;
    private double height;
    private int weight;

    public Alcohol( String name, String gender, double height, int weight ) {
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public double getHeight() {
        return height;
    }
    public int getWeight() {
        return weight;
    }
}

class Timer {
    private String alcohol;
    private double percent;
    private double gramsAlch; 
    private double BAC;
    
    public Timer() {

    }

    public void calculateGrams( double drinks ) {
        gramsAlch = drinks * 14;

    }
    
    public void calculateBAC(Alcohol a) {
        //Transfer weight from lb to kg
        double weight = a.getWeight() * 0.453592;
        //Transfer height from cm to m
        double height = a.getHeight() * .01;
        //Calculate alcohol distribution based on male or female
        double malVolDist = 1.0178 - ((.012127 * weight) / (Math. pow(height, 2)));
        double femVolDist = .8736 - ((.012127 * weight) / (Math. pow(height, 2)));
        if (a.getGender().toLowerCase().equals("male")) {
            BAC = (gramsAlch / (weight * malVolDist)) * 100;
        }
        else {
            BAC = (gramsAlch / (weight * femVolDist)) * 100;
        }
    }

    public int calculateTime(Alcohol a) {
        //Percent of BAC broken down per second
        double breakDown = 1.5 / 3600;
        double timeTilSafe = (BAC - 8)/ 1.5;
        
    }


}
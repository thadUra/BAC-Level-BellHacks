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
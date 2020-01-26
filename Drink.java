class Drink {
    private double percent;
    private String category;

    public Drink( double percent, String category ) {
        this.percent = percent;
        this.category = category;
    }

    public double getPercent() {
        return percent/100;
    }
    public String getCategory() {
        return category;
    }
}
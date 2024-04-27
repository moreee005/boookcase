package BookCase;


public class Publisher {
    private String name;
    private String country;
    private double productionCost;

    public Publisher(String name, String country, double productionCost) {
        this.name = name;
        this.country = country;
        this.productionCost = productionCost;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getProductionCost() {
        return productionCost;
    }
}

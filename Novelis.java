package BookCase;

import java.util.ArrayList;
import java.util.List;

class Novelis {
    private String FirstName;
    private String LastName;
    private String country;
    private int age;
    private boolean serial;
    private String rating;
    

    // Constructor
    public Novelis(String firstname, String lastname, String country, int age, boolean serial, String rating) {
        this.FirstName = firstname;
        this.LastName = lastname;
        this.country = country;
        this.age = age;
        this.serial = serial;
        this.rating = rating;
        
        
    }

    // Getters
    public String getFirstName() {
        return FirstName;
    }
    
    public String getLastName() {
        return LastName;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }
    
    public boolean getSerial() {
        return serial;
    }
    
    public String getRating() {
        return rating;
    }
    

    public void displayDetails() {
        System.out.println("Name: " + FirstName + LastName);
        System.out.println("Country: " + country);
        System.out.println("Age: " + age);
        System.out.println("Serial: " + serial);
        System.out.println("Rating: " + rating);
        System.out.println();
    }
}


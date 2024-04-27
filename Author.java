package BookCase;

import java.util.ArrayList;
import java.util.List;

class Author {
    private String FirstName;
    private String LastName;
    
    private String country;
    private int age;
    

    // Constructor
    public Author(String firstname, String lastname, String country, int age) {
        this.FirstName = firstname;
        this.LastName = lastname;
        this.country = country;
        this.age = age;
        
        
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

    

    

    public void displayDetails() {
        System.out.println("Name: " + FirstName + LastName);
        System.out.println("Country: " + country);
        System.out.println("Age: " + age);
      
       
        System.out.println();
    }
}


package Entities;

public class Passenger {
    private String firstName;
    private String lastName;



    public void setfirstName(String firstName)
    {
        this.firstName=firstName;
    }

    public void setlastName(String lastName)
    {
        this.lastName=lastName;
    }

    public String PassengerInfo() {
        return firstName + " " + lastName;
    }
}

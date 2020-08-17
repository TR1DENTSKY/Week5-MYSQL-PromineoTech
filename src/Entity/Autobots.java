package Entity;

public class Autobots {

    private int autobotsId;
    private String firstName;
    private String lastName;

    public Autobots(int autobotsId, String firstName, String lastName) {
        this.setAutobotsId(autobotsId);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public int getAutobotsId() {
        return autobotsId;
    }

    public void setAutobotsId(int autobotsId) {
        this.autobotsId = autobotsId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

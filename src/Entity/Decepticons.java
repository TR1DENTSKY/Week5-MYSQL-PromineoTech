package Entity;

public class Decepticons {

    private int decepticonsId;
    private String firstName;
    private String lastName;

    public Decepticons(int decepticonsId, String firstName, String lastName) {
        this.setDecepticonsId(decepticonsId);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public int getDecepticonsId() {
        return decepticonsId;
    }

    public void setDecepticonsId(int decepticonsId) {
        this.decepticonsId = decepticonsId;
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

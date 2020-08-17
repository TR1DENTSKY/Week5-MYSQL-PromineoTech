package Entity;

import java.util.List;

public class Transformers {

    private int transformersId;
    private String name;
    private List<Autobots> autobots;
    private List<Decepticons> decepticons;

    public Transformers(int id, String name, List<Decepticons> decepticons, List<Autobots> autobots) {
        this.setId(id);
        this.setName(name);
        this.setAutobots(autobots);
        this.setDecepticons(decepticons);
    }

    public int getId() {
        return transformersId;
    }

    public void setId(int id) {
        this.transformersId = transformersId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Autobots> getAutobots() {
        return autobots;
    }

    public void setAutobots(List<Autobots> autobots) {
        this.autobots = autobots;
    }

    public List<Decepticons> getDecepticons() {
        return decepticons;
    }

    public void setDecepticons(List<Decepticons> decepticons) {
        this.decepticons = decepticons;
    }
}

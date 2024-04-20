package KMA.KTLT.KTLT.Entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "credit")
    private int credit;
    @OneToMany(mappedBy = "subject")
    private List<Score> scores;

    public Subject() {
    }

    public Subject(int id, String name, int credit, List<Score> scores) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.scores = scores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", scores=" + scores +
                '}';
    }
}

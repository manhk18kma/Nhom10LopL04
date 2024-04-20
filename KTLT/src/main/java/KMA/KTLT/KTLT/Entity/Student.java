package KMA.KTLT.KTLT.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private Boolean sex;
    @Column(name = "dateofbirth")
    private Date dateOfBirth;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Score> scores;
    public Student() {
    }

    public Student(int id, String name, Boolean sex, Date dateOfBrith, List<Score> scores) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBrith;
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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getDateOfBrith() {
        return dateOfBirth;
    }

    public void setDateOfBrith(Date dateOfBrith) {
        this.dateOfBirth = dateOfBrith;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", dateOfBrith=" + dateOfBirth +
                ", scores=" + scores +
                '}';
    }
}

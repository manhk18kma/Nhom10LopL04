package KMA.KTLT.KTLT.DTO;

import jakarta.persistence.Column;

import java.sql.Date;

public class StudentDTO {
    private int id;
    private String name;
    private Boolean sex;
    private Date dateOfBirth;

    public StudentDTO() {
    }

    public StudentDTO(int id, String name, Boolean sex, Date dateOfBrith) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBrith;
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

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", dateOfBrith=" + dateOfBirth +
                '}';
    }
}

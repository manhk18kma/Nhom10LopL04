package KMA.KTLT.KTLT.Repository;

import KMA.KTLT.KTLT.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.sql.Date;
import java.util.List;
@RepositoryRestResource(path = "repositoryStudent")
public interface StudentRepository extends JpaRepository<Student , Integer> {

    @Query("SELECT s FROM Student s WHERE s.id = :studentId")
    public Student ktltGetStudentById(@Param("studentId") int id);

    @Query("SELECT s FROM Student s")
    public List<Student> ktltGetAllStudent();

    @Modifying
    @Query("INSERT INTO Student (name, sex, dateOfBirth) VALUES (:name, :sex, :dateOfBirth)")
    public void ktltPostStudent(@Param("name") String name, @Param("sex") Boolean sex, @Param("dateOfBirth") String dateOfBirth);


    @Modifying
    @Query("UPDATE Student SET name = :name, sex = :sex, dateOfBirth = :dateOfBirth WHERE id = :studentId")
    public void ktltPutStudent(@Param("studentId") int studentId, @Param("name") String name, @Param("sex") Boolean sex, @Param("dateOfBirth") Date dateOfBirth);


    @Modifying
    @Query("DELETE FROM Student WHERE id = :studentId")
    public void ktltDeleteStudent(@Param("studentId") int studentId);




}

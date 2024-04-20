package KMA.KTLT.KTLT.Repository;

import KMA.KTLT.KTLT.Entity.Student;
import KMA.KTLT.KTLT.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.sql.Date;
import java.util.List;

@RepositoryRestResource(path = "repositorySubject")

public interface SubjectRepository extends JpaRepository<Subject , Integer> {
    @Query("SELECT s FROM Subject s WHERE s.id = :subjectId")
    public Subject ktltGetSubjectById(@Param("subjectId") int id);

    @Query("SELECT s FROM Subject s")
    public List<Subject> ktltGetAllSubject();

    @Modifying
    @Query("INSERT INTO Subject ( name, credit) VALUES (:name, :credit)")
    public void ktltPostSubject(@Param("name") String name, @Param("credit") int credit);


    @Modifying
    @Query("UPDATE Subject SET name = :name, credit = :credit WHERE id = :subjectId")
    public void ktltPutSubject(@Param("subjectId") int subjectId, @Param("name") String name, @Param("credit") int credit);


    @Modifying
    @Query("DELETE FROM Subject WHERE id = :subjectId")
    public void ktltDeleteSubject(@Param("subjectId") int subjectId);

}

package KMA.KTLT.KTLT.Repository;

import KMA.KTLT.KTLT.Entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource(path = "repositoryScore")
public interface ScoreRepository extends JpaRepository<Score , Integer> {
}

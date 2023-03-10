package user.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import user.domain.entity.TeamsEntity;

@Repository
public interface TeamsRepo extends JpaRepository<TeamsEntity, Long>, JpaSpecificationExecutor<TeamsEntity> {
}

package user.domain.repo;

import org.springframework.data.repository.CrudRepository;
import user.domain.entity.TeamsEntity;

public interface TeamsRepo extends CrudRepository<TeamsEntity, Long> {
}

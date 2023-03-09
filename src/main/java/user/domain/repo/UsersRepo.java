package user.domain.repo;

import org.springframework.data.repository.CrudRepository;
import user.domain.entity.UsersEntity;

public interface UsersRepo extends CrudRepository<UsersEntity, Long> {
}

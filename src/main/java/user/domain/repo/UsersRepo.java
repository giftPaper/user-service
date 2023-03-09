package user.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import user.domain.entity.UsersEntity;

@Repository
public interface UsersRepo extends JpaRepository<UsersEntity, Long>, JpaSpecificationExecutor<UsersEntity> {
}

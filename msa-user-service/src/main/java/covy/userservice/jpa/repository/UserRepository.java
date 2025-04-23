package covy.userservice.jpa.repository;

import covy.userservice.jpa.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * <클래스 설명>
 *
 * @author : junni802
 * @date : 2025-02-18
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {

  UserEntity findByUserId(String userId);

  UserEntity findByEmail(String username);
}

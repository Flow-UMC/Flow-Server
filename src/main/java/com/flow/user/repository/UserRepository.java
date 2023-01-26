package com.flow.user.repository;

import com.flow.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByOauthId(String oauthId);
    Optional<User> findByOauthIdAndIsDeleted(String oauthId, String n);

    @Query("select u from User u where u.oauthId = :oauthId and u.isDeleted = 'N'")
    User findProfile(@Param("oauthId") String oauthId);
}

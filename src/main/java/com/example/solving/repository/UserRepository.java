package com.example.solving.repository;

import com.example.solving.entity.User;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndNicknameOrNicknameOrEmail(String email, String nickname, String nickname2, String email2);
    Optional<User> findByNickname(String nickname);
    Optional<User> findByEmail(String email);
    Optional<User> findByNicknameOrEmail(String nickname, String email);

    Optional<User> findByConfirmCode(String confirmCode);
}

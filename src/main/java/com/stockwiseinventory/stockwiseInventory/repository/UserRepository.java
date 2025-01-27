package com.stockwiseinventory.stockwiseInventory.repository;

import com.stockwiseinventory.stockwiseInventory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    Optional<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE FUNCTION('MONTH', u.createdAt) = FUNCTION('MONTH', CURRENT_DATE) AND FUNCTION('YEAR', u.createdAt) = FUNCTION('YEAR', CURRENT_DATE)")
    List<User> findUsersRegisteredThisMonth();


    @Query("SELECT COUNT(u) FROM User u WHERE u.status = 'active'")
    long countActiveUsers();
//    boolean existsByUsername(String username);

}


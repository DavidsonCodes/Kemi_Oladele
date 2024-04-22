package com.AccountUser.AccountUser.repository;

import com.AccountUser.AccountUser.model.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountUserRepository extends JpaRepository<AccountUser, Integer> {
    @Query(value = "SELECT MAX(id) FROM AccountUser", nativeQuery = true)
    AccountUser findByFirstName(String firstName);
    AccountUser findByLastName(String lastName);
    AccountUser findByMiddleName(String middleName);
    AccountUser findByUsername(String username);
    AccountUser findByPassword(String password);
    AccountUser findByPhoneNumber(int phoneNumber);
}

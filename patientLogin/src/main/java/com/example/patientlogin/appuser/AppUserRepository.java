package com.example.patientlogin.appuser;

import com.example.patientlogin.patientOrder.Patient_orderset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long>{

    Optional<AppUser> findByEmail(String email);

    @Transactional
    @Query("select u from patient u where u.email = ?1")
    AppUser searchEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE patient a " + "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);


}

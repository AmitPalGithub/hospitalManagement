package com.futureinnovation.hospitalManagement.repository;


import com.futureinnovation.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.futureinnovation.hospitalManagement.entity.Patient;
import com.futureinnovation.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {


    // JPQL
    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);
    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);


    // JPQL using @query for complex query
    @Query("SELECT p from Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate > :DOB")
    List<Patient> findByBornAfterDate(@Param("DOB") LocalDate birthDate);

//    @Query("select p.bloodGroup, count(*) from Patient p group by p.bloodGroup" )
//    List<Object[]> countEachBloodGroupType();

    @Query("select new com.futureinnovation.hospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup, Count(p))" +
            "from Patient p group by p.bloodGroup")
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    // Native SQL query
    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> findAllPatients();

    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatientsUsingPagination(Pageable pageable);



    // Update query using jpql
    @Modifying
    @Transactional
    @Query("UPDATE Patient p SET p.name = :name where p.id = :id")
    int updatedNameWithId(@Param("name") String name, @Param("id") Long id);
}

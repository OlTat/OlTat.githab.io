package com.example.homework10and11;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query("SELECT c FROM Contact c WHERE c.group = :group")
    List<Contact> findByGroup(@Param("group") com.example.homework10and11.Group group, Pageable pageable);

    @Query("SELECT c FROM Contact c WHERE c.group = :group")
    List<Contact> findContactsByGroup(@Param("group") com.example.homework10and11.Group group);

    @Query("SELECT COUNT(c) FROM Contact c WHERE c.group = :group")
    long countByGroup(@Param("group") Group group);

    @Query("SELECT c FROM Contact c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Contact> findByPattern(@Param("pattern") String pattern, Pageable pageable);

    // List<Contact> findByNameOrEmailOrderById(String name, String email);
    // List<Contact> findByNameAndEmail(String name, String email);
}

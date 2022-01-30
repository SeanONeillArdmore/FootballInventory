package com.footballinventory.dao;

import com.footballinventory.entity.Jersey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JerseyRepository extends JpaRepository<Jersey, String> {
}

package com.footballinventory.dao;

import com.footballinventory.entity.JerseyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JerseyRepository extends JpaRepository<JerseyEntity, String> {
    List<JerseyEntity> findByTeam(String team);
}

package com.footballinventory.dao;

import com.footballinventory.entity.Jersey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JerseyRepository extends JpaRepository<Jersey, String> {

    List<Jersey> findByTeamStartingWithAndYear(String team, Integer year);
}

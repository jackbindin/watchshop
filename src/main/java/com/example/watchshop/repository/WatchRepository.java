package com.example.watchshop.repository;

import java.util.Optional;

import com.example.watchshop.model.Watch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchRepository extends JpaRepository<Watch, Integer> {
    Optional<Watch> findByWatchId(int Id);
}

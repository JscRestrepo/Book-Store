package com.books.system.repository;

import com.books.system.model.entity.UserEventHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<UserEventHistory, Long> {
}

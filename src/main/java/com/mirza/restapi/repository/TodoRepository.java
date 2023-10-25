package com.mirza.restapi.repository;

import com.mirza.restapi.entity.Todo;
import com.mirza.restapi.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findAllByStatus(StatusEnum statusEnum);
}

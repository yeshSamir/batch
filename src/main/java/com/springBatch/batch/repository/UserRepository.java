package com.springBatch.batch.repository;

import com.springBatch.batch.model.User;
import org.springframework.batch.item.Chunk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    void save(Chunk<? extends User> chunk);
}

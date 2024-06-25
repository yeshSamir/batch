package com.springBatch.batch.batch;

import com.springBatch.batch.model.User;
import com.springBatch.batch.repository.UserRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DbWriter implements ItemWriter<User> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void write(Chunk<? extends User> chunk) throws Exception {
        System.out.println("User data save"+ chunk);
        userRepository.saveAll(chunk);
    }
}

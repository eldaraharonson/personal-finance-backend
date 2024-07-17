package com.example.personal_finance.user;

import java.time.OffsetDateTime;
import java.util.List;

public interface UserRepository {

    int create(User user);

    int update(User user, int id );

    User findById(int id);

    List<User> findAll();

    int deleteById(int id);

    int deleteAll();
}

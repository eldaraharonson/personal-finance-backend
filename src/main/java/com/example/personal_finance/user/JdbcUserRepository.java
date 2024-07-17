package com.example.personal_finance.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcUserRepository implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(User user) {
        String sql = "INSERT INTO Users (id, username, password, email) VALUES(?, ?, ?, ?)";
        return this.jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getPassword(),
                user.getEmail());
    }

    @Override
    public int update(User user, int id) {
        String sql = "UPDATE Users SET username = ?, password = ?, email = ? WHERE id = ?";
        return this.jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), id);
    }

    @Override
    public User findById(int id) {
        String sql = "SELECT * FROM Users WHERE id = ?";
        return this.jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM Users";
        return this.jdbcTemplate.query(sql, new UserMapper());
    }

   @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM Users WHERE id = ?";
        return this.jdbcTemplate.update(sql, id);
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}

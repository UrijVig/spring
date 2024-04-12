package com.example.my_first_REST.repository.imp;

import com.example.my_first_REST.domen.User;
import com.example.my_first_REST.repository.iRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Profile("task2")
public class H2Repository implements iRepository<User> {
    private final JdbcTemplate jdbc;
    public H2Repository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }

    @Override
    public User save(User user) {
        String sql = "INSERT INTO userTable (name, age, email) VALUES (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
        return  user;
    }

    @Override
    public User deleteById(int id) {
        return null;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User updateById(User user) {
        return null;
    }
}

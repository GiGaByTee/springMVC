package com.nazar.springmvc.dao;

import com.nazar.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User findById(long id) {
        /*String sql = "SELECT * FROM user WHERE id=" + id;
        return jdbcTemplate.query(sql, rs -> {
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setCreateTime(rs.getTime("create_time"));
                return user;
            }

            return null;
        });*/
        User user;
        try {
            user = jdbcTemplate.queryForObject("SELECT * FROM user WHERE id = ?",
                    new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        } catch (DataAccessException e) {
            user=null;
        }
        return user;
    }

    @Override
    public User findByName(String name) {
        User user;
        try {
            user = jdbcTemplate.queryForObject("SELECT * FROM user WHERE username = ?",
                    new Object[]{name}, new BeanPropertyRowMapper<>(User.class));
        } catch (DataAccessException e) {
            user=null;
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        jdbcTemplate.update(
                "INSERT INTO user(username, email, password)VALUES(?,?,?)",
                user.getUsername(), user.getEmail(), user.getPassword());
    }

    @Override
    public void updateUser(User user) {
        jdbcTemplate.update(
                "UPDATE user set username = ? , email = ? , password = ? where id = ?",
                user.getUsername(), user.getEmail(), user.getPassword(), user.getId());
    }

    @Override
    public void deleteUserById(long id) {
        jdbcTemplate.update("DELETE from user WHERE id = ?", id);
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            users = jdbcTemplate.query("SELECT * FROM user", new BeanPropertyRowMapper<>(User.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("DELETE from user");
    }

    @Override
    public boolean isUserExist(User user) {
        User newUser;
        try {
            newUser = jdbcTemplate.queryForObject("SELECT * FROM user WHERE username = ? AND email = ? AND password = ?",
                    new Object[]{user.getUsername(), user.getEmail(), user.getPassword()}, new BeanPropertyRowMapper<>(User.class));
        } catch (EmptyResultDataAccessException e) {
            newUser = null;
        }
        System.out.println("is exist = " + newUser);
        return Objects.isNull(newUser);
    }
}
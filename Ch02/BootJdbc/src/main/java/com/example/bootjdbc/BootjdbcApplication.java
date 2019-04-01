package com.example.bootjdbc;

import com.example.bootjdbc.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@SpringBootApplication
public class BootjdbcApplication implements CommandLineRunner {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BootjdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "select id, first_name, last_name from customers where id=:id";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", 1);
//        Customer result = jdbcTemplate.queryForObject(sql, param, new RowMapper<Customer>() {
//
//            @Override
//            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
//                return new Customer(resultSet.getInt("id")
//                        , resultSet.getString("first_name"), resultSet.getString("last_name"));
//            }
//        });

        Customer result = jdbcTemplate.queryForObject(sql, param,
                (rs, rowNum) -> new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name")));

        System.out.println("result = " + result);
    }
}

package com.example.personal_finance.expense;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;


public class ExpenseMapper implements RowMapper<Expense> {
    @Override
    public Expense mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Expense(rs.getInt("id"), rs.getDouble("amount"),
            rs.getString("business"), rs.getString("product"), rs.getInt("user_id"),
            rs.getObject("date_time", OffsetDateTime.class));
    }

}

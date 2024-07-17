package com.example.personal_finance.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public class JdbcExpenseRepository implements ExpenseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Expense expense) {
        String sql = "INSERT INTO Expenses (amount, business, product, user_id, date_time) VALUES(?, ?, ?, ?, ?)";
        return this.jdbcTemplate.update(sql, expense.getAmount(), expense.getBusiness(), expense.getProduct(),
                expense.getUserId(), expense.getDateTime());
    }

    @Override
    public int update(Expense expense, int id) {
        String sql = "UPDATE Expenses SET amount = ?, business = ?, product = ?, userId = ?, dateTime = ? WHERE id = ?";
        return this.jdbcTemplate.update(sql, expense.getAmount(), expense.getBusiness(), expense.getProduct(),
                expense.getUserId(), expense.getDateTime(), id);
    }

    @Override
    public Expense findById(int id) {
        String sql = "SELECT * FROM Expenses WHERE id = ?";
        return this.jdbcTemplate.queryForObject(sql, new Object[]{id}, new ExpenseMapper());
    }

   @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM Expenses WHERE id = ?";
        return this.jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Expense> findAll() {
        String sql = "SELECT * FROM Expenses";
        return this.jdbcTemplate.query(sql, new ExpenseMapper());
    }

    @Override
    public List<Expense> findAllByUserId(int userId) {
        String sql = "SELECT * FROM Expenses WHERE user_id = " + userId;
        return this.jdbcTemplate.query(sql, new ExpenseMapper());
    }

    @Override
    public List<Expense> findByPrice(int lowest, int highest) {
        String sql = "SELECT * FROM Expenses WHERE amount <= " + highest + " AND amount >= " + lowest;
        return this.jdbcTemplate.query(sql, new ExpenseMapper());
    }

    @Override
    public List<Expense> findByDate(OffsetDateTime start, OffsetDateTime end) {
        String sql = "SELECT * FROM Expenses WHERE date_time between " + start + " AND " + end;
        return this.jdbcTemplate.query(sql, new ExpenseMapper());
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}

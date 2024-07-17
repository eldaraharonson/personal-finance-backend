package com.example.personal_finance.expense;

import java.time.OffsetDateTime;
import java.util.List;

public interface ExpenseRepository {

    int create(Expense expense);

    int update(Expense Expense, int id);

    Expense findById(int id);

    List<Expense> findAll();

    List<Expense> findAllByUserId(int userId);

    int deleteById(int id);

    List<Expense> findByPrice(int lowest, int highest);

    List<Expense> findByDate(OffsetDateTime start, OffsetDateTime end);

    int deleteAll();
}

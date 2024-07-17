package com.example.personal_finance.expense;
import java.time.OffsetDateTime;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // @valid makes sure the expense is valid based on validation tags in Expense class
    // if not then bad request status is returned
    @ResponseStatus(HttpStatus.CREATED) // sends 201 created response instead of 200
    @PostMapping("")
    void create(@Valid @RequestBody Expense expense) {
        this.expenseRepository.create(expense);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody Expense expense, @PathVariable int id) {
        this.expenseRepository.update(expense, id);
    }

    @GetMapping("/{id}")
    Expense findById(@PathVariable int id) {
//        Optional<Expense> expense = this.expenseRepository.findById(id);
//        if (expense.isEmpty()) {
//            throw new ExpenseNotFoundException();
//        }
        return this.expenseRepository.findById(id);
    }

    @GetMapping
    List<Expense> findAll() {
        return this.expenseRepository.findAll();
    }

    @GetMapping("/find-by-user-id/{user-id}")
    List<Expense> findAllByUserId(@PathVariable("user-id") int userId) {
        return this.expenseRepository.findAllByUserId(userId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        this.expenseRepository.deleteById(id);
    }

    @GetMapping("/find-by-price")
    List<Expense> findByPrice(@RequestParam("lowest") int lowest, @RequestParam("highest") int highest) {
        return this.expenseRepository.findByPrice(lowest, highest);
    }


    // Test this API
    @GetMapping("/find-by-date")
    List<Expense> findByDate(@RequestParam("start") OffsetDateTime lowest, @RequestParam("end") OffsetDateTime highest) {
        return this.expenseRepository.findByDate(lowest, highest);
    }
}

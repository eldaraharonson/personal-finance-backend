package com.example.personal_finance.user;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // @valid makes sure the expense is valid based on validation tags in Expense class
    // if not then bad request status is returned
    @ResponseStatus(HttpStatus.CREATED) // sends 201 created response instead of 200
    @PostMapping("")
    void create(@Valid @RequestBody User user) {
        this.userRepository.create(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody User user, @PathVariable int id) {
        this.userRepository.update(user, id);
    }

    @GetMapping("/{id}")
    User findById(@PathVariable int id) {
//        Optional<Expense> expense = this.expenseRepository.findById(id);
//        if (expense.isEmpty()) {
//            throw new ExpenseNotFoundException();
//        }
        return this.userRepository.findById(id);
    }

    @GetMapping
    List<User> findAll() {
        return this.userRepository.findAll();
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        this.userRepository.deleteById(id);
    }
}

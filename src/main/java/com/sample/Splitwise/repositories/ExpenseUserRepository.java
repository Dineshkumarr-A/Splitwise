package com.sample.Splitwise.repositories;

import com.sample.Splitwise.models.ExpenseUser;
import com.sample.Splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
    List<ExpenseUser> findAllByUser(User user);
}

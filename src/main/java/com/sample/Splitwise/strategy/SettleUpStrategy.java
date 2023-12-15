package com.sample.Splitwise.strategy;

import com.sample.Splitwise.models.Expense;
import com.sample.Splitwise.models.Transaction;

import java.util.List;

public interface SettleUpStrategy {
    public List<Transaction> settleUp(List<Expense> expenses);
}

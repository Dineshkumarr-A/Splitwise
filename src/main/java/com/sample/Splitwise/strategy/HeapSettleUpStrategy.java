package com.sample.Splitwise.strategy;

import com.sample.Splitwise.models.Expense;
import com.sample.Splitwise.models.Transaction;

import java.util.List;

public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        return null;
    }
}

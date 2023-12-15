package com.sample.Splitwise.services;

import com.sample.Splitwise.models.*;
import com.sample.Splitwise.repositories.ExpenseUserRepository;
import com.sample.Splitwise.repositories.GroupRepository;
import com.sample.Splitwise.repositories.UserRepository;
import com.sample.Splitwise.strategy.HeapSettleUpStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SettleUpService {

    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private HeapSettleUpStrategy settleUpStrategy;
    private GroupRepository groupRepository;

    public SettleUpService(UserRepository userRepository, ExpenseUserRepository expenseUserRepository, HeapSettleUpStrategy settleUpStrategy, GroupRepository groupRepository)
    {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.groupRepository = groupRepository;
    }

    //This method will return transaction between two
    public List<Transaction> settleUpUser(Long userId)
    {
        /*
        * 1. Get the list of expense of user part of
        * 2. Generate who owes what and who need to get from the list
        * 3. User min and max heap to figure out the list transaction
        * 4. Return the list
        * */

        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty())
            throw new RuntimeException(); //ToDo: create a specific exception

        User user = userOptional.get();

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);

        List<Expense> expenses = new ArrayList<>();
        for(ExpenseUser expenseUser: expenseUsers)
            expenses.add(expenseUser.getExpense());

        List<Transaction> transactions = settleUpStrategy.settleUp(expenses);

        List<Transaction> filteredTransaction =  new ArrayList<>();

        for(Transaction transaction: transactions)
        {
            if(transaction.getFrom().getId().equals(userId) || transaction.getTo().getId().equals(userId))
                filteredTransaction.add(transaction);
        }

        return transactions;
    }

    //This method will return the transaction of all users
    public List<Transaction> settleUpGroup(Long groupId)
    {
        Optional<Group> groupOptional = groupRepository.findById(groupId);

        if(groupOptional.isEmpty())
            throw new RuntimeException();

        Group group = groupOptional.get();

        List<Expense> expenses = group.getExpenses();

        List<Transaction> transactions = settleUpStrategy.settleUp(expenses);

        return transactions;
    }
}

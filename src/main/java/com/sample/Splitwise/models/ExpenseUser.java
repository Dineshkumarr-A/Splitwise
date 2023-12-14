package com.sample.Splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpenseUser extends BaseModel{

    @ManyToOne
    private Expense expense; //Each expense will have only one expense
                            // single expense can be in multiple expense user

    @ManyToOne
    private User user;
    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType expenseUserType;
}

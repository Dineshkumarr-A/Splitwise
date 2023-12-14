package com.sample.Splitwise.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private String description;
    private int amount;
    @ManyToOne
    private User createdBy;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType; // for enum we need to add this
    private Date createdAt;

    @ManyToOne
    private Group group;

    @OneToMany(mappedBy = "expense") //It is to avoid multiple mapping creation
    private List<ExpenseUser> expenseUsers;
}

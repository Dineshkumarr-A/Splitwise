package com.sample.Splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Group extends BaseModel{
    private String name;

    @ManyToMany
    private List<User> members;

    @OneToMany(mappedBy = "group") // This mention the relationship between group and expense
    // is also represented on the expense class as well. Hibernate will consider them as two different unique mapping
    // So add a mapped key word the properties.
    private List<Expense> expenses;

    @ManyToOne
    private User createdBy; //One group can be created by one person
                            //One user can create many group
}

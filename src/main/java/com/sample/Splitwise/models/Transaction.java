package com.sample.Splitwise.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private User from;
    private User to;
    private int amount;
}

package com.sample.Splitwise.commands;

import com.sample.Splitwise.controller.SettleUpController;
import com.sample.Splitwise.dtos.SettleUpRequestDTO;
import com.sample.Splitwise.models.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpUserCommand implements Command{

    @Autowired
    private SettleUpController settleUpController;

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long userId = Long.valueOf(words.get(0));
        if(matches(input))
        {
            SettleUpRequestDTO settleUpRequestDTO = new SettleUpRequestDTO();

            settleUpRequestDTO.setUserId(userId);
            settleUpController.settleUpUser(settleUpRequestDTO);

            System.out.println("Print the list od settle ups");

        }
    }

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));

        return words.size() == 2 && words.get(1).equalsIgnoreCase(Constants.SettleUp);
    }
}

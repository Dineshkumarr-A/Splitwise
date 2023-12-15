package com.sample.Splitwise.controller;

import com.sample.Splitwise.dtos.SettleUpRequestDTO;
import com.sample.Splitwise.dtos.SettleUpResponseDTO;
import com.sample.Splitwise.models.Transaction;
import com.sample.Splitwise.services.SettleUpService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {

    private SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    public SettleUpResponseDTO settleUpUser(SettleUpRequestDTO request)
    {
        List<Transaction> transactions = settleUpService.settleUpUser(request.getUserId());

        SettleUpResponseDTO settleUpResponseDTO = new SettleUpResponseDTO();

        settleUpResponseDTO.setTransactions(transactions);

        return settleUpResponseDTO;
    }

}

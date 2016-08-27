package com.example.controllers;

import com.example.dto.PurseDTO;
import com.example.dto.TransactionDTO;
import com.example.entity.PurseEntity;
import com.example.entity.TransactionEntity;
import com.example.repository.TransactionRepository;
import com.example.service.PurseService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PurseController {
    @Autowired
    private PurseService purseService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private Mapper dozerBean;

    @RequestMapping(value = "/")
    private String showPurse() {
        return "site.cabinet.purse";
    }

    @RequestMapping(value = "/purse/{id}")
    private String showPurse(@PathVariable(value = "id") final Integer id, Model model) {
        PurseEntity entity = purseService.find(id);
        List<TransactionEntity> transactions = transactionRepository.findForPurse(id);
        List<TransactionDTO> transactionDTOList = new ArrayList<>(transactions.size());
        for (TransactionEntity t : transactions) {
            transactionDTOList.add(dozerBean.map(t, TransactionDTO.class));
        }
        model.addAttribute("purse", dozerBean.map(entity, PurseDTO.class));
        model.addAttribute("transactions", transactionDTOList);
        return "site.cabinet.purse";
    }

}

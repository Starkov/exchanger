package com.example.controllers;

import com.example.dto.CurrencyDTO;
import com.example.dto.PurseDTO;
import com.example.dto.PurseTypeDTO;
import com.example.dto.TransactionDTO;
import com.example.entity.*;
import com.example.service.*;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class PurseController {
    @Autowired
    private PurseService purseService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private PurseTypeService purseTypeService;
    @Autowired
    private PersonService personService;
    @Autowired
    private Mapper dozerBean;

    @RequestMapping(value = "/")
    private String showPurse() {
        return "site.cabinet.purse";
    }

    @GetMapping(value = "/purse/add")
    private String addform(Model model) {
        List<CurrencyDTO> currencyList = new ArrayList<>();
        for (CurrencyEntity currencyEntity : currencyService.findAll()) {
            CurrencyDTO currencyDTO = dozerBean.map(currencyEntity, CurrencyDTO.class);
            currencyList.add(currencyDTO);
        }

        List<PurseTypeDTO> purseTypeList = new ArrayList<>();
        for (PurseTypeEntity purseTypeEntity : purseTypeService.findAll()) {
            PurseTypeDTO purseTypeDTO = dozerBean.map(purseTypeEntity, PurseTypeDTO.class);
            purseTypeList.add(purseTypeDTO);
        }

        model.addAttribute("currencyList", currencyList);
        model.addAttribute("purseTypeList", purseTypeList);
        model.addAttribute("purseForm", new PurseDTO());

        return "site.cabinet.purse.add";
    }

    @PostMapping(value = "/purse")
    private String saveOrUpdate(@ModelAttribute("purseForm") @Validated PurseDTO purse) {
        PurseEntity purseEntity = dozerBean.map(purse, PurseEntity.class);
        if (purseEntity.getNumber() == null) {
            PersonEntity person = personService.getCurrentPerson();
            if (person instanceof ClientEntity) {
                purseEntity.setClient((ClientEntity) person);
                purseEntity.setNumber(UUID.randomUUID().toString());
                purseEntity.setBalance(BigDecimal.ZERO);
            } else {
                return ""; //TODO handle this situation with message 'You can't create a purse!'
            }
        }
        purseEntity = purseService.save(purseEntity);

        return "redirect:/purse/" + purseEntity.getId();
    }

    @GetMapping(value = "/purse/{id}")
    private String showPurse(@PathVariable(value = "id") final Integer id, Model model) {
        PurseEntity entity = purseService.find(id);
        List<TransactionEntity> transactions = transactionService.findForPurse(id);
        List<TransactionDTO> transactionDTOList = new ArrayList<>(transactions.size());
        for (TransactionEntity t : transactions) {
            transactionDTOList.add(dozerBean.map(t, TransactionDTO.class));
        }
        model.addAttribute("purse", dozerBean.map(entity, PurseDTO.class));
        model.addAttribute("transactions", transactionDTOList);
        return "site.cabinet.purse";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(PurseTypeDTO.class, "purseType", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                PurseTypeEntity entity = purseTypeService.find(Integer.valueOf(text));
                PurseTypeDTO dto = dozerBean.map(entity, PurseTypeDTO.class);
                setValue(dto);
            }
        });
        binder.registerCustomEditor(CurrencyDTO.class, "currency", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                CurrencyEntity entity = currencyService.find(Integer.valueOf(text));
                CurrencyDTO dto = dozerBean.map(entity, CurrencyDTO.class);
                setValue(dto);
            }
        });
    }
}

package com.milos.demo.controller;

import com.milos.demo.model.AccountsEntity;
import com.milos.demo.model.AccountsModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.milos.demo.service.AccountsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class AccountsController {

    private final AccountsServiceImpl service;

    ModelMapper modelMapper = new ModelMapper();
    @RequestMapping("/")
    public String getAccounts(Model model) {
        model.addAttribute("allAccounts", service.getAccounts());
        return "index.html";
    }
    @GetMapping("/add")
    public String addNewAccount(Model model) {
        AccountsEntity entity = new AccountsEntity();
        AccountsModel newAccount = modelMapper.map(entity, AccountsModel.class);
        model.addAttribute("account", newAccount);
        return "newAccount.html";
    }
    @PostMapping("/save")
    public String saveAccount(@ModelAttribute("account") AccountsModel account) {
        service.saveAccount(account);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable(value = "id") Long id, Model model) {
        AccountsModel accountModel = service.getAccountById(id);
        model.addAttribute("account", accountModel);
        return "update.html";
    }
    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable(value = "id") Long id) {
        service.deleteAccountById(id);
        return "redirect:/";
    }

}

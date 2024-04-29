package com.milos.demo.service;

import com.milos.demo.data.AccountsRepository;
import com.milos.demo.data.AccountsService;
import com.milos.demo.exceptions.AccountNotFoundException;
import com.milos.demo.model.AccountsEntity;
import com.milos.demo.model.AccountsModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService<AccountsModel> {

    private final AccountsRepository accountsDAO;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<AccountsModel> getAccounts() {

        Iterable<AccountsEntity> entity = accountsDAO.findAll();

        List<AccountsModel> accounts = new ArrayList<>();

        for(AccountsEntity item : entity) {
            accounts.add(modelMapper.map(item, AccountsModel.class));
        }
        return accounts;
    }

    @Override
    public AccountsModel getAccountById(Long id) {

        Optional<AccountsEntity> entity = accountsDAO.findById(id);

        if(entity.isPresent())
            return modelMapper.map(entity, AccountsModel.class);
        else
             throw new AccountNotFoundException("Account with ID: " + id + " is not found.");
    }

    @Override
    public AccountsModel saveAccount(AccountsModel account) {

        AccountsEntity savedEntity = modelMapper.map(account, AccountsEntity.class);

        return modelMapper.map(accountsDAO.save(savedEntity), AccountsModel.class);
    }

    @Override
    public boolean deleteAccountById(Long id) {

        accountsDAO.deleteById(id);

        return true;
    }
}

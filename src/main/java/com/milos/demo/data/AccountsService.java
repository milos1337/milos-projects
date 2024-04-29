package com.milos.demo.data;

import java.util.List;

public interface AccountsService<T> {

    public List<T> getAccounts();
    public T getAccountById(Long id);
    public T saveAccount(T savedAccount);
    public boolean deleteAccountById(Long id);


}

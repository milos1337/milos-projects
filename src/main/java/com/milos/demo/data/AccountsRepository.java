package com.milos.demo.data;

import com.milos.demo.model.AccountsEntity;
import com.milos.demo.model.AccountsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsEntity, Long> {
}

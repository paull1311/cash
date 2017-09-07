package edu.bionic.dao;

import edu.bionic.domain.Account;

import java.util.List;

/**
 * Created by Pavel on 007 07.09.17.
 */
public interface AccountDao {
    List<Account> getAll();
    List<Account> getAllByUser(int userId);
    Account save(Account account);


}

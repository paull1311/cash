package edu.bionic.dao.mock;

import edu.bionic.dao.AccountDao;
import edu.bionic.domain.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 007 07.09.17.
 */
public class AccountDaoMock implements AccountDao {
    private List<Account> accountStorage;

    @Override
    public List<Account> getAll() {
        return new ArrayList<>(accountStorage);
    }

    @Override
    public List<Account> getAllByUser(int userId) {
        return null;
    }

    @Override
    public Account save(Account account) {
        accountStorage.add(account);
        return account;
    }

    public void initAccountStorage(){
        accountStorage = new ArrayList<>();
    }
}

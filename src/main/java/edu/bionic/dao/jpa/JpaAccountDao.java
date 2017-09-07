package edu.bionic.dao.jpa;

import edu.bionic.dao.AccountDao;
import edu.bionic.dao.UserDao;
import edu.bionic.domain.Account;
import edu.bionic.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class JpaAccountDao implements AccountDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Account> getAll() {
        return entityManager.createQuery("SELECT a FROM Account a", Account.class).getResultList();
    }

    @Override
    public List<Account> getAllByUser(int userId) {
        return entityManager.createQuery("SELECT a FROM Account a WHERE a.user.id = :userId", Account.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public Account save(Account account) {
        if (account.getId() == null) {
            entityManager.persist(account);
            return account;
        } else {
            return entityManager.merge(account);
        }
    }
}

package edu.bionic.dao.jpa;

import edu.bionic.dao.OperationDao;
import edu.bionic.domain.Operation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class JpaOperationDao implements OperationDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Operation> getAll() {
        return entityManager.createQuery("SELECT o FROM Operation o", Operation.class)
                .getResultList();
    }

    @Override
    public List<Operation> getAllSortedByName(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit) {
        TypedQuery<Operation> query = this.entityManager.createQuery("SELECT o FROM Operation o " +
                "WHERE o.name LIKE :name " +
                "AND (:min is NULL OR o.value >= :min) " +
                "AND (:max is NULL OR o.value <= :max) " +
                "ORDER BY o.name " + (desc ? "DESC " : "ASC "), Operation.class);

        query.setParameter("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%");
        query.setParameter("min", min);
        query.setParameter("max", max);
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        return query.getResultList();
    }

    @Override
    public List<Operation> getAllSortedByValue(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit) {
        TypedQuery<Operation> query = this.entityManager.createQuery("SELECT o FROM Operation o " +
                "WHERE o.name LIKE :name " +
                "AND (:min is NULL OR o.value >= :min) " +
                "AND (:max is NULL OR o.valuee <= :max) " +
                "ORDER BY o.price " + (desc ? "DESC " : "ASC "), Operation.class);

        query.setParameter("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%");
        query.setParameter("min", min);
        query.setParameter("max", max);
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        return query.getResultList();
    }

    @Override
    public int getCount(String name, BigDecimal min, BigDecimal max) {
        TypedQuery<Long> query = this.entityManager.createQuery("SELECT COUNT(o) FROM Operation o " +
                "WHERE o.name LIKE :name " +
                "AND (:min is NULL OR o.value >= :min) " +
                "AND (:max is NULL OR o.value <= :max) ", Long.class);
        query.setParameter("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%");
        query.setParameter("min", min);
        query.setParameter("max", max);

        return query.getSingleResult().intValue();
    }

    @Override
    public Optional<Operation> getById(int operationId) {
        Operation operation = entityManager.find(Operation.class, operationId);
        return Optional.ofNullable(operation);
    }

    @Override
    public Operation save(Operation operation) {
        if (operation.getId() == null) {
            entityManager.persist(operation);
            return operation;
        } else {
            return entityManager.merge(operation);
        }
    }

    @Override
    public boolean delete(int operationId) {
        Query query = entityManager.createQuery("DELETE FROM Operation o WHERE o.id = :operation_id");
        query.setParameter("operation_id", operationId);

        return query.executeUpdate() != 0;
    }
}

package edu.bionic.dao;

import edu.bionic.domain.Operation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by Pavel on 007 07.09.17.
 */
public interface OperationDao {
    List<Operation> getAll();

    List<Operation> getAllSortedByName(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit);

    List<Operation> getAllSortedByValue(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit);

    int getCount(String name, BigDecimal min, BigDecimal max);

    Optional<Operation> getById(int operationId);

    Operation save(Operation operation);

    boolean delete(int operationId);
}

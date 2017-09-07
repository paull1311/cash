package edu.bionic.dao.mock;

import edu.bionic.dao.OperationDao;
import edu.bionic.domain.OperType;
import edu.bionic.domain.Operation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Pavel on 007 07.09.17.
 */
public class OperationDaoMock implements OperationDao {
    private List<Operation> operationStorage;

    @Override
    public List<Operation> getAll() {
        return new ArrayList<>(operationStorage);
    }

    @Override
    public List<Operation> getAllSortedByName(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit) {
        return null;
    }

    @Override
    public List<Operation> getAllSortedByValue(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit) {
        return null;
    }

    @Override
    public int getCount(String name, BigDecimal min, BigDecimal max) {
        return operationStorage.size();
    }

    @Override
    public Optional<Operation> getById(int operationId) {
        return operationStorage.stream().filter(operation -> operation.getId() == operationId).findAny();
    }

    @Override
    public Operation save(Operation operation) {
        return null;
    }

    @Override
    public boolean delete(int operationId) {
        return false;
    }

    public void initOperationStorage(){
        operationStorage = new ArrayList<>();

        operationStorage.add(new Operation(
                1,
                "Зарплата",
                OperType.DEBIT,
                LocalDate.of(2017, 9, 6),
                BigDecimal.valueOf(10000.00)
        ));

        operationStorage.add(new Operation(
                2,
                "Продукты",
                OperType.CREDIT,
                LocalDate.of(2017, 9, 6),
                BigDecimal.valueOf(-243.65)
        ));

        operationStorage.add(new Operation(
                3,
                "Beer",
                OperType.CREDIT,
                LocalDate.of(2017, 9, 6),
                BigDecimal.valueOf(-200.00)
        ));

        operationStorage.add(new Operation(
                4,
                "Такси",
                OperType.CREDIT,
                LocalDate.of(2017, 9, 6),
                BigDecimal.valueOf(-120.00)
        ));

        operationStorage.add(new Operation(
                5,
                "Заначка",
                OperType.CREDIT,
                LocalDate.of(2017, 9, 6),
                BigDecimal.valueOf(-2650.00)
        ));

        operationStorage.add(new Operation(
                6,
                "Заначка",
                OperType.CREDIT,
                LocalDate.of(2017, 9, 6),
                BigDecimal.valueOf(-2650.00)
        ));

        operationStorage.add(new Operation(
                7,
                "Заначка с з/п",
                OperType.DEBIT,
                LocalDate.of(2017, 9, 6),
                BigDecimal.valueOf(100.00)
        ));
    }
}

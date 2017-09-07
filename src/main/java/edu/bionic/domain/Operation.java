package edu.bionic.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Pavel on 007 07.09.17.
 */
public class Operation {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Комментарий не должен быть пустым")
    private String message;

    @NotNull(message = "Обязательное поле")
    private OperType operType;

    private LocalDate localDate;

    @NotNull(message = "Обязательное поле")
    private BigDecimal amount;

    public Operation(Integer id,String message, OperType operType, LocalDate localDate,BigDecimal amount) {
        this.id = id;
        this.message = message;
        this.operType = operType;
        this.localDate = localDate;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operation operation = (Operation) o;

        if (id != null ? !id.equals(operation.id) : operation.id != null) return false;
        if (message != null ? !message.equals(operation.message) : operation.message != null) return false;
        if (operType != operation.operType) return false;
        return amount != null ? amount.equals(operation.amount) : operation.amount == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (operType != null ? operType.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OperType getOperType() {
        return operType;
    }

    public void setOperType(OperType operType) {
        this.operType = operType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}



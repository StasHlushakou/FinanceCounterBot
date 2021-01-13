package org.example.FinanceCounterBot.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Double sum;

    @Column
    private Currency currency;

    @Column
    private Date date;

    @Column
    private String description;

    public Record() {
    }

    public Record(Long id, Long userId, Double sum, Currency currency, Date date, String description) {
        this.id = id;
        this.userId = userId;
        this.sum = sum;
        this.currency = currency;
        this.date = date;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Records{" +
                "id=" + id +
                ", userId=" + userId +
                ", sum=" + sum +
                ", currency=" + currency +
                ", date=" + date +
                ", description='" + description + '}';
    }
}

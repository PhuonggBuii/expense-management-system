package com.example.expense_management_system.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "income") // Liên kết với bảng "income"
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private Integer id;

    @Column(name = "user_id", nullable = false) // Cột "user_id"
    private Integer userId;

    @Column(nullable = false) // Cột "amount"
    private Double amount;

    @Column(columnDefinition = "TEXT") // Cột "description"
    private String description;

    @Column(name = "income_date", nullable = false) // Cột "income_date"
    private LocalDateTime incomeDate;

    // Constructor mặc định (bắt buộc)
    public Income() {}

    // Getters và Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(LocalDateTime incomeDate) {
        this.incomeDate = incomeDate;
    }
}

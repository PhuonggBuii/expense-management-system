package com.example.expense_management_system.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense_management_system.model.Income;
import com.example.expense_management_system.repository.IncomeRepository;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;

    // Tạo mới một thu nhập
    @PostMapping("/add")
    public ResponseEntity<Income> addIncome(@RequestBody Income income) {
        // Gán ngày giờ hiện tại cho thu nhập mới
        income.setIncomeDate(LocalDateTime.now());
        
        // Lưu thu nhập vào cơ sở dữ liệu
        Income savedIncome = incomeRepository.save(income);

        // Trả về mã trạng thái HTTP 201 Created cùng với đối tượng Income đã được tạo mới
        return ResponseEntity.status(201).body(savedIncome);
    }

    // Lấy tất cả các bản ghi thu nhập
    @GetMapping("/all")
    public Iterable<Income> getAllIncome() {
        return incomeRepository.findAll();
    }
}
//get all theo id nguoi dung


package com.example.demo.controller

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("customers")
@Suppress("unused")
class CustomerController(val jdbcTemplate: JdbcTemplate, val selectAllQuery: SelectAllQuery) {
    @GetMapping("")
    fun getAllCustomers(): List<Customer> {
        return selectAllQuery.perform()
    }

    @GetMapping("/SatoOrTanaka")
    fun getSatoOrTanaka(): List<Customer>{
        return SelectSatoOrSuzukiQueryImpl(jdbcTemplate).perform()
    }

    @PostMapping("")
    fun postCustomers() {
        InsertCommandImpl(jdbcTemplate).perform("山田", "太郎")
    }
}
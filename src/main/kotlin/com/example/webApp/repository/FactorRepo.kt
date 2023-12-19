package com.example.webApp.repository

import com.example.webApp.entity.Factor
import org.springframework.data.jpa.repository.JpaRepository

interface FactorRepo: JpaRepository<Factor, Long> {
}
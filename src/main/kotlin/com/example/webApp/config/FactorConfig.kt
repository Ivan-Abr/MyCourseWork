package com.example.webApp.config

import com.example.webApp.entity.Factor
import com.example.webApp.repository.FactorRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FactorConfig {
    @Bean
    fun commandLineRunnerFactor(@Autowired factorRepo: FactorRepo): CommandLineRunner{
        return CommandLineRunner {
            val fact1 = Factor(1,null,"factName","fsn")
            factorRepo.saveAll(listOf(fact1))
        }
    }
}
package com.example.webApp.config

import com.example.webApp.entity.Mark
import com.example.webApp.repository.MarkRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MarkConfig {
    @Bean
    fun commandLineRunnerMark(@Autowired markRepo: MarkRepo): CommandLineRunner{
        return CommandLineRunner{
        val mark1 = Mark(1L,"mkName",1, null,null)
        markRepo.saveAll(listOf(mark1))    }
    }
}
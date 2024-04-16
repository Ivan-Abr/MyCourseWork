package com.example.webApp.config

import com.example.webApp.entity.Mark
import com.example.webApp.entity.Question
import com.example.webApp.repository.MarkRepo
import com.example.webApp.repository.QuestionRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QuestionConfig {
    @Bean
    fun commandLineRunnerMark(@Autowired questionRepo: QuestionRepo): CommandLineRunner {
        return CommandLineRunner {
            val digitInsDev = Question(1L,
                "Development of digital organizational instruments",
                "Which instruments used for setting tasks for personnel?",
                null,
                    null,
                null,

                )
            questionRepo.saveAll(listOf(digitInsDev))
        }
    }
}
package com.example.webApp.config

import com.example.webApp.entity.Mark
import com.example.webApp.repository.MarkRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MarkConfig {
//    @Bean
//    fun commandLineRunnerMark(@Autowired markRepo: MarkRepo):CommandLineRunner{
//        return CommandLineRunner {
//            val digitInsDev = Mark(11L,null,
//                    null,
//                "Development of digital organizational instruments",
//                "Which instruments used for setting tasks for personnel?",
//                0)
//            markRepo.saveAll(listOf(digitInsDev))
//        }
//    }
}
package com.example.webApp.controller

import com.example.webApp.service.AnswerService
import com.example.webApp.service.MarkService
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("dm/v1/anal/{answerId}")
class AnalController(private var answerService: AnswerService,
        private var markService: MarkService) {

    fun getData(model:Model,
                @PathVariable("answerId") answerId: Long): String
    {
        var answer = answerService.getAnswerById(answerId)
        var organization = answer.get().organization
        model.addAttribute("test_data", organization.toString())
        var mark = answer.get().mark
        model.addAttribute("test_mark", mark.toString())
        return "analpage"
    }



}
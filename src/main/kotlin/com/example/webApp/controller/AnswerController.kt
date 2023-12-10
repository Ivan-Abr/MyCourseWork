package com.example.webApp.controller

import com.example.webApp.entity.Answer
import com.example.webApp.service.AnswerService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("dm/v1/answer")
class AnswerController(private var answerService: AnswerService) {


    @Operation(summary = "Выбор всех существующих ответов")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "Ответ найден", content = [Content(mediaType = "application/json",
            array = ArraySchema(schema = Schema(implementation = Answer::class)))]),
        ApiResponse(responseCode = "404", description = "Ответ не найден", content = [Content()]),
    )
    @GetMapping
    fun getAnswers(): List<Answer>{
        return answerService.getBooks()
    }

    @GetMapping("/test")
    fun getTestString():String{
        return "Test"
    }


    @Operation(summary = "Выбор ответа по его номеру")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "Ответ найден", content = [Content(mediaType = "application/json",
            array = ArraySchema(schema = Schema(implementation = Answer::class)))]),
        ApiResponse(responseCode = "400",  description =  "Введен неверный номер", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Ответ не найден", content = [Content()]),
    )
    @GetMapping(path = ["{answerId}"])
    fun getAnswerById(@Parameter(description = "номер для поиска ответа") @PathVariable("answerId") answerId: Long): Optional<Answer> {
        return answerService.getAnswerById(answerId)
    }

//    @GetMapping(path = ["all/layer/{layerId}/org/{orgId}"])
//    fun getAllData(@PathVariable("layerId") layerId:Long,
//                   @PathVariable("orgId") orgId:Long): Object{
//        return answerService.getAllData(layerId,orgId)
//    }

    @Operation(summary = "Создание нового ответа")
    @PostMapping
    fun registerNewAnswer(@Parameter(description = "объект  для добавления ",
        schema = Schema(implementation = Answer::class))
     @RequestBody answer: Answer) {
        answerService.addNewAnswer(answer)
    }

    @Operation(summary = "Удаление существующего ответа по его номеру")
    @DeleteMapping(path = ["{answerId}"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteAnswer(@Parameter(description = "номер для поиска ответа") @PathVariable("answerId") answerId: Long?) {
        answerService.deleteAnswer(answerId!!)
    }
            
//    @PutMapping(path = ["{answerId}/mark/{markId}"])
//    fun assignMarkToAnswer(
//        @PathVariable answerId: Long,
//        @PathVariable markId: Long
//    ): Answer?{
//        return answerService.assignMarktoAnswer(answerId,markId)
//    }


//    @PutMapping(path = ["{answerId}/org/{orgId}"])
//    fun assignOrgToAnswer(
//        @PathVariable answerId: Long,
//        @PathVariable orgId: Long
//    ): Answer?{
//        return answerService.assignOrgToAnswer(answerId, orgId)
//    }
}
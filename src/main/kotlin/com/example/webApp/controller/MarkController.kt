package com.example.webApp.controller

import com.example.webApp.entity.Answer
import com.example.webApp.entity.Layer
import com.example.webApp.entity.Mark
import com.example.webApp.entity.Organization
import com.example.webApp.service.MarkService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("dm/v1/mark")
class MarkController(private var markService: MarkService) {

    @Operation(summary = "Выбор всех существующих показателей")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "Показатели найдены", content = [Content(mediaType = "application/json",
            array = ArraySchema(schema = Schema(implementation = Layer::class))
        )]),
        ApiResponse(responseCode = "404", description = "Показатели не найдены", content = [Content()]),
    )
    @GetMapping
    fun getMarks(): List<Mark> {
        return markService.getMarks()
    }

    @Operation(summary = "Выбор показателя по его номеру")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "Показатель найден", content = [Content(mediaType = "application/json",
            array = ArraySchema(schema = Schema(implementation = Answer::class)))]),
        ApiResponse(responseCode = "400",  description =  "Введен неверный номер", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Показатель не найден", content = [Content()]),)
    @GetMapping(path = ["{markId}"])
    fun getMarkById(@PathVariable("markId") markId: Long): Optional<Mark> {
        return markService.getMarkById(markId)
    }


    @Operation(summary = "Создание нового показателя")
    @PostMapping
    fun registerNewMark(@Parameter(description = "объект  для добавления ",
        schema = Schema(implementation = Answer::class))
        @RequestBody book: Mark) {
        markService.addNewMark(book)
    }

    @Operation(summary = "Удаление существующего показателя по его номеру")
    @DeleteMapping(path = ["{markId}"])
    fun deleteMark(@Parameter(description = "номер для поиска показателя")
        @PathVariable("markId") markId: Long?) {
        markService.deleteMark(markId!!)
    }

    @Operation(summary = "Изменение существующего показателя по его номеру")
    @PutMapping(path = ["{markId}"])
    fun updateMark(
        @Parameter(description = "номер для поиска показателя")
        @PathVariable("markId") markId: Long,
        @Parameter(description = "новое имя")
        @RequestParam(required = false) markName: String,
        @Parameter(description = "новое описание")
        @RequestParam(required = false) markAnnot: String
    ){
        markService.updateMark(markId,markName,markAnnot)
    }

    @Operation(summary = "Присоединение ответа к показателю")
    @PutMapping(path = ["{markId}/answer/{answerId}"])
    fun assignAnswertoOrg(
        @Parameter(description = "номер для поиска показателя")
        @PathVariable markId: Long,
        @Parameter(description = "номер для поиска ответа")
        @PathVariable answerId: Long
    ): Mark? {return markService.addAnswerToMark(markId,answerId)}
    //hi
    
}
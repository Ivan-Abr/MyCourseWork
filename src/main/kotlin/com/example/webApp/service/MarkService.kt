package com.example.webApp.service

import com.example.webApp.entity.Answer
import com.example.webApp.entity.Mark
import com.example.webApp.entity.Organization
import com.example.webApp.repository.AnswerRepo
import com.example.webApp.repository.MarkRepo
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import java.util.*

@Service
class MarkService (
    private var markRepo: MarkRepo,
    private var answerRepo: AnswerRepo
){
    fun getMarks(): List<Mark> {
        return markRepo.findAll() as List<Mark>
    }

    fun getMarkById(markId: Long): Optional<Mark> {
        var exist: Boolean = markRepo.existsById(markId)
        if (!exist)
            throw IllegalStateException("Mark with id: $markId does not exist!")
        return markRepo.findById(markId)
    }

    fun addNewMark(mark: Mark?): Mark? {
        if (mark == null) return null
        val markOptional = markRepo
            .findMarkByName(mark.markName)
        check(!markOptional!!.isPresent) { "name taken" }
        return markRepo.save(mark)
    }

    fun deleteMark(MarkId: Long) {
        val exists = markRepo.existsById(MarkId)
        if (!exists) {
            throw IllegalArgumentException("student with id" + MarkId + "does not exist")
        }
        markRepo.deleteById(MarkId)
    }

    @Transactional
    fun updateMark(MarkId: Long, name: String, annot: String): Mark? {
        val mark = markRepo.findById(MarkId)
            .orElseThrow { java.lang.IllegalStateException("student with id" + MarkId + "does not exist") }
        if (name != null && name.length > 0 && mark.markName != name) {
            mark.markName = name
        }
        mark.markAnnot = annot
        return mark
    }

    @Transactional
    fun addAnswerToMark(markId: Long, answerId: Long): Mark?{
        val mark = markRepo.findById(markId).get()
        val answer = answerRepo.findById(answerId).get()
        mark.answers = (mark.answers as MutableSet<Answer>?)?.apply { add(answer) }
        return markRepo.save(mark)
    }





}
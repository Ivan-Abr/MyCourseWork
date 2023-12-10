package com.example.webApp.service

import com.example.webApp.entity.Answer
import com.example.webApp.entity.Question
import com.example.webApp.repository.AnswerRepo
import com.example.webApp.repository.QuestionRepo
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class QuestionService (
    private var questionRepo: QuestionRepo,
    private var answerRepo: AnswerRepo
){
    fun getQuestions(): List<Question> {
        return questionRepo.findAll() as List<Question>
    }

    fun getQuestionById(questionId: Long): Optional<Question> {
        var exist: Boolean = questionRepo.existsById(questionId)
        if (!exist)
            throw IllegalStateException("Question with id: $questionId does not exist!")
        return questionRepo.findById(questionId)
    }

    fun addNewQuestion(question: Question?): Question? {
        if (question == null) return null
        val questionOptional = questionRepo
            .findQuestionByName(question.questionName)
        check(!questionOptional!!.isPresent) { "name taken" }
        return questionRepo.save(question)
    }

    fun deleteQuestion(QuestionId: Long) {
        val exists = questionRepo.existsById(QuestionId)
        if (!exists) {
            throw IllegalArgumentException("student with id" + QuestionId + "does not exist")
        }
        questionRepo.deleteById(QuestionId)
    }

    @Transactional
    fun updateQuestion(QuestionId: Long, name: String, annot: String): Question? {
        val question = questionRepo.findById(QuestionId)
            .orElseThrow { java.lang.IllegalStateException("student with id" + QuestionId + "does not exist") }
        if (name != null && name.length > 0 && question.questionName != name) {
            question.questionName = name
        }
        question.questionAnnot = annot
        return question
    }

//    @Transactional
//    fun addAnswerToQuestion(questionId: Long, answerId: Long): Question?{
//        val question = questionRepo.findById(questionId).get()
//        val answer = answerRepo.findById(answerId).get()
//        question.answers = (question.answers as MutableSet<Answer>?)?.apply { add(answer) }
//        return questionRepo.save(question)
//    }





}
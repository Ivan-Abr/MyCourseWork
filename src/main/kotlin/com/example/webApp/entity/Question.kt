package com.example.webApp.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "question")
data class Question(
    @Id
    @JsonProperty("questionId")
    @Column(name = "questionId")
    var questionId: Long,

    @JsonProperty("questionName")
    @Column(name = "questionName", length = 100)
    var questionName: String,

    @JsonProperty("questionAnnot")
    @Column(name = "questionAnnot", length = 300)
    var questionAnnot: String,

    @ManyToOne
//    @JsonIgnore
    @JoinColumn(name = "layerId")
    var layer: Layer?,

    @ManyToOne
//    @JsonIgnore
    @JoinColumn(name = "factorId")
    var factor: Factor?,

    @OneToMany
//    @JsonIgnore
    var marks: Set<Mark>?
    )
{
//    @get:JsonProperty("layerId")
//    val layerId: Long?
//            get(){ return this.layer?.layerId }
//
//    @get:JsonProperty("factorId")
//    val factorId: Long?
//    get(){ return this.factor?.factorId }
//
//
//    @get:JsonProperty("marksIds")
//    @set:JsonProperty("marksIds")
//    var marksIds: List<Long?>?
//    get(){
//        return this.marks?.map { mark -> mark?.markId } ?: emptyList()
//    } set(value) {}



    override fun toString(): String {
        return "Question(questionId=$questionId, questionName='$questionName', questionAnnot='$questionAnnot'"}

}




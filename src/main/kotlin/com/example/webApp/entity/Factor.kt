package com.example.webApp.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "factor")
class Factor(
    @Id
    @JsonProperty("factorId")
    @Column(name = "factorId")
    var factorId: Long,

    @OneToMany(mappedBy="factor")
    @JsonIgnore
    var questions:Set<Question?>? = HashSet(),

    @JsonProperty("factorName")
    @Column(name = "factorName")
    var factorName:String,

    @JsonProperty("factorShortName")
    @Column(name = "factorShortName")
    var factorShortName: String

) {

    @get:JsonProperty("questionsIds")
    @set:JsonProperty("questionsIds")
    var questionsIds: List<Long?>?
        get() { return this.questions?.map { it?.questionId } ?: emptyList() }
        set(value) {}

    override fun toString(): String {
        return "Factor(factorId=$factorId, questions=$questions, factorName='$factorName', factorShortName='$factorShortName', " +
                "questionsIds = '$questionsIds')"
    }
}
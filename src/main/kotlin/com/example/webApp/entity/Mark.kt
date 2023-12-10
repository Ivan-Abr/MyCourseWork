package com.example.webApp.entity

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import jakarta.persistence.*
import kotlin.jvm.Transient

@Entity
@Table(name = "mark")
public class Mark(
    @Id
    @JsonProperty("mark_id")
    @Column(name = "mark_id")
    var markId: Long = 0L,

    @ManyToOne
    @JoinColumn(name = "layer_id")
    var layer: Layer? = null,

    @OneToMany(mappedBy = "mark")
    @JsonIgnore
    var answers: Set<Answer>? = HashSet(),

    @JsonProperty("mark_name")
    @Column(name = "mark_name", length = 100)
    var markName: String = "",

    @JsonProperty("mark_annot")
    @Column(name = "annot", length = 300)
    var markAnnot: String = "",

    @JsonProperty("mark_value")
    @Column(name = "value")
    var markValue: Int = 0
) {
    @get:JsonProperty("answers")
    val answersIds: List<Long>?
        get() {
            return this.answers?.map { answer -> answer.answerId }
        };

    override fun toString(): String {
        return "Mark(markId=$markId, layer=$layer, markName='$markName', markAnnot='$markAnnot', markValue=$markValue)"
    }
}

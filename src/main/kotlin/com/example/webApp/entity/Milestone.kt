package com.example.webApp.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.Year
import java.util.Date


@Entity
@Table(name = "milestone")
data class Milestone (
    @Id
    @JsonProperty("milestoneId")
    @Column(name = "milestoneId")
    var milestoneId: Long = 0L,

    @OneToMany(mappedBy = "milestone")
    @JsonIgnore
    var answers: Set<Answer?>? = HashSet(),

    @JsonProperty("dateFrom")
    @Column(name = "dateFrom")
    var dateFrom: LocalDate,

    @JsonProperty("dateTo")
    @Column(name = "dateTo")
    var dateTo: LocalDate,

    @JsonProperty("year")
    @Column(name = "year")
    var year: String

){
    override fun toString(): String {
        return "Milestone(milestoneId=$milestoneId, dateFrom=$dateFrom, dateTo=$dateTo, year=$year)"
    }
}
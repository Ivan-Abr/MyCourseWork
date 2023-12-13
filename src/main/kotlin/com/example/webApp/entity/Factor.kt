package com.example.webApp.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "factor")
class Factor(
    @Id
    @JsonProperty("factor_id")
    @Column(name = "factor_id")
    var factorId: Long,


    @OneToMany(mappedBy="factor")
    @JsonIgnore
    var layers:Set<Layer?>? = HashSet(),

    @JsonProperty("factor_name")
    @Column(name = "factor_name")
    var factorName: String,


) {
}
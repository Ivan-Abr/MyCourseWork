package com.example.webApp.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*


@Entity
@Table(name = "layer")
data class Layer(
    @Id
    @JsonProperty("layerId")
    @Column(name = "layerId")
    var layerId: Long = 0L,

    @OneToMany(mappedBy="layer")
    @JsonIgnore
    var questions:Set<Question?>? = HashSet(),

    @JsonProperty("layerName")
    @Column(name = "layerName", length = 100)
    var layerName: String)
{
    @get:JsonProperty("questionsIds")
    @set:JsonProperty("questionsIds")
    var questionsIds: List<Long?>?
        get() { return this.questions?.map { it?.questionId } ?: emptyList() }
        set(value) {}

    override fun toString(): String {
        return "Layer(layerId=$layerId, layerName='$layerName', questionsIds = '$questionsIds')" }
}
package com.example.webApp.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*


@Entity
@Table(name = "layer")
data class Layer(
    @Id
    @JsonProperty("layer_id")
    @Column(name = "layer_id")
    var layerId: Long = 0L,

    @OneToMany(mappedBy="layer")
    var questions:Set<Question?>? = HashSet(),

    @JsonProperty("layer_name")
    @Column(name = "layer_name", length = 100)
    var layerName: String

    ) {
    override fun toString(): String {
        return "Layer(layerId=$layerId, marks=$questions, layerName='$layerName')"
    }
}
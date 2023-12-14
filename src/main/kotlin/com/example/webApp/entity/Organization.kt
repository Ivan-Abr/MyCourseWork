package com.example.webApp.entity

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "organization")
data class Organization(
    @Id
    @JsonProperty("org_id")
    @Column(name = "org_id")
    var orgId: Long = 0L,

    @OneToMany(mappedBy="organization")
    var answers:Set<Answer?>? = HashSet(),

    @JsonProperty("org_name")
    @Column(name = "org_name", length = 100)
    var orgName: String = "",

    @JsonProperty("org_annot")
    @Column(name = "org_annot", length = 200)
    var orgAnnot: String = "",

    @JsonProperty("org_contacts")
    @Column(name = "org_contacts", length = 200)
    var orgContacts:String = ""
){
    override fun toString(): String {
        return "Organization(orgId=$orgId, orgName='$orgName', orgAnnot='$orgAnnot', orgContacts='$orgContacts')"
    }
}

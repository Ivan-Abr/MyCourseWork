package com.example.webApp.repository

import com.example.webApp.entity.Answer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AnswerRepo: JpaRepository<Answer, Long> {
    @Query(
        "SELECT  avg(a.mark.markValue), l.layerName, org.orgName, mlst.year  from Answer AS a " +
                "   LEFT JOIN Mark AS m ON a.mark.markId = m.markId" +
                "   LEFT JOIN Layer AS l ON m.layer.layerId = l.layerId" +
                "   LEFT JOIN Organization as org On a.organization.orgId = org.orgId" +
                "   LEFT JOIN Milestone AS mlst ON a.milestone.milestoneId = mlst.milestoneId" +
                "   WHERE l.layerId = ?1 and org.orgId = ?2" +
                "   GROUP BY l.layerName, org.orgName, mlst.year")
    fun getAllByAnswer(layerId: Long, orgId: Long): Object
}
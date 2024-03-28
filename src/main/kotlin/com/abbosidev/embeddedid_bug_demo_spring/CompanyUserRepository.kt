package com.abbosidev.embeddedid_bug_demo_spring

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CompanyUserRepository : JpaRepository<CompanyUser, CompanyUserKey> {

    @Query("select cu from company_users cu where cu.id.company.id = ?1 and cu.id.user.id = ?2", nativeQuery = true)
    fun getCompanyUserByCompanyIdAndUserId(companyId: Long, userId: Long): CompanyUser

}
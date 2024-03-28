package com.abbosidev.embeddedid_bug_demo_spring

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.io.Serializable

@Entity
@Table(name = "company_users")
class CompanyUser() {

    constructor(company: Company, user: User) : this() {
        id = CompanyUserKey(company, user)
    }

    @EmbeddedId
    lateinit var id: CompanyUserKey

}

@Embeddable
open class CompanyUserKey() : Serializable {

    constructor(company: Company, user: User) : this() {
        this.company = company
        this.user = user
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    lateinit var company: Company

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    lateinit var user: User

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CompanyUserKey

        if (company != other.company) return false
        if (user != other.user) return false

        return true
    }

    override fun hashCode(): Int {
        var result = company.hashCode()
        result = 31 * result + user.hashCode()
        return result
    }
}
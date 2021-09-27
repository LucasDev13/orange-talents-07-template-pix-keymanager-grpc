package br.com.project.pix.registra

import br.com.project.AccountType
import br.com.project.KeyType
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(uniqueConstraints =[UniqueConstraint(name = "uk_key_pix",
columnNames = ["key"])])
class KeyPix(
    @field:NotNull
    @field:Column(nullable = false)
    val clientId: UUID,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val type: KeyType,

    @field:NotBlank
    @Column(unique = true, nullable = false)
    val key: String,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val accountType: AccountType,

    @field:Valid
    @Embedded
    val account: AssociatedAccount
) {

    @Id
    @GeneratedValue
    var id: UUID? = null

    @Column(nullable = false)
    val createdIn: LocalDateTime = LocalDateTime.now()

    override fun toString(): String {
        return "KeyPix(clientId=$clientId, type=$type, key='$key', accountType=$accountType, account=$account, id=$id, createdIn=$createdIn)"
    }


}

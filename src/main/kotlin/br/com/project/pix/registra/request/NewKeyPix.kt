package br.com.project.pix.registra.request

import br.com.project.AccountType
import br.com.project.KeyType
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * DTO
 */

//@ValidPixKey
@Introspected
data class NewKeyPix(
//    @ValidUUID
    @field:NotBlank
    val clientId: String?,
    @field:NotNull
    val type: KeyType?,
    @field:Size(max = 77)
    val key: String?,
    @field:NotNull
    val accountType: AccountType?
) {
//    fun toModel(account: AssociatedAccount): KeyPix{
//        return KeyPix(
//            clientId = UUID.fromString(this.clientId),
//            type = KeyType.valueOf(this.type!!.name),
//            key = if(this.type == KeyType.RANDOM) UUID.randomUUID().toString() else this.key!!,
//            accountType = AccountType.valueOf(this.accountType!!.name),
//            account = account
//        )
//    }
}
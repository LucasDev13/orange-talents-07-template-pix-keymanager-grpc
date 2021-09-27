package br.com.project.pix.registra

import br.com.project.integration.ItauClientAccounts
import io.micronaut.validation.Validated
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Singleton
class NewKeyPixService(
    @Inject val repository: KeyPixRespository,
    @Inject val itauClient: ItauClientAccounts
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    //    @Transactional
    fun register(@Valid newKey: NewKeyPix): KeyPix {

        // Verifica se a chave já existe no sistema]
        if (repository.existsByKey(newKey.key))
            throw PixKeyExistingException("Chave Pix '${newKey.key}' existente")

        // Busca dados da conta no ERP do ITAU
        val response = itauClient.searchAccountsByType(newKey.clientId!!, newKey.accountType!!.name)
        val account = response.body()?.toModel() ?: throw IllegalStateException("Cliente não encontrado no Itau")

        //Grava no banco de dados
        val key = newKey.toModel(account)
        repository.save(account)
        //return

        return key

    }

}

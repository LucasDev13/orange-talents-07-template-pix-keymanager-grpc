package br.com.project.pix.registra

import br.com.project.AccountType
import br.com.project.KeyType

fun RegisterKeyPixRequest.toModel(): NewKeyPix {
    return NewKeyPix(
        clientId = clientId,
        type = when (typeKey){
            UNKNOWN_KEY_TYPE -> null
            else -> KeyType.valueOf(keyType.name)
        },
        key = key,
        accountType = when (accountType){
            UNKNOWN_ACCOUNT_TYPE -> null
            else -> AccountType.valueOf(accountType.name)
        }
    )
}
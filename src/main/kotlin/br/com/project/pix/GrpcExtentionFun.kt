package br.com.project.pix

import br.com.project.AccountType
import br.com.project.KeyType
import br.com.project.PixGrpcRequest
import br.com.project.pix.registra.request.NewKeyPix

fun PixGrpcRequest.toModel(): NewKeyPix {
    return NewKeyPix(
        clientId = clientId,
        type = when (keyType) {
            KeyType.UNKNOWN_KEY_TYPE -> null
            else -> KeyType.valueOf(keyType.name)
        },
        key = key,
        accountType = when(accountType){
            AccountType.UNKNOWN_ACCOUNT_TYPE -> null
            else -> AccountType.valueOf(accountType.name)
        }
    )
}
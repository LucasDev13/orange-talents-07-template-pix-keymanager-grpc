package br.com.project.integration

import br.com.project.pix.registra.DataAccountsResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.QueryValue
import java.net.http.HttpResponse

//@Client("\${itau.contas.url}")
interface ItauClientAccounts {

    @Get("/api/v1/clientes/{clientId}/contas{?type}")
    fun searchAccountsByType(@PathVariable clientId: String, @QueryValue type: String): HttpResponse<DataAccountsResponse>
}
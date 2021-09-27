package br.com.project.pix.registra

data class DataAccountsResponse(
    val type: String,
    val institution: InstitutionResponse,
    val agency: String,
    val number: String,
    val holder: HolderResponse
) {

    fun toModel(): AssociatedAccount{
        return AssociatedAccount(
            institution = this.institution.name,
            holderName = this.holder.name,
            cpfHolder = this.holder.cpf,
            agency = this.agency,
            accountNumber = this.number
        )
    }
}

data class HolderResponse(val name: String, val cpf: String)
data class InstitutionResponse(val name: String, val ispb: String)

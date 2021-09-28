package br.com.project.validation

import br.com.project.pix.registra.request.NewKeyPix
import jakarta.inject.Singleton
import javax.validation.*
import kotlin.reflect.KClass

@MustBeDocumented
@kotlin.annotation.Target
@ReportAsSingleViolation
@Constraint(validatedBy = [ValidPixKeyValidator::class])
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ValidPixKey(
    val message: String = "Chave pix inválida (\${validatedValue.type})",
    val group: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []
)

@Singleton
class ValidPixKeyValidator: ConstraintValidator<ValidPixKey, NewKeyPix>{
    override fun isValid(
        value: NewKeyPix?,
        context: ConstraintValidatorContext?
    ): Boolean {
        if(value?.type == null){
            return false
        }
//        return value.type.valid(value.key)
        return true
    }

}
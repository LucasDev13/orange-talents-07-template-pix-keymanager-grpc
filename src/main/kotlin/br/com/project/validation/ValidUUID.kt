package br.com.project.validation

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target
import javax.validation.Constraint
import javax.validation.Payload
import javax.validation.ReportAsSingleViolation
import javax.validation.constraints.Pattern
import kotlin.reflect.KClass

@ReportAsSingleViolation
@Constraint(validatedBy = [])
@Pattern(
    regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$",
    flags = [Pattern.Flag.CASE_INSENSITIVE]
)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD, ElementType.CONSTRUCTOR)
annotation class ValidUUID(
    val message: String = "Não é um formato válido de UUID",
    val group: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []
)

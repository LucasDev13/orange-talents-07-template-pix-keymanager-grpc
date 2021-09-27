package br.com.project.pix.enum

import io.micronaut.validation.validator.constraints.*

enum class KeyType {
    CPF {
        override fun valid(key: String?): Boolean {
            if(key.isNullOrBlank()){
                return false
            }
            if(!key.matches("[0-9]+".toRegex())){
                return false
            }
            return CPFValidator().run {
                initialize(null)
                isValid(key, null)
            }
        }
    },
    CELLPHONE {
        override fun valid(key: String?): Boolean {
            if(key.isNullOrBlank()){
                return false
            }
            return key.matches("^\\+[1-9][0-9]\\d{1,14}\$".toRegex())
        }
    },
    EMAIL {
        override fun valid(key: String?): Boolean {
            if (key.isNullOrBlank()){
                return false
            }
            return EmailValidator().run {
                initialize(null)
                isValid(key, null)
            }
        }
    },
    RANDOM {
        override fun valid(key: String?) = key.isNullOrBlank()
    };

    abstract fun valid(key: String?): Boolean
}
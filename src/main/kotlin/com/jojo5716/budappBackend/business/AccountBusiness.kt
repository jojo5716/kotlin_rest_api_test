package com.jojo5716.budappBackend.business

import com.jojo5716.budappBackend.dao.AccountRepository
import com.jojo5716.budappBackend.exceptions.BusinessException
import com.jojo5716.budappBackend.exceptions.NotFoundException
import com.jojo5716.budappBackend.model.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*
import kotlin.jvm.Throws

@Service
class AccountBusiness : AccountBusinessInterface {
    // Inyeccion de dependencias, hace que el framework se ocupe de cargar todos los metodos
    @Autowired
    val accountRepository: AccountRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Account> {
        try {
            return accountRepository!!.findAll()
        } catch (error: Exception) {
            throw BusinessException(error.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(accountId: Long): Account {
        val optional: Optional<Account>

        try {
            optional = accountRepository!!.findById(accountId)
        } catch (error: Exception) {
            throw BusinessException(error.message)
        }

        if (!optional.isPresent) {
            throw NotFoundException("Account not found")
        }

        return optional.get()
    }

    @Throws(BusinessException::class)
    override fun save(account: Account): Account {
        try {
            return accountRepository!!.save(account)
        } catch (error: Exception) {
            throw BusinessException(error.message)
        }
    }

    @Throws(BusinessException::class)
    override fun remove(accountId: Long) {
        val optional: Optional<Account>

        try {
            optional = accountRepository!!.findById(accountId)
        } catch (error: Exception) {
            throw BusinessException(error.message)
        }

        if (!optional.isPresent) {
            throw NotFoundException("Account not found")
        } else {
            try {
                accountRepository!!.deleteById(accountId)
            } catch (error: Exception) {
                throw BusinessException(error.message)
            }
        }
    }
}

package com.jojo5716.budappBackend.web

import com.jojo5716.budappBackend.business.AccountBusinessInterface
import com.jojo5716.budappBackend.exceptions.BusinessException
import com.jojo5716.budappBackend.exceptions.NotFoundException
import com.jojo5716.budappBackend.model.Account
import com.jojo5716.budappBackend.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping(Constants.URL_BASE_ACCOUNTS)
class AccountRestController {
    @Autowired
    val accountBusiness: AccountBusinessInterface? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Account>> {
        return try {
            ResponseEntity(accountBusiness!!.list(), HttpStatus.OK)
        } catch (error: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") accountId: Long): ResponseEntity<Account> {
        return try {
            ResponseEntity(accountBusiness!!.load(accountId), HttpStatus.OK)
        } catch (error: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (error: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody account: Account): ResponseEntity<Any> {
        return try {
            accountBusiness!!.save(account)

            val responseHeader = HttpHeaders()
            responseHeader.set("location", Constants.URL_BASE_ACCOUNTS + "/" + account.id)

            ResponseEntity(responseHeader, HttpStatus.CREATED)
        } catch (error: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody account: Account): ResponseEntity<Any> {
        return try {
            accountBusiness!!.save(account)

            ResponseEntity(HttpStatus.OK)
        } catch (error: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (error: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") accountId: Long): ResponseEntity<Any> {
        return try {
            accountBusiness!!.remove(accountId)

            ResponseEntity(HttpStatus.OK)
        } catch (error: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}

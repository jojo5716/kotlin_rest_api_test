package com.jojo5716.budappBackend.business

import com.jojo5716.budappBackend.model.Account

interface AccountBusinessInterface {
    fun list(): List<Account>
    fun load(accountId: Long): Account
    fun save(account: Account): Account
    fun remove(accountId: Long)
}

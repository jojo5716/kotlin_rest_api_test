package com.jojo5716.budappBackend.dao

import com.jojo5716.budappBackend.model.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long>

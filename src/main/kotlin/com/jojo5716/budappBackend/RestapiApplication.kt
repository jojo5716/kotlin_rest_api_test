package com.jojo5716.budappBackend

import com.jojo5716.budappBackend.dao.AccountRepository
import com.jojo5716.budappBackend.model.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.format.DateTimeFormatter

@SpringBootApplication
class RestapiApplication:CommandLineRunner {
	@Autowired
	val accountRepository: AccountRepository? = null

	override fun run(vararg args: String?) {
		val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
		val account1 = Account(name = "Account 1")

		accountRepository!!.save(account1)
	}
}

fun main(args: Array<String>) {
	runApplication<RestapiApplication>(*args)
}

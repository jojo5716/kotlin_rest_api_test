package com.jojo5716.budappBackend.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name="salary")
data class Salary (val amount:Float, val paymentDate:Date){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long = 0
}
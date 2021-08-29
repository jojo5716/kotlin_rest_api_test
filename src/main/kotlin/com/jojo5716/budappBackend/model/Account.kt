package com.jojo5716.budappBackend.model

import javax.persistence.*

@Entity
@Table( name="account")
data class Account (val name:String){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0
}

package com.example.myapplication.models

enum class Gender {
    MALE,
    FEMALE
}

class Passenger(name: String, nationalCode: String, gender: Gender, birthDate: String) {
    var name: String
    var nationalCode: String
    var gender: Gender
    var birthDate: String

    init {
        this.name = name
        this.nationalCode = nationalCode
        this.gender = gender
        this.birthDate = birthDate
    }
}

package com.example.rendez

import java.util.*

data class RendezVous (
    var idRv: String = UUID.randomUUID().toString(),
    var lieuRv: String = "",
    var description: String = "",
    var date: Date = Date()
        )
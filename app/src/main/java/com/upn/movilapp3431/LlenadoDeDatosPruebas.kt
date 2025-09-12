package com.upn.movilapp3431

import com.upn.movilapp3431.entities.Contact
import com.upn.movilapp3431.entities.Series

class LlenadoDeDatosPruebas {

    fun getSeries(): List<Series> {

//                val contact = Contact("2", "Juana Perez", "123456789", "2024-06-10")
//                val record = myRef.child("contacts").push()
//                contact.id = record.key.toString()
//                record.setValue(contact)
        return listOf(
            Series("1", "Breaking Bad", "62"),
            Series("2", "Stranger Things", "34"),
            Series("3", "The Office", "201"),
            Series("4", "Dark", "26"),
            Series("5", "Friends", "236")
        )
    }
}
package com.example.levelup

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {

    @Insert
   suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("Select * from contacts")
    fun getContacts() : LiveData<List<Contact>>

    @Query("Select * from contacts where id = :id")
    suspend fun findContactById(id:Int) : Contact
}
package com.example.todolist

import android.content.ContentValues
import android.content.Context

class DataBaseOps(context: Context) {

    private val dbHelper = SQLiteDataBase(context)

    fun addData(ToDoItems: ToDoItems): Long {
        val dbWrite = dbHelper.writableDatabase
        val valuesWrite = ContentValues().apply {
            put(SQLiteDataBase.TABLE_NAME,  ToDoItems.toDoId)
        }
        try {
            return dbWrite.insert(SQLiteDataBase.TABLE_NAME, null, valuesWrite)
        } catch (e: Exception) {
            println("Adding Data Failed \n $e")
        } finally {
            dbWrite.close()
        }
        return dbWrite.lastInsertRowId // this will need to be changed
    }

//    fun getData(ToDoItems: ToDoItems): Long {
//        val dbList = mutableListOf<ToDoItems>()
//        val dbRead = dbHelper.readableDatabase
//        dbRead.query(TABLE_NAME, )
//
//        }
//    }
}
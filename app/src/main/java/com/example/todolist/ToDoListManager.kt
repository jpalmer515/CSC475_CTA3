package com.example.todolist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import java.time.Instant
import java.util.Date

object ToDoListManager {

    private val toDoListData = mutableStateListOf<ToDoItems>()

    fun getAllToDoList() : List<ToDoItems>{
        return toDoListData
    }

    fun addToDoItem(title: String) {
        toDoListData.add(ToDoItems(System.currentTimeMillis().toInt(),title, Date.from(Instant.now()), checkedState = false))
    }

    fun checkToDoItem(id: Int) {
        toDoListData.find { it.toDoId==id }?.let { it.checkedState = !it.checkedState }
    }

    fun deleteToDoItem(id: Int) {
        toDoListData.removeIf{ it.toDoId==id }
    }

}
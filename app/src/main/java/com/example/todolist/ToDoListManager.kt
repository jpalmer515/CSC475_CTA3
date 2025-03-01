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

    fun checkToDoItem(index: Int) {
        toDoListData[index] = toDoListData[index].copy(checkedState = !toDoListData[index].checkedState)
    }

    fun deleteToDoItem(index: Int) {
        toDoListData.removeAt(index)
    }

}
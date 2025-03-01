package com.example.todolist

import androidx.compose.runtime.MutableState
import java.time.Instant
import java.util.Date

data class ToDoItems(
    var toDoId: Int,
    var toDoTitle: String,
    var createdTime: Date,
    var checkedState: Boolean,
)

//fun TestToDoList(): List<ToDoItems> {
//    return listOf<ToDoItems>(
//        ToDoItems(1, "Test One", Date.from(Instant.now())),
//        ToDoItems(2, "Test Two", Date.from(Instant.now())),
//        ToDoItems(3, "Third Item To Do", Date.from(Instant.now())),
//        ToDoItems(4, "A Fourth Item", Date.from(Instant.now())),
//        ToDoItems(5, "A really long, fifth, title", Date.from(Instant.now()))
//    );
//}
package com.example.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToDoListView : ViewModel() {

    private var toDoListData = MutableLiveData<List<ToDoItems>>()
    val listData : LiveData<List<ToDoItems>> = toDoListData

    init {
        getAllToDoList()
    }

    fun getAllToDoList(){
        toDoListData.value = ToDoListManager.getAllToDoList()
    }

    fun addToDoItem(title: String) {
        ToDoListManager.addToDoItem(title)
        getAllToDoList()
    }

    fun checkToDoItem(id: Int) {
        ToDoListManager.checkToDoItem(id)
        getAllToDoList()
    }

    fun deleteToDoItem(id: Int) {
        ToDoListManager.deleteToDoItem(id)
        getAllToDoList()
    }
}
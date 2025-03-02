package com.example.todolist

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.ui.theme.ToDoListTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toDoListViewModel = ViewModelProvider(this)[ToDoListView::class.java]

//        val dbManager = DataBaseOps(this)
//        val newRowId = dbManager.addData(
//            ToDoItems = TODO()
//        )

        enableEdgeToEdge()
        setContent {
            ToDoListTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)) {
                        ToDoList(toDoListViewModel)
                    }
                }
            }
        }
    }
}

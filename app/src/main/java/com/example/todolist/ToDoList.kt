package com.example.todolist

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.viewModelFactory
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun ToDoList(viewModel : ToDoListView) {

    val firstToDoTest by viewModel.listData.observeAsState()
    var userInputText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(value = userInputText, onValueChange = { userInputText = it })
            Button(onClick = {
                viewModel.addToDoItem(userInputText)
                userInputText = ""
            }) {
                Text(text = "Add")
            }
        }
        firstToDoTest?.let {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                userScrollEnabled = true,
                content = {
                    itemsIndexed(it) {index: Int, item: ToDoItems ->
                        ToDoObjects(
                            toDoEntry = item,
                            onDelete = { viewModel.deleteToDoItem(index) },
                            onClick = { viewModel.checkToDoItem(index) },
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun ToDoObjects(toDoEntry: ToDoItems, onDelete : ()-> Unit, onClick : ()-> Unit ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(8.dp)
            .toggleable(
                value = toDoEntry.checkedState,
                onValueChange = { onClick() },
                role = Role.Checkbox,
            )
    ) {
        Checkbox(
            modifier = Modifier
                .padding(8.dp),
            checked = toDoEntry.checkedState,
            onCheckedChange = null,
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = SimpleDateFormat("HH:mm:ss, dd MMM yyyy", Locale.ENGLISH).format(toDoEntry.createdTime))
            Text(text = toDoEntry.toDoTitle)
        }
        IconButton(onClick = onDelete) {
            Icon(painter = painterResource(id = R.drawable.baseline_delete_24), contentDescription = "Delete")
        }
    }
}
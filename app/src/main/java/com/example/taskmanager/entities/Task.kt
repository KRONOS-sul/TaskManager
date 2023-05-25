package com.example.taskmanager.entities

import java.io.Serializable

data class Task(
    val title: String? = null,
    val description: String? = null
) : Serializable
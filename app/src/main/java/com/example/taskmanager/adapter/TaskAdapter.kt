package com.example.taskmanager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.databinding.ItemTaskBinding
import com.example.taskmanager.entities.Task

class TaskAdapter(
    private val arrayList: ArrayList<Task>
) : RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.onBind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

}

class TaskViewHolder(private val binding: ItemTaskBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(task: Task) {
        binding.tvTitle.text = task.title
        binding.tvDescription.text = task.description
    }

}
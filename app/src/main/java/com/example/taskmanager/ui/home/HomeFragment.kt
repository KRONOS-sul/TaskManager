package com.example.taskmanager.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.taskmanager.R
import com.example.taskmanager.adapter.TaskAdapter
import com.example.taskmanager.databinding.FragmentHomeBinding
import com.example.taskmanager.entities.Task
import com.example.taskmanager.ui.task.TaskFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val taskList = ArrayList<Task>()
    private var adapter: TaskAdapter = TaskAdapter(taskList)

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.recyclerView.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener(TaskFragment.RESULT_REQUEST) { _, bundle ->
            val data: Task = bundle.getSerializable(TaskFragment.RESULT_KEY) as Task
            taskList.add(data)
            Log.e("SHAMAL", "onViewCreated: $data")
        }
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
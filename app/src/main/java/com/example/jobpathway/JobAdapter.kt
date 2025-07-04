package com.example.jobpathway

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jobpathway.databinding.JobItemBinding

class JobAdapter(private val jobList: List<Job>) : RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    class JobViewHolder(private val binding: JobItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(job: Job) {
            binding.jobTitle.text = job.title
            binding.jobCompany.text = job.company
            binding.jobLocation.text = job.location
            binding.jobSalary.text = job.salary
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val binding = JobItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JobViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobList[position]
        holder.bind(job)
    }

    override fun getItemCount() = jobList.size
}
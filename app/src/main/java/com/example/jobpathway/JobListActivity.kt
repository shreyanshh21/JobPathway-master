package com.example.jobpathway

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.jobpathway.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.File
import java.io.IOException

class JobListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.userProfile.setOnClickListener {
            startActivity(Intent(this, MyProfile::class.java))
        }

        val jobList = readJobsFromFile()

        binding.jobRecyclerView.adapter = JobAdapter(jobList)
    }

    private fun readJobsFromFile(): List<Job> {
        val jobList = mutableListOf<Job>()
        try {
            val file = File(getExternalFilesDir(null), "jobs.txt")
            if (file.exists()) {
                val reader = BufferedReader(file.reader())
                reader.forEachLine { line ->
                    val parts = line.split(", ").map { it.substringAfter(": ") }
                    if (parts.size == 4) {
                        val job = Job(
                            title = parts[0],
                            company = parts[1],
                            location = parts[2],
                            salary = parts[3]
                        )
                        jobList.add(job)
                    } else {
                        Log.w("File", "Skipping malformed line: $line")
                    }
                }
                reader.close()
            }
            else {
                try {
                    file.createNewFile()
                    val outputStream = file.outputStream()
                    val defaultData = """
                        
                            JobTitle: Frontend Developer, Company: PixelWave, Location: Hyderabad, Salary: ₹9,00,000
                            JobTitle: Backend Engineer, Company: CodeBase, Location: Pune, Salary: ₹10,50,000
                            JobTitle: Machine Learning Engineer, Company: BrainTech, Location: Bangalore, Salary: ₹13,00,000
                            JobTitle: DevOps Engineer, Company: CloudSphere, Location: Chennai, Salary: ₹11,00,000
                            JobTitle: Full Stack Developer, Company: NexaSoft, Location: Noida, Salary: ₹10,80,000
                            JobTitle: Cybersecurity Analyst, Company: SecureNet, Location: Gurgaon, Salary: ₹9,50,000
                            JobTitle: Android Developer, Company: Appify, Location: Jaipur, Salary: ₹8,75,000
                            JobTitle: UI/UX Designer, Company: DesignGenie, Location: Ahmedabad, Salary: ₹7,50,000
                            JobTitle: Database Administrator, Company: DataKeepers, Location: Kolkata, Salary: ₹9,20,000
                            JobTitle: Software Tester, Company: QualityCode, Location: Chandigarh, Salary: ₹7,80,000
                            JobTitle: iOS Developer, Company: SwiftLogic, Location: Bangalore, Salary: ₹9,60,000
                            JobTitle: Systems Analyst, Company: TechEdge, Location: Mumbai, Salary: ₹8,90,000
                            JobTitle: Blockchain Developer, Company: ChainNova, Location: Hyderabad, Salary: ₹14,00,000
                            JobTitle: Cloud Engineer, Company: SkyStack, Location: Pune, Salary: ₹11,20,000
                            JobTitle: AI Researcher, Company: DeepLearn, Location: Delhi, Salary: ₹15,00,000
                            JobTitle: Business Analyst, Company: BizVision, Location: Gurgaon, Salary: ₹8,70,000
                            JobTitle: Network Engineer, Company: NetCore, Location: Chennai, Salary: ₹9,10,000
                            JobTitle: Game Developer, Company: GameCraft, Location: Bangalore, Salary: ₹10,30,000
                            JobTitle: QA Engineer, Company: TestSuite, Location: Ahmedabad, Salary: ₹8,20,000
                            JobTitle: Web Developer, Company: WebWave, Location: Jaipur, Salary: ₹7,90,000
                            JobTitle: Embedded Systems Engineer, Company: MicroEmbed, Location: Noida, Salary: ₹10,60,000
                            JobTitle: AR/VR Developer, Company: ImmersiTech, Location: Mumbai, Salary: ₹12,50,000
                            JobTitle: Technical Writer, Company: DocuTech, Location: Kolkata, Salary: ₹6,80,000
                            JobTitle: Data Engineer, Company: PipeData, Location: Pune, Salary: ₹11,70,000
                            JobTitle: Robotics Engineer, Company: RoboWorks, Location: Chennai, Salary: ₹13,00,000
                            JobTitle: CRM Developer, Company: ClientConnect, Location: Delhi, Salary: ₹9,40,000
                            JobTitle: SAP Consultant, Company: ERPLogic, Location: Hyderabad, Salary: ₹12,80,000
                            JobTitle: Site Reliability Engineer, Company: UptimeTech, Location: Bangalore, Salary: ₹11,90,000
                            JobTitle: NLP Engineer, Company: LangAI, Location: Gurgaon, Salary: ₹13,50,000
                            JobTitle: Tech Support Engineer, Company: HelpWise, Location: Chandigarh, Salary: ₹6,50,000


                            """.trimIndent()

                    outputStream.write(defaultData.toByteArray())
                    outputStream.close()

                    val reader = BufferedReader(file.reader())
                    reader.forEachLine { line ->
                        Log.d("File", "Read line (default): $line")
                        val parts = line.split(", ").map { it.substringAfter(": ") }
                        Log.d("File", "Parsed parts (default): $parts")
                        if (parts.size == 4) {
                            val job = Job(
                                title = parts[0],
                                company = parts[1],
                                location = parts[2],
                                salary = parts[3]
                            )
                            Log.d("File", "Created Job (default): $job")
                            jobList.add(job)
                        } else {
                            Log.w("File", "Skipping malformed line (default): $line")
                        }
                    }
                    reader.close()

                }catch (e: IOException){
                    Log.e("File", "Error creating jobs.txt: ${e.message}", e)
                }
            }
        } catch (e: IOException) {
            Log.e("File", "Error reading jobs from file: ${e.message}", e)
        }
        Log.d("File", "Returning job list: $jobList") // Log the final job list
        return jobList
    }
}
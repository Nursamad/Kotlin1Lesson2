package com.example.kotlin1lesson2.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin1lesson2.databinding.ActivityMainBinding
import com.example.kotlin1lesson2.extansions.load
import com.example.kotlin1lesson2.extansions.showToast
import com.example.kotlin1lesson2.extansions.visible
import com.example.kotlin1lesson2.models.Member

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val members = arrayListOf<Member>()
    var urlW = arrayOf("Fa", "d", "sms")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillMembers()
        displayContact()
        showToast("Error connection")

        binding.ivAvatar.visible = true

        binding.ivAvatar.load("https://cdn.pixabay.com/photo/2017/08/02/01/02/wooden-2569336__340.jpg")
    }

    private fun displayContact() {

        for ((index, member) in members.withIndex()) {
            if (index == 1) {
                member.name?.let { showToast(it) }
                break
            }
        }

        for (index in 0 until members.size) {
            members[index]
        }

        members.forEach { member ->
            if (member.name.equals("Nursamad")) {
                showToast("Success")
            }
        }
        members.forEachIndexed { position, member ->
            if (position == 1) {
                member.name?.let { showToast(it) }
            }
        }
    }

    private fun fillMembers() {
        members.add(Member("Nursamad", "0505260420"))
        members.add(Member("Nursamad"))
        members.add(Member(phone = "0505260420"))
        members.add(Member())
    }

    class MainAdapter {
        private var name = "Nur"

        inner class ViewHolder {
            private fun onBind() {
                name = "Test"
            }
        }
    }
}
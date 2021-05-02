package com.example.mynews2.ui.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mynews2.R


class NotificationFragment : Fragment() {

    /*
    this fragment is used to show the notification
     */
    private lateinit var notificationViewModel: NotificationViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationViewModel = ViewModelProvider(this).get(NotificationViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notification, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
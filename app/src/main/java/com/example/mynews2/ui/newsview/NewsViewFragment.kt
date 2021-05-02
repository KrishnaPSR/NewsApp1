package com.example.mynews2.ui.newsview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynews2.R
import com.example.mynews2.adapter.SaveAdapter
import com.example.mynews2.db.SavedNews
import com.example.mynews2.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_news_view.*

/*
this is savedNewsView Fragment
 */
class NewsViewFragment : Fragment() {
    //declaring variable
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var adapter: SaveAdapter
    var savedNewsList = ArrayList<SavedNews>()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_news_view, container, false)
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        val layoutManager = LinearLayoutManager(activity , LinearLayoutManager.VERTICAL,false)
        rVSavedNews.layoutManager = layoutManager
        showSavedNewsFromRoomDB() // calling saved news function in onViewCreated
    }
/*
function to show saved news from room database
 */
    private fun showSavedNewsFromRoomDB() {
        val application = requireActivity().application
        val savedNewsViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        savedNewsViewModel.savedData.observe(viewLifecycleOwner , Observer {
            savedNewsList = it as ArrayList<SavedNews>
            adapter = SaveAdapter(this, savedNewsList)
            rVSavedNews.adapter = adapter
            adapter.notifyDataSetChanged()   // to reflect the changes
            Log.e("New", adapter.itemCount.toString())
        })
    }
}
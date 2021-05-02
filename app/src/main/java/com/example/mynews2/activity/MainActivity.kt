package com.example.mynews2.activity

import com.example.mynews2.R
import com.example.mynews2.adapter.ItemAdapter
import com.example.mynews2.api.ApiClient
import com.example.mynews2.extensions.showToast
import com.example.mynews2.model.DataModel
import com.example.mynews2.model.ResponseDataModel


import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    //declaring varibales
    private val KEY = "3b74b9a7494220950e247fa93295281a" // defining key of api
    private val LANGUAGE = "en"
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var progressDialog: ProgressDialog
    var newsList =  ArrayList<DataModel>()
    private var searchBar : String = ""
    private var categoryBar : String = ""
    private var languageBar : String = ""
    private var countryBar : String = ""
    private var sourceBar : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bundleSearch=intent
        when {
            bundleSearch.getBooleanExtra("checkKeyword",false) -> {
                searchBar= bundleSearch.getStringExtra("keywords").toString()
                createProgressDialog()
                setupUI()
                showSearchNews()

            }
            bundleSearch.getBooleanExtra("checkLanguage" , false) -> {
                languageBar = bundleSearch.getStringExtra("languages").toString()
                createProgressDialog()
                setupUI()
                showLanguageWiseNews()
            }
            bundleSearch.getBooleanExtra("checkCategory" , false) -> {
                categoryBar = bundleSearch.getStringExtra("categories").toString()
                createProgressDialog()
                setupUI()
                showCategoryWiseNews()
            }
            bundleSearch.getBooleanExtra("checkCountry" ,  false) ->{
                countryBar = bundleSearch.getStringExtra("country").toString()
                createProgressDialog()
                setupUI()
                showCountryWiseNews()
            }
            bundleSearch.getBooleanExtra("checkSource" ,  false) ->{
                sourceBar = bundleSearch.getStringExtra("sources").toString()
                createProgressDialog()
                setupUI()
                showSourceWiseNews()
            }
            else -> {
                createProgressDialog()
                setupUI()
                showNews()
            }
        }
        /**
         * attaching click listener on floating icon
         */
        floatingButton.setOnClickListener {
            startActivity(Intent(this , MenuActivity::class.java))
        }
    }
    private fun showCountryWiseNews() {
        progressDialog.show()
        val call = ApiClient.getClient.getCountryData(KEY , countryBar )
        call.enqueue(object : Callback<ResponseDataModel>{
            override fun onResponse(
                call: Call<ResponseDataModel>,
                response: Response<ResponseDataModel>
            ) {
                if(response.isSuccessful){
                    newsList.addAll(response.body()?.data ?: ArrayList())
                    recyclerView.adapter?.notifyDataSetChanged()
                    Log.e("Data", "Data is ${response.body()}\n\n")
                }
                progressDialog.dismiss()
            }
            override fun onFailure(call: Call<ResponseDataModel>, t: Throwable) {
                progressDialog.dismiss()
                Log.e("Failure","Error is ${t.localizedMessage}")
                showToast("Some Error Occurred while fetching data")
            }
        })
    }
    private fun showLanguageWiseNews() {
        progressDialog.show()
        val call = ApiClient.getClient.getLanguageData(KEY , languageBar )
        call.enqueue(object : Callback<ResponseDataModel>{
            override fun onResponse(
                call: Call<ResponseDataModel>,
                response: Response<ResponseDataModel>
            ) {
                if(response.isSuccessful){
                    newsList.addAll(response.body()?.data ?: ArrayList())
                    recyclerView.adapter?.notifyDataSetChanged()
                    Log.e("Data", "Data is ${response.body()}\n\n")
                }
                progressDialog.dismiss()
                shimmer.visibility = View.GONE
                clMain.visibility = View.VISIBLE
            }
            override fun onFailure(call: Call<ResponseDataModel>, t: Throwable) {
                progressDialog.dismiss()
                Log.e("Failure","Error is ${t.localizedMessage}")
                showToast("Some Error Occurred while fetching data")
            }
        })
    }
    private fun showCategoryWiseNews() {
        progressDialog.show()
        val call = ApiClient.getClient.getCategoryData(KEY , "en" , categoryBar )
        call.enqueue(object : Callback<ResponseDataModel>{
            override fun onResponse(
                call: Call<ResponseDataModel>,
                response: Response<ResponseDataModel>
            ) {
                if(response.isSuccessful){
                    newsList.addAll(response.body()?.data ?: ArrayList())
                    recyclerView.adapter?.notifyDataSetChanged()
                    Log.e("Data", "Data is ${response.body()}\n\n")
                }
                progressDialog.dismiss()
                shimmer.visibility = View.GONE
                clMain.visibility = View.VISIBLE
            }

            override fun onFailure(call: Call<ResponseDataModel>, t: Throwable) {
                progressDialog.dismiss()
                Log.e("Failure","Error is ${t.localizedMessage}")
                showToast("Some Error Occurred while fetching data")
            }
        })
    }

    private fun showSearchNews() {
        progressDialog.show()
        val call = ApiClient.getClient.getSearchData(KEY, "en",searchBar)
        call.enqueue(object : Callback<ResponseDataModel> {
            override fun onResponse(
                call: Call<ResponseDataModel>,
                response: Response<ResponseDataModel>
            ) {
                if (response.isSuccessful) {
                    newsList.addAll(response.body()?.data ?: ArrayList())
                    recyclerView.adapter?.notifyDataSetChanged()
                    Log.e("Data", "Data is ${response.body()}\n\n")
                }
                progressDialog.dismiss()
                shimmer.visibility = View.GONE
                clMain.visibility = View.VISIBLE
            }
            override fun onFailure(call: Call<ResponseDataModel>, t: Throwable) {
                progressDialog.dismiss()
                Log.e("Failure", "Error is ${t.localizedMessage}")
                showToast("Some Error Occurred while fetching data")
            }
        })
    }
    private fun setupUI() {
        //recycler view
        val layoutManager = LinearLayoutManager(this ,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = layoutManager

        //attaching adapter to recycler view
        itemAdapter = ItemAdapter(this,newsList,this)
        recyclerView.adapter = itemAdapter
    }

    private fun showNews() {
        progressDialog.show()
        val call = ApiClient.getClient.getData(KEY, LANGUAGE )
        call.enqueue(object : Callback<ResponseDataModel>{
            override fun onResponse(
                call: Call<ResponseDataModel>,
                response: Response<ResponseDataModel>
            ) {
                if(response.isSuccessful){
                    newsList.addAll(response.body()?.data ?: ArrayList())
                    recyclerView.adapter?.notifyDataSetChanged()
                    Log.e("Data", "Data is ${response.body()}\n\n")
                }
                progressDialog.dismiss()
                shimmer.visibility = View.GONE
                clMain.visibility = View.VISIBLE
            }
            override fun onFailure(call: Call<ResponseDataModel>, t: Throwable) {
                progressDialog.dismiss()
                Log.e("Failure","Error is ${t.localizedMessage}")
                showToast("Some Error Occurred while fetching data")
            }
        })
    }
    private fun showSourceWiseNews() {
        progressDialog.show()
        val call = ApiClient.getClient.getSourceData(KEY, LANGUAGE , sourceBar )
        call.enqueue(object : Callback<ResponseDataModel>{
            override fun onResponse(
                    call: Call<ResponseDataModel>,
                    response: Response<ResponseDataModel>
            ) {
                if(response.isSuccessful){
                    newsList.addAll(response.body()?.data ?: ArrayList())
                    recyclerView.adapter?.notifyDataSetChanged()
                    Log.e("Data", "Data is ${response.body()}\n\n")
                }
                progressDialog.dismiss()
            }
            override fun onFailure(call: Call<ResponseDataModel>, t: Throwable) {
                progressDialog.dismiss()
                Log.e("Failure","Error is ${t.localizedMessage}")
                showToast("Some Error Occurred while fetching data")
            }
        })
    }
    private fun createProgressDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading..")
        progressDialog.setMessage("Please wait while we fetch data..")
        progressDialog.setCancelable(false)
    }
    fun onItemClicked(
            position: Int,
            url_adapter: String,
            title_adapter: String,
            desc_adapter: String,
            time_adapter: String
    ) {
        val intent = Intent(this , WebActivity::class.java)
        intent.apply {
            putExtra("url_news" , url_adapter)
            putExtra("title_news" , title_adapter)
            putExtra("desc_news" , desc_adapter)
            putExtra("time_news" , time_adapter)
        }
        startActivity(intent)
    }
}

package com.android.appnoticias.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.appnoticias.network.NetworkUtils
import com.android.appnoticias.R
import com.android.appnoticias.entities.User
import com.android.appnoticias.network.UserService
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("http://guicgarcia.96.lt/supertreinos/")

        val endpoint = retrofitClient.create(UserService::class.java)
        val callback = endpoint.getUsers()

        callback.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("RESPOSTA", t.message, t)
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                Log.d("GUILHERME", response.body()?.toString())
                loadRecyclerView(response.body())
            }
        })
    }

    private fun loadRecyclerView(users : List<User>?) {
        val adapter = GroupAdapter<ViewHolder>()
        users?.forEach{
            adapter.add(ArticleItem(it))
        }

        recycler.adapter = adapter
    }

}

package dev.aldi.a10119908latihan7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import dev.aldi.a10119908latihan7.adapter.PeopleAdapter
import dev.aldi.a10119908latihan7.api.ApiEndpoint
import dev.aldi.a10119908latihan7.api.RetrofitBuilder
import dev.aldi.a10119908latihan7.model.People
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var peoples: List<People> = listOf()
    lateinit var peopleAdapter: PeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        peopleAdapter = PeopleAdapter(peoples)
        val peopleRecyclerView: RecyclerView = findViewById(R.id.peoplerecylerview)
        peopleRecyclerView.adapter = peopleAdapter


        val api = RetrofitBuilder.getInstance().create(ApiEndpoint::class.java)
        val response: Call<SwapiResponse> = api.getPeople()

        response.enqueue(object : Callback<SwapiResponse> {

            override fun onFailure(call: Call<SwapiResponse>, t: Throwable) {
                Log.e("API-CALL", "ERR", t)
            }

            override fun onResponse(call: Call<SwapiResponse>, response: Response<SwapiResponse>) {
                Log.d("API-CALL", response.body().toString())
                peoples = response.body()?.results!!
                peopleAdapter = PeopleAdapter(peoples)
                peopleRecyclerView.adapter = peopleAdapter
            }

        })
    }
}
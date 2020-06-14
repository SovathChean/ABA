package com.example.aba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class BlogActivity extends AppCompatActivity {
     RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        //make a reference to recycler view
        recyclerView = findViewById(R.id.recycler_view);

        //create linearmanager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadBlogs();
    }

    public void loadBlogs(){
        String url = "http://10.0.2.2/android-test/mail.php";
        StringRequest request = new StringRequest(url, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                Gson obj = new Gson();
                Blog[] blog = obj.fromJson(response, Blog[].class);
                BlogAdapter adapter = new BlogAdapter(blog);
                recyclerView.setAdapter(adapter);

            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(BlogActivity.this, "Something wrong with connection", Toast.LENGTH_SHORT).show();
                Log.d("blog", "Something wrong with "+ error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(request);
    }
}

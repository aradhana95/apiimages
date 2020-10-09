package com.example.recylerviewjsonexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;



import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
       // String url = "https://putatoe.herokuapp.com/api/v1/service";

       // final JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,





                                    mExampleList.add(new ExampleItem("imageUrl", "count"));
        mExampleList.add(new ExampleItem("arad", "counhanat"));
        mExampleList.add(new ExampleItem("abhi", "nav"));
        mExampleList.add(new ExampleItem("abhi", "nav"));
        mExampleList.add(new ExampleItem("abhi", "nav"));
        mExampleList.add(new ExampleItem("abhi", "nav"));
        mExampleList.add(new ExampleItem("abhi", "nav"));
        mExampleList.add(new ExampleItem("abhi", "nav"));
        mExampleList.add(new ExampleItem("abhi", "nav"));
        mExampleList.add(new ExampleItem("abhi", "nav"));
        mExampleList.add(new ExampleItem("abhi", "nav"));
        mExampleList.add(new ExampleItem("abhi", "nav"));






        mExampleAdapter = new ExampleAdapter(MainActivity.this, mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);


                        }




      //  mRequestQueue.add(request);

}

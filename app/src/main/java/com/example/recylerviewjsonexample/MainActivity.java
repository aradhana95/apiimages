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
        String url = "https://7hs6v5qhs4.execute-api.ap-south-1.amazonaws.com/qa/allsubcategory/5d5e94a23758ba00072181da";

        final JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {


                            for (int i = 0; i < response.length(); i++) {
                                JSONObject hit = response.getJSONObject(i);

                                String imageinfo = hit.getString("productImage");

                                JSONArray infoarray = new JSONArray(imageinfo);
                                for (int j = 0; j < infoarray.length(); j++) {

                                    JSONObject completeinfo = infoarray.getJSONObject(j);


                                    String imageUrl = completeinfo.getString("productImageName");/*  "productImage": [
            {
                "_id": "5d5f3c0ec51c8f00077ec3c4",
                "productImageName": "https://www.dropbox.com/sh/ch3ch2kdowefh9w/AACG0LZo3r0wTZ4g_eNsBkT2a/PRP5740.jpg?raw=1"
            }*/
                                    String likeCount = completeinfo.getString("_id");

                                    mExampleList.add(new ExampleItem(imageUrl, likeCount));
                                }
                            }

                            mExampleAdapter = new ExampleAdapter(MainActivity.this, mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }
}

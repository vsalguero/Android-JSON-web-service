package com.android_json;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Creating a List of superheroes
    private List<Notice> listNotices;

    //Creating Views
    private RecyclerView mLista;
    private RecyclerView.Adapter mAdapter;


    //Volley Request Queue
    private RequestQueue requestQueue;

    StaggeredGridLayoutManager mStaggeredGridLayoutManager;


    int mCount = 0;


    SwipeRefreshLayout mSwipeRefreshLayout;

    int mSpans;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notices_layout);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);

        mLista = (RecyclerView) findViewById(R.id.listaNoticias);

        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(
                1, //number of grid columns
                GridLayoutManager.VERTICAL);

        //Sets the gap handling strategy for StaggeredGridLayoutManager
        mStaggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

        mLista.setLayoutManager(mStaggeredGridLayoutManager);

        //Initializing our superheroes list
        listNotices = new ArrayList<>();

        mLista.setOnScrollListener(new EndlessRecyclerOnScrollListener(mStaggeredGridLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                // do something...
                getData(current_page);
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(true);
                listNotices = new ArrayList<>();
                mCount = 0;
                getData(1);

                mAdapter = new NoticesAdapter(listNotices, getApplicationContext());

                mLista.setAdapter(mAdapter);

                mAdapter.notifyDataSetChanged();

                mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(
                        1, //number of grid columns
                        GridLayoutManager.VERTICAL);

                //Sets the gap handling strategy for StaggeredGridLayoutManager
                mStaggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
                mLista.setLayoutManager(mStaggeredGridLayoutManager);

            }
        });


        mSwipeRefreshLayout.post(new Runnable() {
                                     @Override
                                     public void run() {
                                         mSwipeRefreshLayout.setRefreshing(true);
                                         getData(1);
                                         mAdapter = new NoticesAdapter(listNotices, getApplicationContext());

                                         mLista.setAdapter(mAdapter);

                                     }
                                 }

        );



    }
    private JsonArrayRequest getDataFromServer(final int requestCount) {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Config.DATA_URL + String.valueOf(requestCount),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (requestCount == mCount + 1) {
                            mCount++;
                            parseData(response);
                        }
                        mSwipeRefreshLayout.setRefreshing(false);


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //((MainActivity) getApplicationContext()).snackMessage(R.string.no_more_data);
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }) {
            @Override
            protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
                Response<JSONArray> resp = super.parseNetworkResponse(response);
                if (!resp.isSuccess()) {
                    return resp;
                }
                long now = System.currentTimeMillis();
                Cache.Entry entry = resp.cacheEntry;
                if (entry == null) {
                    entry = new Cache.Entry();
                    entry.data = response.data;
                    entry.responseHeaders = response.headers;
                    entry.ttl = now + 24 * 60 * 60 * 1000;  //keeps cache for 1 day
                }
                entry.softTtl = 0; // refresh in 0 minute

                return Response.success(resp.result, entry);
            }
        };

        //jsonArrayRequest.setShouldCache(false);
        return jsonArrayRequest;
    }


    //This method will get data from the web api on scroll increment the page in 1 value
    private void getData(int requestCount) {
        if (requestCount == mCount + 1) {
            MySocialMediaSingleton.getInstance(getApplicationContext()).addToRequestQueue(getDataFromServer(requestCount));
        } else {
            MySocialMediaSingleton.getInstance(getApplicationContext()).addToRequestQueue(getDataFromServer(mCount + 1));
        }


    }

    //This method will parse json data
    private void parseData(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            //Creating the notice object
            Notice notice = new Notice();
            JSONObject json = null;
            try {
                //Getting json
                json = array.getJSONObject(i);

                //Adding data to the superhero object
                notice.setId(json.getInt(Config.TAG_ID));
                notice.setImagen(json.getString(Config.TAG_IMAGE));
                notice.setTitulo(json.getString(Config.TAG_TITULO));
                notice.setDescripcion(json.getString(Config.TAG_DESCRIPCION));
                notice.setNombrecorto(json.getString(Config.TAG_NOMBRECORTO));
                notice.setFecha(json.getString(Config.TAG_FECHA));
                notice.setFechaPub(json.getString(Config.TAG_FECHAPUB));
                notice.setTipo(json.getString(Config.TAG_TIPO));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Adding the superhero object to the list
            listNotices.add(notice);
        }

        mAdapter.notifyDataSetChanged();
    }
}
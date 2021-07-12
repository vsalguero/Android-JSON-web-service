package com.android_json;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/**
 * Created by Vladimir Salguero on 24/08/2016.
 */


public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {
    public static String TAG = EndlessRecyclerOnScrollListener.class.getSimpleName();
    private int scrolledDistance = 0;
    private boolean controlsVisible = false;


    private int previousTotal = 0; // The total number of items in the dataset after the last load
    private boolean loading = true; // True if we are still waiting for the last set of data to load.
    private int visibleThreshold = 5; // The minimum amount of items to have below your current scroll position before loading more.
    //int firstVisibleItem, visibleItemCount, totalItemCount;
    private int pastVisibleItems, visibleItemCount, totalItemCount;


    private int current_page = 1;

    private LinearLayoutManager mLinearLayoutManager;

    private GridLayoutManager mGridLayoutManager;

    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;


    public EndlessRecyclerOnScrollListener(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.mStaggeredGridLayoutManager = staggeredGridLayoutManager;

    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = mStaggeredGridLayoutManager.getItemCount();
        //firstVisibleItem = mStaggeredGridLayoutManager.findFirstVisibleItemPosition();
        int[] firstVisibleItems = null;
        firstVisibleItems = mStaggeredGridLayoutManager.findFirstVisibleItemPositions(firstVisibleItems);
        if (firstVisibleItems != null && firstVisibleItems.length > 0) {
            pastVisibleItems = firstVisibleItems[0];
        }


        if (loading) {
            if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                loading = false;
                previousTotal = totalItemCount;
            }
        }
        if (!loading && (totalItemCount - visibleItemCount)
                <= (pastVisibleItems + visibleThreshold)) {
            // End has been reached

            // Do something
            current_page++;

            onLoadMore(current_page);

            loading = true;
        }

        if (scrolledDistance > 1 && controlsVisible) {

            controlsVisible = false;
            scrolledDistance = 0;
        } else if (scrolledDistance < -1 && !controlsVisible) {

            controlsVisible = true;
            scrolledDistance = 0;
        }

        if ((controlsVisible && dy > 0) || (!controlsVisible && dy < 0)) {
            scrolledDistance += dy;
        }
    }

    public abstract void onLoadMore(int current_page);
}

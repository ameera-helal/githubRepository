package com.example.githubrepository;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.githubrepository.adapter.RecyclerViewAdapter;
import com.example.githubrepository.data.RepositoryListAsyncResponse;
import com.example.githubrepository.data.TopRatedRepositories;
import com.example.githubrepository.model.Repository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TopRatedRepositories jsonRepositoryData = new TopRatedRepositories();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Repository> repositoryList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;


    private int pageNumber = 1;
    private int items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);


        repositoryList = jsonRepositoryData.getRepositories(new RepositoryListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Repository> repositoryArrayList) {
                //notify the recyclerview when the data is ready to update it
                recyclerViewAdapter.notifyDataSetChanged();
                pagination();

            }
        }, pageNumber);

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, repositoryList);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);


    }

    public void pagination() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //check if the user scrolled until the last item in the current json page to load the next page data
                if (isLastItemDisplaying()) {

                    items = recyclerViewAdapter.getItemCount();

                    //make sure that page numbers don't exceed the last page to aboid null data
                    if(pageNumber<34)
                    { pageNumber++;
                    Toast.makeText(MainActivity.this,"page:"+pageNumber,Toast.LENGTH_SHORT).show();}


                    //load the next page data
                    repositoryList= jsonRepositoryData.getRepositories(new RepositoryListAsyncResponse() {
                        @Override
                        public void processFinished(ArrayList<Repository> repositoryArrayList) {
                            recyclerViewAdapter.notifyItemInserted(items);
                            pagination();

                        }
                    },pageNumber);
                }

            }
        });
    }


    private boolean isLastItemDisplaying() {
        //Check if the adapter item count is greater than 0
        if (recyclerViewAdapter.getItemCount() != 0) {
            //get the last visible item on screen using the layout manager
            int lastVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();

            if (lastVisibleItemPosition != RecyclerView.NO_POSITION && lastVisibleItemPosition == recyclerViewAdapter.getItemCount() - 1) {
                return true;
            }

        }
        return false;

    }
}
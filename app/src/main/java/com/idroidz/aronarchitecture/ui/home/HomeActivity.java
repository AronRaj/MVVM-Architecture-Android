package com.idroidz.aronarchitecture.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.idroidz.aronarchitecture.R;
import com.idroidz.aronarchitecture.ViewModelProviderFactory;
import com.idroidz.aronarchitecture.data.model.api.Movie;
import com.idroidz.aronarchitecture.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity implements HomeActions, View.OnClickListener, MovieSelectedListener {


    private EditText movieNameText;
    private TextView noDataTextView;
    private Button searchButton;
    private RecyclerView movieRecyclerView;
    private MovieListAdapter movieListAdapter;
    private HomeViewModel homeViewModel;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noDataTextView = findViewById(R.id.no_data_text);
        movieNameText = findViewById(R.id.search_text);
        searchButton = findViewById(R.id.search_button);
        movieRecyclerView = findViewById(R.id.movies_list);
        searchButton.setOnClickListener(this);
        initViewModel();
        initViews();
    }

    private void initViews() {
        movieRecyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        movieListAdapter = new MovieListAdapter(this);
        movieRecyclerView.setAdapter(movieListAdapter);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public void initViewModel() {
        //ViewModelProviderFactory factory = new ViewModelProviderFactory(getApplication(), new AppDataManager(new RetrofitApiManager()));
         homeViewModel = new ViewModelProvider(this, viewModelProviderFactory).get(HomeViewModel.class);
        homeViewModel.setNavigator(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_button: {
                hideKeyboard();
                String searchText = movieNameText.getText().toString();
                homeViewModel.getMoviesList(searchText);
                break;
            }
        }
    }


    @Override
    public void setData(List<Movie> movieList) {
        noDataTextView.setVisibility(View.GONE);
        movieRecyclerView.setVisibility(View.VISIBLE);
        movieListAdapter.setData(movieList);
    }

    @Override
    public void handleError() {
        movieRecyclerView.setVisibility(View.GONE);
        noDataTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onMovieSelected(Movie movie) {
        Toast.makeText(getApplicationContext(),"Movie: "+movie.getTitle(),Toast.LENGTH_SHORT).show();
    }
}

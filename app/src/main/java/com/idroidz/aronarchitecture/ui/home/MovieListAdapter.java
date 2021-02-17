package com.idroidz.aronarchitecture.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idroidz.aronarchitecture.R;
import com.idroidz.aronarchitecture.data.model.api.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.RepoViewHolder> {

    private final MovieSelectedListener movieSelectedListener;
    private List<Movie> data = new ArrayList();

    MovieListAdapter(MovieSelectedListener movieSelectedListener) {
        this.movieSelectedListener = movieSelectedListener;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private Movie getItemAtPosition(int position) {
        return data.get(position);
    }

    public void setData(List<Movie> movieList) {
        this.data = movieList;
        notifyDataSetChanged();
    }

    final class RepoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView movieNameTextView;
        TextView movieYearTextView;

        private Movie movie;

        RepoViewHolder(View itemView) {
            super(itemView);
            movieNameTextView = itemView.findViewById(R.id.movie_name);
            movieYearTextView = itemView.findViewById(R.id.movie_year);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (movieSelectedListener != null)
                movieSelectedListener.onMovieSelected(getItemAtPosition(getAdapterPosition()));
        }

        void bind(Movie movie) {
            if (null != movie) {
                this.movie = movie;
                movieNameTextView.setText(movie.getTitle());
                movieYearTextView.setText(movie.getYear());
            }
        }
    }
}

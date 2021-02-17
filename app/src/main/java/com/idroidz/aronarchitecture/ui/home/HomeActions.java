package com.idroidz.aronarchitecture.ui.home;

import com.idroidz.aronarchitecture.data.model.api.Movie;

import java.util.List;

public interface HomeActions {

    void setData(List<Movie> movieList);

    void handleError();
}

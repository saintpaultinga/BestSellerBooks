package com.tsp.learn.android.bestsellerbooks.repository.service;

import com.tsp.learn.android.bestsellerbooks.data.entities.BookResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookService {
    @GET("svc/books/v3/lists/current/hardcover-fiction.json")
    Observable<BookResponse> getHardCordFictionBooks(@Query("api-key") String apiKey);
}

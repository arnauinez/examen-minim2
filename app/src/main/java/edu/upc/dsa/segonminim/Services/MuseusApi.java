package edu.upc.dsa.segonminim.Services;

import edu.upc.dsa.segonminim.Models.Museums;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MuseusApi {

    @GET("dataset/museus/format/json/pag-ini/1/pag-fi/20")
    Call<Museums> getMuseums();

}

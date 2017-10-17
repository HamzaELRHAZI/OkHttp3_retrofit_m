package fr.busin.okhttp3.service;

import fr.busin.okhttp3.models.Users;
import retrofit.Callback;
import retrofit.http.GET;


/**
 * Created by adrien on 11/10/2017.
 */

public interface ApiService {

    @GET("/fichier_json.json")
    void getUsers(Callback<Users> usersCallback);
}

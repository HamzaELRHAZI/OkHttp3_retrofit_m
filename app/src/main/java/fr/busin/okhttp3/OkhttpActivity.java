package fr.busin.okhttp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import fr.busin.okhttp3.models.User;
import fr.busin.okhttp3.models.Users;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        okHttpMethode();
    }


    public void okHttpMethode(){

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://android.busin.fr/fichier_json.json")
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OkhttpActivity.this, "Oups, impossible de récuperer l'info", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();

                String json = response.body().string();

                final Users users = gson.fromJson(json, Users.class);


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (User user: users.getUsers()) {
                            Toast.makeText(OkhttpActivity.this, user.getPrenom(), Toast.LENGTH_SHORT).show();

                        }

                    }
                });
            }
        });


    }
}

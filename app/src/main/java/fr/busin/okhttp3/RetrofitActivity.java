package fr.busin.okhttp3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.io.IOException;

import fr.busin.okhttp3.models.Users;
import fr.busin.okhttp3.service.ApiService;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        try {
            retrofitMethod();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void retrofitMethod() throws IOException {

        RestAdapter retrofit = new RestAdapter.Builder()
                .setEndpoint("http://android.busin.fr")
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getUsers(new Callback<Users>() {
            @Override
            public void success(Users users, Response response) {
                //Toast.makeText(RetrofitActivity.this, "It's work", Toast.LENGTH_SHORT).show();
                //RECYCLERVIEW POUR AFFICHER LES USERS
                //AU CLIC SUR ITEM, NEW ACTIVITY POUR AFFICHER
                Intent intent = new Intent(RetrofitActivity.this, VoitureActivity.class);
                setView(users,intent);

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(RetrofitActivity.this, "Oups...", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setView(Users users,Intent intent) {

        RecyclerView mRvUser = (RecyclerView) findViewById(R.id.rv_user);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvUser.setLayoutManager(layoutManager);

        UserAdapter userAdapter = new UserAdapter(getApplicationContext(), users, intent);

        mRvUser.setAdapter(userAdapter);


    }
}

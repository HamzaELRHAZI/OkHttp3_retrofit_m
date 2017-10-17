package fr.busin.okhttp3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.busin.okhttp3.models.User;
import fr.busin.okhttp3.models.Users;
import fr.busin.okhttp3.models.Voiture;

/**
 * Created by adrien on 11/10/2017.
 */

class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context mContext;
    private Users mUsers;
   // private int position ;
    private static Intent intent ;


    public UserAdapter(Context context, Users users ,Intent intent) {
        mContext = context;
        mUsers = users;
        this.intent=intent;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, final int viewType) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_user_view, viewGroup, false);
        UserViewHolder holder = new UserViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                intent.putExtra("Cars", (ArrayList<Voiture>) mUsers.getUsers().get(viewType).getVoitures());
                mContext.startActivity(intent);

          //   Toast.makeText(mContext, "Click on view ", Toast.LENGTH_SHORT).show();
            }

        });

        return holder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
            User user = mUsers.getUsers().get(position);

        holder.tv_age.setText(String.valueOf(user.getAge()));

        holder.tv_prenom.setText(user.getPrenom());
    }

    @Override
    public int getItemCount() {
        return mUsers.getUsers().size();
    }
}

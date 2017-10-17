package fr.busin.okhttp3;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by adrien on 11/10/2017.
 */

class UserViewHolder extends RecyclerView.ViewHolder {

    TextView tv_nom;
    TextView tv_prenom;
    TextView tv_age;
    RadioButton rb_permis;

    public UserViewHolder(View itemViewUser) {
        super(itemViewUser);
        tv_nom = (TextView) itemView.findViewById(R.id.tv_nom);
        tv_prenom = (TextView) itemView.findViewById(R.id.tv_prenom);
        tv_age = (TextView) itemView.findViewById(R.id.tv_age);
    }
}

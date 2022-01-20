package com.hackeranushi.grocerywalla.ProfileActivity.Addresses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticImageView;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {

    String[] str;
    Context context;

    public AddressAdapter(String[] str, Context context) {
        this.str = str;
        this.context = context;
    }

    @NonNull
    @Override
    public AddressAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_layout,parent,false);
        return new AddressAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return str.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nicknameAddress, userName, houseNo, landMark, locality;
        ElasticImageView more;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nicknameAddress = itemView.findViewById(R.id.address_nickname);
            userName = itemView.findViewById(R.id.address_userName);
            houseNo = itemView.findViewById(R.id.address_houseNo);
            landMark = itemView.findViewById(R.id.addres_street_society);
            locality = itemView.findViewById(R.id.address_locality);
            more = itemView.findViewById(R.id.address_more);
        }
    }
}

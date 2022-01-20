package com.hackeranushi.grocerywalla.ProductDetails.ProductRating.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;

public class UserRatingAdapter extends RecyclerView.Adapter<UserRatingAdapter.ViewHolder> {

    String [] str;
    Context context;

    public UserRatingAdapter(String[] str, Context context) {
        this.str = str;
        this.context = context;
    }

    @NonNull
    @Override
    public UserRatingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rating_activity,parent,false);
        return new UserRatingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserRatingAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return str.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatRatingBar ratingBar;
        TextView user, userFeedback, feedbackTime, sellerTag;
        ElasticButton likeButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            user = itemView.findViewById(R.id.user);
            userFeedback = itemView.findViewById(R.id.user_feedback);
            feedbackTime = itemView.findViewById(R.id.feedback_date);
            sellerTag = itemView.findViewById(R.id.seller_tag);
            likeButton = itemView.findViewById(R.id.like_button);
        }
    }
}

package com.hackeranushi.grocerywalla.HomeProductAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackeranushi.grocerywalla.Models.HomeModel.ProductModel;
import com.hackeranushi.grocerywalla.ProductDetails.ProductInfo;
import com.hackeranushi.grocerywalla.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    int i;
    List<ProductModel> list;
    Context context;
    public static final int HOME_LIST=0;


    public HomeAdapter(int i, List<ProductModel> list, Context context) {
        this.i = i;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =null;
        if (i==0)
        {
            view = inflater.inflate(R.layout.home_product,parent,false);
        }else if (i==1)
        {
            view = inflater.inflate(R.layout.home_product,parent,false);
        }else if (i==2)
        {
            view = inflater.inflate(R.layout.home_product,parent,false);
        }else if (i==3)
        {
            view = inflater.inflate(R.layout.home_product,parent,false);
        }else if (i==4)
        {
            view = inflater.inflate(R.layout.home_product,parent,false);
        }else if (i==5)
        {
            view = inflater.inflate(R.layout.home_product,parent,false);
        }else if (i==6)
        {
            view = inflater.inflate(R.layout.home_product,parent,false);
        }else if (i==7)
        {
            view = inflater.inflate(R.layout.home_product,parent,false);
        }else if (i==8)
        {
            view = inflater.inflate(R.layout.home_product,parent,false);
        }else if (i==9)
        {
            view = inflater.inflate(R.layout.home_product,parent,false);
        }else if (i==10)
        {
            view = inflater.inflate(R.layout.home_product,parent,false);
        }else if (i==11)
        {
            view = inflater.inflate(R.layout.home_product,parent,false);
        }
        return new HomeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        if (i==0)
        {
            holder.productName.setText(list.get(position).getpName());
            holder.productPrice.setText(list.get(position).getpPrice());
            Picasso.get().load(list.get(position).getpImage()).into(holder.productImage);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View itemView) {
                    Log.d("Hello Kabaddi",""+ list.get(position).getProductId());
                    Intent intent=new Intent(itemView.getContext(), ProductInfo.class);
                    intent.putExtra("id",list.get(position).getProductId());
                    intent.putExtra("recyclerview_position",i);
                    intent.putExtra("SELECTION",HOME_LIST);
                    itemView.getContext().startActivity(intent);
                }
            });


        }else if (i==1)
        {
            holder.productName.setText(list.get(position).getpName());
            holder.productPrice.setText(list.get(position).getpPrice());
            Picasso.get().load(list.get(position).getpImage()).into(holder.productImage);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View itemView) {
                    Log.d("Hello Kabaddi",""+ list.get(position).getProductId());
                    Intent intent=new Intent(itemView.getContext(), ProductInfo.class);
                    intent.putExtra("id",list.get(position).getProductId());
                    intent.putExtra("recyclerview_position",i);
                    intent.putExtra("SELECTION",HOME_LIST);
                    itemView.getContext().startActivity(intent);
                }
            });


        }else if (i==2)
        {
            holder.productName.setText(list.get(position).getpName());
            holder.productPrice.setText(list.get(position).getpPrice());
            Picasso.get().load(list.get(position).getpImage()).into(holder.productImage);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View itemView) {
                    Log.d("Hello Kabaddi",""+ list.get(position).getProductId());
                    Intent intent=new Intent(itemView.getContext(), ProductInfo.class);
                    intent.putExtra("id",list.get(position).getProductId());
                    intent.putExtra("recyclerview_position",i);
                    intent.putExtra("SELECTION",HOME_LIST);
                    itemView.getContext().startActivity(intent);
                }
            });


        }else if (i==3)
        {
            holder.productName.setText(list.get(position).getpName());
            holder.productPrice.setText(list.get(position).getpPrice());
            Picasso.get().load(list.get(position).getpImage()).into(holder.productImage);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View itemView) {
                    Log.d("Hello Kabaddi",""+ list.get(position).getProductId());
                    Intent intent=new Intent(itemView.getContext(), ProductInfo.class);
                    intent.putExtra("id",list.get(position).getProductId());
                    intent.putExtra("recyclerview_position",i);
                    intent.putExtra("SELECTION",HOME_LIST);
                    itemView.getContext().startActivity(intent);
                }
            });


        }else if (i==4)
        {
            holder.productName.setText(list.get(position).getpName());
            holder.productPrice.setText(list.get(position).getpPrice());
            Picasso.get().load(list.get(position).getpImage()).into(holder.productImage);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View itemView) {
                    Log.d("Hello Kabaddi",""+ list.get(position).getProductId());
                    Intent intent=new Intent(itemView.getContext(), ProductInfo.class);
                    intent.putExtra("id",list.get(position).getProductId());
                    intent.putExtra("recyclerview_position",i);
                    intent.putExtra("SELECTION",HOME_LIST);
                    itemView.getContext().startActivity(intent);
                }
            });


        }else if (i==5)
        {
            holder.productName.setText(list.get(position).getpName());
            holder.productPrice.setText(list.get(position).getpPrice());
            Picasso.get().load(list.get(position).getpImage()).into(holder.productImage);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View itemView) {
                    Log.d("Hello Kabaddi",""+ list.get(position).getProductId());
                    Intent intent=new Intent(itemView.getContext(), ProductInfo.class);
                    intent.putExtra("id",list.get(position).getProductId());
                    intent.putExtra("recyclerview_position",i);
                    intent.putExtra("SELECTION",HOME_LIST);
                    itemView.getContext().startActivity(intent);
                }
            });


        }else if (i==6)
        {
            holder.productName.setText(list.get(position).getpName());
            holder.productPrice.setText(list.get(position).getpPrice());
            Picasso.get().load(list.get(position).getpImage()).into(holder.productImage);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View itemView) {
                    Log.d("Hello Kabaddi",""+ list.get(position).getProductId());
                    Intent intent=new Intent(itemView.getContext(), ProductInfo.class);
                    intent.putExtra("id",list.get(position).getProductId());
                    intent.putExtra("recyclerview_position",i);
                    intent.putExtra("SELECTION",HOME_LIST);
                    itemView.getContext().startActivity(intent);
                }
            });


        }else if (i==7)
        {
            holder.productName.setText(list.get(position).getpName());
            holder.productPrice.setText(list.get(position).getpPrice());
            Picasso.get().load(list.get(position).getpImage()).into(holder.productImage);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View itemView) {
                    Log.d("Hello Kabaddi",""+ list.get(position).getProductId());
                    Intent intent=new Intent(itemView.getContext(), ProductInfo.class);
                    intent.putExtra("id",list.get(position).getProductId());
                    intent.putExtra("recyclerview_position",i);
                    intent.putExtra("SELECTION",HOME_LIST);
                    itemView.getContext().startActivity(intent);
                }
            });


        }else if (i==8)
        {
            holder.productName.setText(list.get(position).getpName());
            holder.productPrice.setText(list.get(position).getpPrice());
            Picasso.get().load(list.get(position).getpImage()).into(holder.productImage);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View itemView) {
                    Log.d("Hello Kabaddi",""+ list.get(position).getProductId());
                    Intent intent=new Intent(itemView.getContext(), ProductInfo.class);
                    intent.putExtra("id",list.get(position).getProductId());
                    intent.putExtra("recyclerview_position",i);
                    intent.putExtra("SELECTION",HOME_LIST);
                    itemView.getContext().startActivity(intent);
                }
            });


        }else if (i==9)
        {
            holder.productName.setText(list.get(position).getpName());
            holder.productPrice.setText(list.get(position).getpPrice());
            Picasso.get().load(list.get(position).getpImage()).into(holder.productImage);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View itemView) {
                    Log.d("Hello Kabaddi",""+ list.get(position).getProductId());
                    Intent intent=new Intent(itemView.getContext(), ProductInfo.class);
                    intent.putExtra("id",list.get(position).getProductId());
                    intent.putExtra("recyclerview_position",i);
                    intent.putExtra("SELECTION",HOME_LIST);
                    itemView.getContext().startActivity(intent);
                }
            });


        }else if (i==10)
        {
            holder.productName.setText(list.get(position).getpName());
            holder.productPrice.setText(list.get(position).getpPrice());
            Picasso.get().load(list.get(position).getpImage()).into(holder.productImage);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View itemView) {
                    Log.d("Hello Kabaddi",""+ list.get(position).getProductId());
                    Intent intent=new Intent(itemView.getContext(), ProductInfo.class);
                    intent.putExtra("id",list.get(position).getProductId());
                    intent.putExtra("recyclerview_position",i);
                    intent.putExtra("SELECTION",HOME_LIST);
                    itemView.getContext().startActivity(intent);
                }
            });


        }else if (i==11)
        {
            holder.productName.setText(list.get(position).getpName());
            holder.productPrice.setText(list.get(position).getpPrice());
            Picasso.get().load(list.get(position).getpImage()).into(holder.productImage);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View itemView) {
                    Log.d("Hello Kabaddi",""+ list.get(position).getProductId());
                    Intent intent=new Intent(itemView.getContext(), ProductInfo.class);
                    intent.putExtra("id",list.get(position).getProductId());
                    intent.putExtra("recyclerview_position",i);
                    intent.putExtra("SELECTION",HOME_LIST);
                    itemView.getContext().startActivity(intent);
                }
            });
        }else
        {
            Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName,productPrice;
        ImageView productImage;
        LinearLayout line;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            line=itemView.findViewById(R.id.line);
            if (i==0) {
                productName = itemView.findViewById(R.id.product_name);
                productImage = itemView.findViewById(R.id.product_image);
                productPrice = itemView.findViewById(R.id.product_price);
            }else if (i==1) {
                productName = itemView.findViewById(R.id.product_name);
                productImage = itemView.findViewById(R.id.product_image);
                productPrice = itemView.findViewById(R.id.product_price);
            }else if (i==2) {
                productName = itemView.findViewById(R.id.product_name);
                productImage = itemView.findViewById(R.id.product_image);
                productPrice = itemView.findViewById(R.id.product_price);
            }else if (i==3) {
                productName = itemView.findViewById(R.id.product_name);
                productImage = itemView.findViewById(R.id.product_image);
                productPrice = itemView.findViewById(R.id.product_price);
            }else if (i==4) {
                productName = itemView.findViewById(R.id.product_name);
                productImage = itemView.findViewById(R.id.product_image);
                productPrice = itemView.findViewById(R.id.product_price);
            }else if (i==5) {
                productName = itemView.findViewById(R.id.product_name);
                productImage = itemView.findViewById(R.id.product_image);
                productPrice = itemView.findViewById(R.id.product_price);
            }else if (i==6) {
                productName = itemView.findViewById(R.id.product_name);
                productImage = itemView.findViewById(R.id.product_image);
                productPrice = itemView.findViewById(R.id.product_price);
            }else if (i==7) {
                productName = itemView.findViewById(R.id.product_name);
                productImage = itemView.findViewById(R.id.product_image);
                productPrice = itemView.findViewById(R.id.product_price);
            }else if (i==8) {
                productName = itemView.findViewById(R.id.product_name);
                productImage = itemView.findViewById(R.id.product_image);
                productPrice = itemView.findViewById(R.id.product_price);
            }else if (i==9) {
                productName = itemView.findViewById(R.id.product_name);
                productImage = itemView.findViewById(R.id.product_image);
                productPrice = itemView.findViewById(R.id.product_price);
            }else if (i==10) {
                productName = itemView.findViewById(R.id.product_name);
                productImage = itemView.findViewById(R.id.product_image);
                productPrice = itemView.findViewById(R.id.product_price);
            }else if (i==11) {
                productName = itemView.findViewById(R.id.product_name);
                productImage = itemView.findViewById(R.id.product_image);
                productPrice = itemView.findViewById(R.id.product_price);
            }
        }
    }
}

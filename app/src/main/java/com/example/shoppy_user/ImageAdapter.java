package com.example.shoppy_user;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Upload> mUploads;
    onItemClickListener mListener;
    public ImageAdapter(Context context, List<Upload> uploads){
        mContext=context;
        mUploads=uploads;

    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Upload currentUpload=mUploads.get(position);
        holder.Name.setText(currentUpload.getName());
        holder.price.setText(currentUpload.getPrice());
        holder.Real_price.setText(currentUpload.getRealPrice());
        holder.offer.setText(currentUpload.getOffer());
        Picasso.with(mContext).load(currentUpload.getImageUrl()).placeholder(R.mipmap.ic_launcher).fit().centerCrop().into(holder.cloth_img);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView cloth_img,favorite_img;
        public TextView Name,price,Real_price,offer;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            cloth_img=itemView.findViewById(R.id.product_img);
            favorite_img=itemView.findViewById(R.id.love_img);
            Real_price=itemView.findViewById(R.id.originalPrice_txt);
            price=itemView.findViewById(R.id.offerPrice_txt);
            Name=itemView.findViewById(R.id.name_txt);
            offer=itemView.findViewById(R.id.offer_txt);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mListener!=null){
                int position= getAdapterPosition();
                if(position !=RecyclerView.NO_POSITION){
                    mListener.onItemClick(position);
                }
            }
        }
    }
    public interface onItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(onItemClickListener listener){
        mListener=listener;
    }
}

package com.example.recylerviewjsonexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;



    public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
        private Context mContext;
        private ArrayList<ExampleItem> mExampleList;

        public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleList) {
            mContext = context;
            mExampleList = exampleList;
        }

        @Override
        public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
            return new ExampleViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final ExampleViewHolder holder, int position) {
            ExampleItem currentItem = mExampleList.get(position);

            String imageUrl = currentItem.getImageUrl();
            //String creatorName = currentItem.getCreator();
            String likeCount = currentItem.getLikeCount();

           //holder.mTextViewCreator.setText(creatorName);
            holder.mTextViewLikes.setText("Likes: " + likeCount);
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    holder.araEdit.setVisibility(View.VISIBLE);

                }
            });          //  Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);
        }

        @Override
        public int getItemCount() {
            return mExampleList.size();
        }

        public class ExampleViewHolder extends RecyclerView.ViewHolder {
           // public ImageView mImageView;
           // public TextView mTextViewCreator;
            public TextView mTextViewLikes;
            public TextView textView;
            public EditText araEdit;





            public ExampleViewHolder(View itemView) {
                super(itemView);
               // mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
                mTextViewLikes = itemView.findViewById(R.id.text_view_likes);
                textView =  itemView.findViewById(R.id.text_iew_lik);
                araEdit =  itemView.findViewById(R.id.text_viw_ik);
            }
        }
    }


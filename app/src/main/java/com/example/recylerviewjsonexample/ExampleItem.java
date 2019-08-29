package com.example.recylerviewjsonexample;

public class ExampleItem {
    private String mImageUrl;

    private String mLikes;



    public ExampleItem(String Url,String likes) {
        mImageUrl = Url;

        mLikes = likes;

    }
    public String getImageUrl() {
        return mImageUrl;
    }




    public String getLikeCount() {
        return mLikes;
    }

}

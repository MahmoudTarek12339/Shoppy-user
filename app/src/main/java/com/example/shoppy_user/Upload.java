package com.example.shoppy_user;

import com.google.firebase.database.Exclude;

public class Upload {
    private String mName;
    private String mImageUrl;
    private String mPrice;
    private String mId;
    private String mRealPrice;
    private String mOffer;
    private String mKey;

    public Upload() {
    }

    public Upload(String mRealPrice, String mImageUrl ,String mName,String mOffer,String mPrice) {
        if(mName.trim().equals("")){
            mName="No Name";
        }
        this.mName = mName;
        this.mImageUrl = mImageUrl;
        this.mRealPrice = mRealPrice;
        this.mOffer = mOffer;
        this.mPrice = mPrice;

    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public String getRealPrice() {
        return mRealPrice;
    }

    public void setRealPrice(String mRealPrice) {
        this.mRealPrice = mRealPrice;
    }

    public String getOffer() {
        return mOffer;
    }

    public void setOffer(String mOffer) {
        this.mOffer = mOffer;
    }

    @Exclude
    public String getKey() {
        return mKey;
    }
    
    @Exclude
    public void setKey(String mKey) {
        this.mKey = mKey;
    }

    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}

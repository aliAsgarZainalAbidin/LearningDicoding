package com.example.myfriendsapp;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelFriend implements Parcelable {

    private String nama;
    private String hobi;
    private String ttl;
    private String desc;
    private int photo;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHobi() {
        return hobi;
    }

    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.hobi);
        dest.writeString(this.ttl);
        dest.writeString(this.desc);
        dest.writeInt(this.photo);
    }

    public ModelFriend() {
    }

    protected ModelFriend(Parcel in) {
        this.nama = in.readString();
        this.hobi = in.readString();
        this.ttl = in.readString();
        this.desc = in.readString();
        this.photo = in.readInt();
    }

    public static final Parcelable.Creator<ModelFriend> CREATOR = new Parcelable.Creator<ModelFriend>() {
        @Override
        public ModelFriend createFromParcel(Parcel source) {
            return new ModelFriend(source);
        }

        @Override
        public ModelFriend[] newArray(int size) {
            return new ModelFriend[size];
        }
    };
}

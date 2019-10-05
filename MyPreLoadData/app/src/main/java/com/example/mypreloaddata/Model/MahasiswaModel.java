package com.example.mypreloaddata.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class MahasiswaModel implements Parcelable {
    private int id;
    private String nama;
    private String nim;

    public MahasiswaModel() {
    }

    public MahasiswaModel(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nama);
        dest.writeString(this.nim);
    }

    protected MahasiswaModel(Parcel in) {
        this.id = in.readInt();
        this.nama = in.readString();
        this.nim = in.readString();
    }

    public static final Parcelable.Creator<MahasiswaModel> CREATOR = new Parcelable.Creator<MahasiswaModel>() {
        @Override
        public MahasiswaModel createFromParcel(Parcel source) {
            return new MahasiswaModel(source);
        }

        @Override
        public MahasiswaModel[] newArray(int size) {
            return new MahasiswaModel[size];
        }
    };
}

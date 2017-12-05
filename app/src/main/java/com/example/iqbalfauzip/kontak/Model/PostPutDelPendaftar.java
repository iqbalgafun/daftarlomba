package com.example.iqbalfauzip.kontak.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Iqbal Fauzi P on 06/12/2017.
 */

public class PostPutDelPendaftar {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Pendaftar mPendaftar;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Pendaftar getPendaftar() {
        return mPendaftar;
    }

    public void setPendaftar(Pendaftar Pendaftar) {
        mPendaftar = Pendaftar;
    }
}

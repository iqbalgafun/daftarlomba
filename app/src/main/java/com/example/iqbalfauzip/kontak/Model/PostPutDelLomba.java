package com.example.iqbalfauzip.kontak.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Iqbal Fauzi P on 06/12/2017.
 */

public class PostPutDelLomba {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Lomba mLomba;
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

    public Lomba getLomba() {
        return mLomba;
    }

    public void setLomba(Lomba Lomba) {
        mLomba = Lomba;
    }
}

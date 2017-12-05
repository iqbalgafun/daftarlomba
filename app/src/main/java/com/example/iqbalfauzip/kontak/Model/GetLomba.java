package com.example.iqbalfauzip.kontak.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Iqbal Fauzi P on 06/12/2017.
 */

public class GetLomba {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Lomba> listDataLomba;
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
    public List<Lomba> getListDataLomba() {
        return listDataLomba;
    }
    public void setListDataLomba(List<Lomba> listDataLomba) {
        this.listDataLomba = listDataLomba;
    }
}

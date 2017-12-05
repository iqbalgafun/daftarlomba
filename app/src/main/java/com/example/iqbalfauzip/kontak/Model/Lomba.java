package com.example.iqbalfauzip.kontak.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Iqbal Fauzi P on 06/12/2017.
 */

public class Lomba {
    @SerializedName("id")
    private String id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("cabang")
    private String cabang;
    @SerializedName("tgl")
    private String tgl;

    public Lomba(){}
    public Lomba(String id, String nama, String cabang, String tgl) {
        this.id = id;
        this.nama = nama;
        this.cabang = cabang;
        this.tgl = tgl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCabang() {
        return cabang;
    }

    public void setCabang(String cabang) {
        this.cabang = cabang;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }
}

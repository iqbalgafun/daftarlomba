package com.example.iqbalfauzip.kontak.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Iqbal Fauzi P on 06/12/2017.
 */

public class Pendaftar {
    @SerializedName("id")
    private String id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("ttl")
    private String ttl;

    public Pendaftar(){}
    public Pendaftar(String id, String nama, String alamat, String ttl) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.ttl = ttl;
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }
}


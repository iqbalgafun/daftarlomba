package com.example.iqbalfauzip.kontak.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Iqbal Fauzi P on 25/11/2017.
 */

public class Kontak {
    @SerializedName("pid")
    private String pid;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("description")
    private String description;

    public Kontak(){}
    public Kontak(String pid, String name, String email, String description) {
        this.pid = pid;
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

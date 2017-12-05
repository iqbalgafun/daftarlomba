package com.example.iqbalfauzip.kontak.Rest;

/**
 * Created by Iqbal Fauzi P on 25/11/2017.
 */

import com.example.iqbalfauzip.kontak.Model.GetKontak;
import com.example.iqbalfauzip.kontak.Model.GetPendaftar;
import com.example.iqbalfauzip.kontak.Model.GetLomba;
import com.example.iqbalfauzip.kontak.Model.PostPutDelKontak;
import com.example.iqbalfauzip.kontak.Model.PostPutDelPendaftar;
import com.example.iqbalfauzip.kontak.Model.PostPutDelLomba;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("pendaftaran")
    Call<GetKontak> getKontak();
    @FormUrlEncoded
    @POST("pendaftaran")
    Call<PostPutDelKontak> postKontak(@Field("pid") String pid,
                                      @Field("name") String name,
                                      @Field("email") String email,
                                      @Field("description")String description);
    @FormUrlEncoded
    @PUT("pendaftaran")
    Call<PostPutDelKontak> putKontak(@Field("pid") String pid,
                                     @Field("name") String name,
                                     @Field("email") String email,
                                     @Field("description") String description);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "pendaftaran", hasBody = true)
    Call<PostPutDelKontak> deleteKontak(@Field("pid") String pid);

    @GET("pendaftar")
    Call<GetPendaftar> getPendaftar();
    @FormUrlEncoded
    @POST("pendaftar")
    Call<PostPutDelPendaftar> postPendaftar(@Field("id") String id,
                                            @Field("nama") String nama,
                                            @Field("alamat") String alamat,
                                            @Field("ttl") String ttl);
    @FormUrlEncoded
    @PUT("pendaftar")
    Call<PostPutDelPendaftar> putPendaftar(@Field("id") String id,
                                     @Field("nama") String nama,
                                     @Field("alamat") String alamat,
                                     @Field("ttl") String ttl);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "pendaftar", hasBody = true)
    Call<PostPutDelPendaftar> deletePendaftar(@Field("id") String id);

    @GET("perlombaan")
    Call<GetLomba> getLomba();
    @FormUrlEncoded
    @POST("perlombaan")
    Call<PostPutDelLomba> postLomba(@Field("id") String id,
                                            @Field("nama") String nama,
                                            @Field("cabang") String cabang,
                                            @Field("tgl") String tgl);
    @FormUrlEncoded
    @PUT("perlombaan")
    Call<PostPutDelLomba> putLomba(@Field("id") String id,
                                           @Field("nama") String nama,
                                           @Field("cabang") String cabang,
                                           @Field("tgl") String tgl);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "perlombaan", hasBody = true)
    Call<PostPutDelLomba> deleteLomba(@Field("id") String id);
}
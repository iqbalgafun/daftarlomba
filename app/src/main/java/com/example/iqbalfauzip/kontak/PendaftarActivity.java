package com.example.iqbalfauzip.kontak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.iqbalfauzip.kontak.Adapter.PendaftarAdapter;
import com.example.iqbalfauzip.kontak.Model.GetPendaftar;
import com.example.iqbalfauzip.kontak.Model.Pendaftar;
import com.example.iqbalfauzip.kontak.Rest.ApiClient;
import com.example.iqbalfauzip.kontak.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendaftarActivity extends AppCompatActivity {

    Button btIns2;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static PendaftarActivity pa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftar);
        btIns2 = (Button) findViewById(R.id.btIns2);
        btIns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PendaftarActivity.this, InsertPendaftarActivity.class));
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        pa=this;
        refresh();
    }
    public void refresh() {
        Call<GetPendaftar> pendaftarCall = mApiInterface.getPendaftar();
        pendaftarCall.enqueue(new Callback<GetPendaftar>() {
            @Override
            public void onResponse(Call<GetPendaftar> call, Response<GetPendaftar>
                    response) {
                List<Pendaftar> PendaftarList = response.body().getListDataPendaftar();
                Log.d("Retrofit Get", "Jumlah data Pendaftar: " +
                        String.valueOf(PendaftarList.size()));
                mAdapter = new PendaftarAdapter(PendaftarList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetPendaftar> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}

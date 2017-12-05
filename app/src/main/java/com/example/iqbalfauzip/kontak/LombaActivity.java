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

import com.example.iqbalfauzip.kontak.Adapter.LombaAdapter;
import com.example.iqbalfauzip.kontak.Model.GetLomba;
import com.example.iqbalfauzip.kontak.Model.Lomba;
import com.example.iqbalfauzip.kontak.Rest.ApiClient;
import com.example.iqbalfauzip.kontak.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LombaActivity extends AppCompatActivity {

    Button btIns3;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static LombaActivity la;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lomba);

        btIns3 = (Button) findViewById(R.id.btIns3);
        btIns3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LombaActivity.this, InsertLombaActivity.class));
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView3);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        la=this;
        refresh();
    }
    public void refresh() {
        Call<GetLomba> LombaCall = mApiInterface.getLomba();
        LombaCall.enqueue(new Callback<GetLomba>() {
            @Override
            public void onResponse(Call<GetLomba> call, Response<GetLomba>
                    response) {
                List<Lomba> LombaList = response.body().getListDataLomba();
                Log.d("Retrofit Get", "Jumlah data Lomba: " +
                        String.valueOf(LombaList.size()));
                mAdapter = new LombaAdapter(LombaList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetLomba> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });

    }
}

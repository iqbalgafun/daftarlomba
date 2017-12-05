package com.example.iqbalfauzip.kontak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iqbalfauzip.kontak.Model.PostPutDelPendaftar;
import com.example.iqbalfauzip.kontak.Rest.ApiClient;
import com.example.iqbalfauzip.kontak.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertPendaftarActivity extends AppCompatActivity {

    EditText edtId, edtNama, edtAlamat, edtTtl;
    Button btInsert, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_pendaftar);

        edtId = (EditText)findViewById(R.id.edtId);
        edtNama = (EditText) findViewById(R.id.edtNama);
        edtAlamat = (EditText) findViewById(R.id.edtAlamat);
        edtTtl = (EditText) findViewById(R.id.edtTtl);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInserting);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelPendaftar> postKontakCall = mApiInterface.postPendaftar(edtId.getText().toString(),edtNama.getText().toString(), edtAlamat.getText().toString(), edtTtl.getText().toString());
                postKontakCall.enqueue(new Callback<PostPutDelPendaftar>() {
                    @Override
                    public void onResponse(Call<PostPutDelPendaftar> call, Response<PostPutDelPendaftar> response) {
                        PendaftarActivity.pa.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelPendaftar> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PendaftarActivity.pa.refresh();
                finish();
            }
        });
    }
}

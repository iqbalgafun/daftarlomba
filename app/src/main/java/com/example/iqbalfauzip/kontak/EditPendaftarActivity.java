package com.example.iqbalfauzip.kontak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class EditPendaftarActivity extends AppCompatActivity {

    EditText edtId, edtNama, edtAlamat, edtTtl;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pendaftar);
        edtId = (EditText) findViewById(R.id.edtId);
        edtNama = (EditText) findViewById(R.id.edtNama);
        edtAlamat = (EditText) findViewById(R.id.edtAlamat);
        edtTtl = (EditText) findViewById(R.id.edtTtl);
        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtNama.setText(mIntent.getStringExtra("Nama"));
        edtAlamat.setText(mIntent.getStringExtra("Alamat"));
        edtTtl.setText(mIntent.getStringExtra("Ttl"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelPendaftar> updatePendaftarCall = mApiInterface.putPendaftar(
                        edtId.getText().toString(),
                        edtNama.getText().toString(),
                        edtAlamat.getText().toString(),
                        edtTtl.getText().toString());
                updatePendaftarCall.enqueue(new Callback<PostPutDelPendaftar>() {
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
        btDelete = (Button) findViewById(R.id.btDelete2);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelPendaftar> deletePendaftar = mApiInterface.deletePendaftar(edtId.getText().toString());
                    deletePendaftar.enqueue(new Callback<PostPutDelPendaftar>() {
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
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
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

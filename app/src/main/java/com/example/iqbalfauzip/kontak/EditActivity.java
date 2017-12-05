package com.example.iqbalfauzip.kontak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iqbalfauzip.kontak.Model.PostPutDelKontak;
import com.example.iqbalfauzip.kontak.Rest.ApiClient;
import com.example.iqbalfauzip.kontak.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {
    EditText edtPid, edtName, edtEmail, edtDescription;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edtPid = (EditText) findViewById(R.id.edtPid);
        edtName = (EditText) findViewById(R.id.edtName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtDescription = (EditText) findViewById(R.id.edtDescription);
        Intent mIntent = getIntent();
        edtPid.setText(mIntent.getStringExtra("Pid"));
        edtPid.setTag(edtPid.getKeyListener());
        edtPid.setKeyListener(null);
        edtName.setText(mIntent.getStringExtra("Name"));
        edtEmail.setText(mIntent.getStringExtra("Email"));
        edtDescription.setText(mIntent.getStringExtra("Description"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelKontak> updateKontakCall = mApiInterface.putKontak(
                        edtPid.getText().toString(),
                        edtName.getText().toString(),
                        edtEmail.getText().toString(),
                        edtDescription.getText().toString());
                updateKontakCall.enqueue(new Callback<PostPutDelKontak>() {
                    @Override
                    public void onResponse(Call<PostPutDelKontak> call, Response<PostPutDelKontak> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelKontak> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btDelete = (Button) findViewById(R.id.btDelete2);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtPid.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelKontak> deleteKontak = mApiInterface.deleteKontak(edtPid.getText().toString());
                    deleteKontak.enqueue(new Callback<PostPutDelKontak>() {
                        @Override
                        public void onResponse(Call<PostPutDelKontak> call, Response<PostPutDelKontak> response) {
                            MainActivity.ma.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelKontak> call, Throwable t) {
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
                MainActivity.ma.refresh();
                finish();
            }
        });
    }
}

package com.example.iqbalfauzip.kontak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iqbalfauzip.kontak.Model.PostPutDelKontak;
import com.example.iqbalfauzip.kontak.Rest.ApiClient;
import com.example.iqbalfauzip.kontak.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
    EditText edtPid, edtName, edtEmail, edtDescription;
    Button btInsert, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        edtPid = (EditText)findViewById(R.id.edtPid);
        edtName = (EditText) findViewById(R.id.edtName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtDescription = (EditText) findViewById(R.id.edtDescription);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInserting);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelKontak> postKontakCall = mApiInterface.postKontak(edtPid.getText().toString(),edtName.getText().toString(), edtEmail.getText().toString(), edtDescription.getText().toString());
                postKontakCall.enqueue(new Callback<PostPutDelKontak>() {
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

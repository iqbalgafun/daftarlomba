package com.example.iqbalfauzip.kontak.Adapter;

/**
 * Created by Iqbal Fauzi P on 06/12/2017.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iqbalfauzip.kontak.EditPendaftarActivity;
import com.example.iqbalfauzip.kontak.Model.Pendaftar;
import com.example.iqbalfauzip.kontak.R;

import java.util.List;

public class PendaftarAdapter extends RecyclerView.Adapter<PendaftarAdapter.MyViewHolder>{
    List<Pendaftar> mPendaftarList;

    public PendaftarAdapter(List <Pendaftar> PendaftarList) {
        mPendaftarList = PendaftarList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pendaftar_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewId.setText("Id = " + mPendaftarList.get(position).getId());
        holder.mTextViewNama.setText("Nama = " + mPendaftarList.get(position).getNama());
        holder.mTextViewAlamat.setText("Alamat = " + mPendaftarList.get(position).getAlamat());
        holder.mTextViewTtl.setText("TTL = " + mPendaftarList.get(position).getTtl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditPendaftarActivity.class);
                mIntent.putExtra("Id", mPendaftarList.get(position).getId());
                mIntent.putExtra("Nama", mPendaftarList.get(position).getNama());
                mIntent.putExtra("Alamat", mPendaftarList.get(position).getAlamat());
                mIntent.putExtra("TTL", mPendaftarList.get(position).getTtl());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mPendaftarList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewAlamat, mTextViewTtl;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
            mTextViewAlamat = (TextView) itemView.findViewById(R.id.tvAlamat);
            mTextViewTtl = (TextView) itemView.findViewById(R.id.tvTtl);
        }
    }
}

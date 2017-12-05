package com.example.iqbalfauzip.kontak.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iqbalfauzip.kontak.EditLombaActivity;
import com.example.iqbalfauzip.kontak.Model.Lomba;
import com.example.iqbalfauzip.kontak.R;

import java.util.List;

/**
 * Created by Iqbal Fauzi P on 06/12/2017.
 */

public class LombaAdapter extends RecyclerView.Adapter<LombaAdapter.MyViewHolder>{
    List<Lomba> mLombaList;

    public LombaAdapter(List <Lomba> LombaList) {
        mLombaList = LombaList;
    }

    @Override
    public LombaAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lomba_list, parent, false);
        LombaAdapter.MyViewHolder mViewHolder = new LombaAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (LombaAdapter.MyViewHolder holder, final int position){
        holder.mTextViewId.setText("Id = " + mLombaList.get(position).getId());
        holder.mTextViewNama.setText("Nama = " + mLombaList.get(position).getNama());
        holder.mTextViewCabang.setText("Cabang = " + mLombaList.get(position).getCabang());
        holder.mTextViewTgl.setText("TGL = " + mLombaList.get(position).getTgl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditLombaActivity.class);
                mIntent.putExtra("Id", mLombaList.get(position).getId());
                mIntent.putExtra("Nama", mLombaList.get(position).getNama());
                mIntent.putExtra("Cabang", mLombaList.get(position).getCabang());
                mIntent.putExtra("TGL", mLombaList.get(position).getTgl());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mLombaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewCabang, mTextViewTgl;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
            mTextViewCabang = (TextView) itemView.findViewById(R.id.tvCabang);
            mTextViewTgl = (TextView) itemView.findViewById(R.id.tvTgl);
        }
    }
}
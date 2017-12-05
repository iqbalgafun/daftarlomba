package com.example.iqbalfauzip.kontak.Adapter;

/**
 * Created by Iqbal Fauzi P on 25/11/2017.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iqbalfauzip.kontak.EditActivity;
import com.example.iqbalfauzip.kontak.Model.Kontak;
import com.example.iqbalfauzip.kontak.R;

import java.util.List;

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.MyViewHolder>{
    List<Kontak> mKontakList;

    public KontakAdapter(List <Kontak> KontakList) {
        mKontakList = KontakList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.kontak_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewPid.setText("Id = " + mKontakList.get(position).getPid());
        holder.mTextViewName.setText("Name = " + mKontakList.get(position).getName());
        holder.mTextViewEmail.setText("Email = " + mKontakList.get(position).getEmail());
        holder.mTextViewDescription.setText("Description = " + mKontakList.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Pid", mKontakList.get(position).getPid());
                mIntent.putExtra("Name", mKontakList.get(position).getName());
                mIntent.putExtra("Email", mKontakList.get(position).getEmail());
                mIntent.putExtra("Description", mKontakList.get(position).getDescription());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mKontakList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewPid, mTextViewName, mTextViewEmail, mTextViewDescription;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewPid = (TextView) itemView.findViewById(R.id.tvPid);
            mTextViewName = (TextView) itemView.findViewById(R.id.tvName);
            mTextViewEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            mTextViewDescription = (TextView) itemView.findViewById(R.id.tvDescription);
        }
    }
}

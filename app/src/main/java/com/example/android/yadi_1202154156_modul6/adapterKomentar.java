package com.example.android.yadi_1202154156_modul6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



public class adapterKomentar extends RecyclerView.Adapter<adapterKomentar.CommentHolder>{
    Context con;
    List<databaseKomentar> list;

    public adapterKomentar(Context con, List<databaseKomentar> list) {
        this.con = con;
        this.list = list;
    }
    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentHolder(LayoutInflater.from(con).inflate(R.layout.comment, parent, false));
    }

    @Override
    public void onBindViewHolder(CommentHolder holder, int position) {
        databaseKomentar cur = list.get(position);
        holder.sikomen.setText(cur.getSikomen());
        holder.komen.setText(cur.getKomen());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CommentHolder extends RecyclerView.ViewHolder {
        TextView sikomen, komen;
        public CommentHolder(View itemView) {
            super(itemView);
            sikomen = itemView.findViewById(R.id.yangkomen);
            komen = itemView.findViewById(R.id.komen);
        }
    }
}

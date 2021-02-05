

package com.example.wifiauthentication;

import android.app.Dialog;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.wifiauthentication.ApplyFragment.preferences;

public class RecyclerAdapter extends RecyclerView.Adapter< RecyclerAdapter.ViewHolder> {
        RecyclerView recyclerView;

    private static final String TAG = "RecyclerAdapter";
    List<String> moviesList;
    public RecyclerAdapter(ApplyFragment applyFragment, List< String > moviesList) {
        this.moviesList = moviesList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(moviesList.get(position));

        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (preferences.getInt("pos",0) == position) {
                    Log.e("kfbnfkbnfknb", "onClick: if");
                    holder.itemView.setBackgroundColor(Color.RED);
//                            tv_pakg_price.setTextColor(Color.parseColor("#FF03DAC5"));
                    notifyDataSetChanged();
                } else {
                    Log.e("kfbnfkbnfknb", "onClick: else");
                    holder.itemView.setBackgroundColor(Color.RED);
                    notifyDataSetChanged();
                }



            }
        } );

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            textView = itemView.findViewById(R.id.textView);

        }
    }
}


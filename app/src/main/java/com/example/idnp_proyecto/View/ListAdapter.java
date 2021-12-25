package com.example.idnp_proyecto.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.idnp_proyecto.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<Ruta> mRutas;
    private LayoutInflater mInflater;
    private Context context;
    private boolean invitado = true;
    final ListAdapter.OnItemClickListener listener;

    public  interface OnItemClickListener{
        void onItemClick(Ruta item);
    }

    public ListAdapter(List<Ruta> itemList, Context context,ListAdapter.OnItemClickListener listener, boolean invitado){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mRutas = itemList;
        this.listener = listener;
        this.invitado = invitado;
    }

    public ListAdapter(List<Ruta> itemList, Context context,ListAdapter.OnItemClickListener listener){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mRutas = itemList;
        this.listener = listener;
    }


    @Override
    public int getItemCount(){
        return mRutas.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_rutas, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(mRutas.get(position));
    }

    public void setItems(List<Ruta> items){
        mRutas = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView empresa,ruta,horario;
        ImageButton favorito;

        ViewHolder(View itemView){
            super(itemView);
            favorito = itemView.findViewById(R.id.favButton);
            iconImage = itemView.findViewById(R.id.iconImageView);
            empresa = itemView.findViewById(R.id.textEmpresa);
            ruta = itemView.findViewById(R.id.textRuta);
            horario = itemView.findViewById(R.id.textHorario);
        }

        void bindData(final Ruta item){
            empresa.setText(item.getEmpresa());
            ruta.setText(item.getLetraRuta());
            horario.setText(item.getHorario());
            if(item.getFavorito()){
                favorito.setImageResource(R.drawable.starblack);
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });

            favorito.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    //Agregar o quitar de favoritos en bd
                    Toast.makeText(view.getContext(), item.getEmpresa(), Toast.LENGTH_SHORT).show();
                    if(!item.getFavorito()){
                        item.setFavorito(true);
                        favorito.setImageResource(R.drawable.starblack);
                    }
                    else{
                        item.setFavorito(false);
                        favorito.setImageResource(R.drawable.starborder);
                    }
                }
            });

            if(invitado){
                favorito.setEnabled(false);
            }
        }
    }
}

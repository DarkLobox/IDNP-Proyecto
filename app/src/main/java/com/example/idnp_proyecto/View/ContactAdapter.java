package com.example.idnp_proyecto.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idnp_proyecto.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{
    private List<Contacto> mContactos;
    private LayoutInflater mInflater;
    private Context context;
    private boolean invitado;

    public ContactAdapter(List<Contacto> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mContactos = itemList;
    }


    @Override
    public int getItemCount(){
        return mContactos.size();
    }

    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_contact, null);
        return new ContactAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mContactos.get(position));
    }


    public void setItems(List<Contacto> items){
        mContactos = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView nombre,correo,contacto;

        ViewHolder(View itemView){
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView2);
            nombre = itemView.findViewById(R.id.textNombre);
            correo = itemView.findViewById(R.id.textCorreo);
            contacto = itemView.findViewById(R.id.textContacto);
        }

        void bindData(final Contacto item){
            nombre.setText(item.getNombre());
            correo.setText(item.getCorreo());
            contacto.setText("Cel: "+item.getNumero());

        }
    }
}

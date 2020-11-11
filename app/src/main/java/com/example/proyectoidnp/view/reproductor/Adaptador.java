package com.example.proyectoidnp.view.reproductor;
import com.example.proyectoidnp.model.reproductor.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoidnp.R;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    List<reproductorModelo> lista;

    public Adaptador(List<reproductorModelo> lista) {
        this.lista = lista;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView foto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.textoCuadro);
            foto = (ImageView)itemView.findViewById(R.id.imagenCuadro);
        }

    }
    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {
        holder.textView.setText(lista.get(position).getNombre());
        holder.foto.setImageResource(lista.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}

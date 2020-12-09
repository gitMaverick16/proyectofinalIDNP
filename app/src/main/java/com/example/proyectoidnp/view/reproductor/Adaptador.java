package com.example.proyectoidnp.view.reproductor;
import com.example.proyectoidnp.R;
import com.example.proyectoidnp.model.reproductor.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> implements View.OnClickListener {
    ArrayList<reproductorModelo> listaReproductor;
    private View.OnClickListener listener;

    public Adaptador(ArrayList<reproductorModelo> lista) {
        this.listaReproductor = lista;
    }
    @Override
    public void onClick(View view) {
        if(listener !=null){
            listener.onClick(view);
        }
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
        view.setOnClickListener(this);//escucha
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {
        holder.textView.setText(listaReproductor.get(position).getNombre());
        holder.foto.setImageResource(listaReproductor.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaReproductor.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
}

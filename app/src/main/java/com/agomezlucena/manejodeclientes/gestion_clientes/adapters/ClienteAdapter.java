package com.agomezlucena.manejodeclientes.gestion_clientes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agomezlucena.manejodeclientes.R;
import com.agomezlucena.manejodeclientes.gestion_clientes.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder> {

    private List<Cliente>   clientes;

    public ClienteAdapter(){
        super();
        clientes = new ArrayList<>();
    }

    @NonNull
    @Override
    public ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new ClienteViewHolder(
                    LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cliente_card,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteViewHolder holder, final int position) {
        holder.bindData(clientes.get(position));
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public void añadirCliente (Cliente c){
        clientes.add(c);
        notifyItemInserted(clientes.indexOf(c));
    }

    public static class ClienteViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre,apellido,edad;

        public ClienteViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_card_cliente);
            apellido = itemView.findViewById(R.id.apellido_card_cliente);
            edad = itemView.findViewById(R.id.edad_card_cliente);
        }

        public void bindData (Cliente c){
            nombre.setText(c.getNombre());
            apellido.setText(c.getApellido());
            edad.setText(String.valueOf(c.getEdad()));
        }

    }
}

package com.agomezlucena.manejodeclientes.gestion_clientes.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agomezlucena.manejodeclientes.R;
import com.agomezlucena.manejodeclientes.gestion_clientes.Cliente;
import com.agomezlucena.manejodeclientes.gestion_clientes.adapters.ClienteAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisionadoDeClientesFragment extends Fragment {
    private RecyclerView listaDeClientes;
    private ClienteAdapter adapatador;

    public VisionadoDeClientesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.visionado_clientes_fragment,container,false);
        listaDeClientes = v.findViewById(R.id.lista_de_clientes_visionado_de_clientes_fragment);
        adapatador = new ClienteAdapter();
        listaDeClientes.setLayoutManager(new LinearLayoutManager(getActivity()));
        listaDeClientes.setAdapter(adapatador);
        return v;
    }

    public void añadirCliente(Cliente u){
        adapatador.añadirCliente(u);
    }

}

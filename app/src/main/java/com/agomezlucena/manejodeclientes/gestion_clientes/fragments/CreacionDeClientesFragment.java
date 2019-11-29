package com.agomezlucena.manejodeclientes.gestion_clientes.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.agomezlucena.manejodeclientes.R;
import com.agomezlucena.manejodeclientes.gestion_clientes.Cliente;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class CreacionDeClientesFragment extends Fragment {

    private TextInputEditText nombre,apellido,edad;
    private ConectorFragments conexionConVisionado;

    public CreacionDeClientesFragment(){

    }
    
    public CreacionDeClientesFragment(ConectorFragments conexionConVisionado){
        this.conexionConVisionado = conexionConVisionado;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.creacion_clientes_fragment,container,false);
        nombre = v.findViewById(R.id.nombre_creacion_de_clientes_fragment);
        apellido = v.findViewById(R.id.apellido_creacion_de_clientes_fragment);
        edad = v.findViewById(R.id.edad_creacion_de_clientes_fragment);
        v.findViewById(R.id.crear_cliente_creacion_de_clientes_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nombre.length() == 0 || apellido.length() == 0 || edad.length() == 0){
                    Snackbar.make(nombre,"Alguno de los campos está vacio",Snackbar.LENGTH_SHORT).show();
                } else{
                    String  nombre = CreacionDeClientesFragment.this.nombre.getText().toString(),
                            apellido = CreacionDeClientesFragment.this.apellido.getText().toString();

                    int     edad = Integer.valueOf(
                            CreacionDeClientesFragment.this.edad.getText().toString()
                    );

                    conexionConVisionado.enviarCliente(new Cliente(nombre,apellido,edad));
                }
            }
        });
        return v;
    }
}

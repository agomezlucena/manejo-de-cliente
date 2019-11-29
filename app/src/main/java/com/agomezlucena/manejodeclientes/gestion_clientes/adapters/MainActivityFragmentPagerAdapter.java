package com.agomezlucena.manejodeclientes.gestion_clientes.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.agomezlucena.manejodeclientes.R;
import com.agomezlucena.manejodeclientes.gestion_clientes.Cliente;
import com.agomezlucena.manejodeclientes.gestion_clientes.fragments.ConectorFragments;
import com.agomezlucena.manejodeclientes.gestion_clientes.fragments.CreacionDeClientesFragment;
import com.agomezlucena.manejodeclientes.gestion_clientes.fragments.VisionadoDeClientesFragment;

public class MainActivityFragmentPagerAdapter extends FragmentPagerAdapter implements ConectorFragments {

    private Fragment[]  fragmentos = new Fragment[]{new VisionadoDeClientesFragment(),new CreacionDeClientesFragment(this)};
    private int[]       titulos = new int[]{R.string.visionado,R.string.creacion};
    private Context     contexto;

    public MainActivityFragmentPagerAdapter(@NonNull FragmentManager fm, Context contexto) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentos[position];
    }

    @Override
    public int getCount() {
        return fragmentos.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return contexto.getString(titulos[position]);
    }

    @Override
    public void enviarCliente(Cliente u) {
        VisionadoDeClientesFragment fragmentoAComunicar =  (VisionadoDeClientesFragment)fragmentos[0];
        fragmentoAComunicar.añadirCliente(u);
    }
}

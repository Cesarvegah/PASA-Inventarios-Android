package pasa.inventarios.com.pasa_inventarios;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class Fragment_Home extends Fragment implements View.OnClickListener
{
    private Button btnAcceder;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment__home, container, false);
        btnAcceder = (Button) rootView.findViewById(R.id.btn_AgregarDatos);
        btnAcceder.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        /*que cargue por defecto home en otro caso seria verificar*/
        Fragment_DataUpload Fragment = new Fragment_DataUpload();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,Fragment);
        fragmentTransaction.commit();
    }
}
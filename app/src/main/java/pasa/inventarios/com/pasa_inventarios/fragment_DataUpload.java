package pasa.inventarios.com.pasa_inventarios;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentContainer;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.EditText;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Fragment_DataUpload extends Fragment implements View.OnClickListener {

    Spinner spn_TipoEquipo;
    Spinner spn_Almacen;
    Button btn_Crear;
    Button btn_Escanear;
    ArrayAdapter<String> adap_TipoEquipo;
    ArrayAdapter<String> adap_Almacen;
    final List<String> list_TipoEquipo = new ArrayList<String>();
    final List<String> list_Almacen = new ArrayList<String>();


    EditText textIn;
    Button buttonAdd;
    RelativeLayout container;
    View addView;


    public Fragment_DataUpload() {

        list_TipoEquipo.add("Item 1");
        list_TipoEquipo.add("Item 2");
        list_TipoEquipo.add("Item 3");
        list_TipoEquipo.add("Item 4");
        list_TipoEquipo.add("Item 5");

        list_Almacen.add("Item 1");
        list_Almacen.add("Item 2");
        list_Almacen.add("Item 3");
        list_Almacen.add("Item 4");
        list_Almacen.add("Item 5");
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                                                        @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment__data_upload, container,false);
        FrameLayout frameLayout = new FrameLayout(getActivity());

        spn_TipoEquipo = (Spinner) rootView.findViewById(R.id.spn_TipoEquipo);
        adap_TipoEquipo = new ArrayAdapter<String>(this.getActivity(),
                                            android.R.layout.simple_spinner_item, list_TipoEquipo);
        adap_TipoEquipo.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spn_TipoEquipo.setAdapter(adap_TipoEquipo);

        spn_Almacen = (Spinner) rootView.findViewById(R.id.spn_Almacen);
        adap_Almacen = new ArrayAdapter<String>(this.getActivity(),
                                                android.R.layout.simple_spinner_item, list_Almacen);
        adap_Almacen.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spn_Almacen.setAdapter(adap_Almacen);
        btn_Escanear = (Button) rootView.findViewById(R.id.btn_Escanear);
        btn_Escanear.setEnabled(false);
        btn_Escanear.setOnClickListener(this);
        /*
        btn_Crear = (Button) rootView.findViewById(R.id.btn_AgregarCajas);
        btn_Crear.setOnClickListener(this);
        */

        textIn = (EditText)rootView.findViewById(R.id.edit_Cantidad);
        buttonAdd = (Button)rootView.findViewById(R.id.btn_AgregarCajas);
        container = (LinearLayout)rootView.findViewById(R.id.lin_AddEditTextEscaner);
        final ViewGroup finalContainer = container;

        btn_Escanear = (Button) rootView.findViewById(R.id.btn_Escanear);
        btn_Escanear.setOnClickListener(this);
        /*
        btn_Escanear.setEnabled(false);
        if (finalContainer.getChildCount() != 0){
            btn_Escanear.setEnabled(true);
        }
        */
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textIn.getText().toString().equals("")){

                    for (int i = 0; i < Integer.parseInt(textIn.getText().toString()); i++) {

                        LayoutInflater layoutInflater =
                                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        addView = layoutInflater.inflate(R.layout.fragment_row, null);
                        TextView textOut = (TextView) addView.findViewById(R.id.editext_BarCode);
                    /*
                    Button buttonRemove = (Button)addView.findViewById(R.id.remove);
                    buttonRemove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ((LinearLayout)addView.getParent()).removeView(addView);
                        }
                    });
                    */
                        finalContainer.addView(addView);
                    }
                } else{
                    Toast.makeText(v.getContext(),
                            "Introduce un Número", Toast.LENGTH_LONG).show();
                    textIn.requestFocus();

                }


            }
        });
        return rootView;
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(v.getContext(),
                "Soy un mensaje de prueba", Toast.LENGTH_SHORT).show();

        /*
        ViewGroup layout;
        layout = (ViewGroup) v.findViewById(R.id.lin_AddEditTextEscaner);

        LayoutInflater inflater = LayoutInflater.from(v.getContext());
        int id = R.layout.fragment__data_upload;

        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(id, null, false);
        TextView tv_BarCode = new TextView(v.getContext());
        tv_BarCode.setText("Hola");
        layout.addView(tv_BarCode);
        */
    }
}
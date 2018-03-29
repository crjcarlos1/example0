package droid.demos.com.preferences.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import droid.demos.com.preferences.R;

/**
 * Created by carlos on 14/03/2018.
 */

public class FragmentA extends Fragment implements View.OnClickListener {

    public static final String TAG=FragmentA.class.getSimpleName();

    private EditText edtUser,edtPassword;
    private Button btnSave,btnSend;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_a,container,false);

        edtUser=(EditText)view.findViewById(R.id.edtUser);
        edtPassword=(EditText)view.findViewById(R.id.edtPassword);
        btnSave=(Button)view.findViewById(R.id.btnSaveData);
        btnSend=(Button)view.findViewById(R.id.btnSend);

        btnSave.setOnClickListener(this);
        btnSend.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnSaveData:
                saveData();
                break;
            case R.id.btnSend:
                showFragmentB();
                break;
        }
    }

    private void saveData()
    {
        String user=edtUser.getText().toString();
        String password=edtPassword.getText().toString();

        //                                                                name: NombreArchivoPreferencias
        SharedPreferences preferences=getActivity().getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();

        editor.putString("user",user);
        editor.putString("password",password);
        editor.commit();

        Toast.makeText(getContext(),"Datos salvados",Toast.LENGTH_LONG).show();
    }

    private void showFragmentB()
    {
        FragmentManager manager=getActivity().getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();

        FragmentB fragmentB=new FragmentB();

        transaction.addToBackStack(FragmentB.TAG);
        transaction.replace(R.id.conteinerFragments,fragmentB,FragmentB.TAG).commit();
    }

}

package droid.demos.com.preferences.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import droid.demos.com.preferences.R;

/**
 * Created by carlos on 14/03/2018.
 */

public class FragmentB extends Fragment {

    public static final String TAG=FragmentB.class.getSimpleName();
    private TextView txvResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_b,container,false);

        txvResult=(TextView)view.findViewById(R.id.txvResult);
        getPreferences();

        return view;
    }

    private void getPreferences()
    {
        SharedPreferences preferences=getActivity().getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        String user=preferences.getString("user","sin usuario");
        String password=preferences.getString("password","sin password");
        txvResult.setText("User: "+user+"\nPassword: "+password);
    }

}

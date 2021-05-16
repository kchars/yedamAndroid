package com.example.myfrag;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class LoginFragment extends Fragment {
    Button btnLogin;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.login_fragment, container, false);

        btnLogin = rootView.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "로그인됨", Toast.LENGTH_SHORT).show();
            
        });
        return rootView;
    }
}

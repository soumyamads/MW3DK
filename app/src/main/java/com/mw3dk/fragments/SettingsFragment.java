package com.mw3dk.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.mw3dk.R;
import com.mw3dk.activity.Upcoming_Activity;
import com.mw3dk.extras.Constants;

import butterknife.ButterKnife;

/**
 * Created by snyxius on 5/5/16.
 */
public class SettingsFragment extends Fragment implements View.OnClickListener{

//            @Optional @InjectView(R.id.spinner1) Spinner spinner1;
//    @Optional @InjectView(R.id.spinner2) Spinner spinner2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.settingscontent, container, false);

        ButterKnife.inject(this, rootView);
        return rootView;
    }


    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.profile).setOnClickListener(this);
       view. findViewById(R.id.paswd).setOnClickListener(this);
       view. findViewById(R.id.notifictn).setOnClickListener(this);
        view.findViewById(R.id.demographic).setOnClickListener(this);
        view.findViewById(R.id.authorizatn).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.profile:

                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(R.id.container_drawer, new ProfileFragment(), Constants.APPOINTMENT)
                        .commit();
                break;

            case R.id.paswd:

                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(R.id.container_drawer, new PasswordFragment(), Constants.APPOINTMENT)
                        .commit();
                break;
            case R.id.notifictn:

                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(R.id.container_drawer, new NotificationSettingsFragment(), Constants.APPOINTMENT)
                        .commit();
                break;
            case R.id.demographic:

                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(R.id.container_drawer, new DemographicFragment(), Constants.APPOINTMENT)
                        .commit();
                break;
            case R.id.authorizatn:

               getActivity(). getSupportFragmentManager().beginTransaction()
                        .add(R.id.container_drawer, new AuthorizationsFragment(), Constants.APPOINTMENT)
                        .commit();
                break;

        }
    }
}

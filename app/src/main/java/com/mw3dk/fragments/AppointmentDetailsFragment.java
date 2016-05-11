package com.mw3dk.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mw3dk.R;
import com.mw3dk.extras.Constants;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;


/**
 * Created by snyxius on 10/15/2015.
 */
public class AppointmentDetailsFragment extends Fragment implements View.OnClickListener{

//            @Optional
//            @InjectView(R.id.addnewpatient)
            TextView adddpatient;
            View views,patientlayout;
            Button bookagain;
//    @Optional @InjectView(R.id.spinner2) Spinner spinner2;

//
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try {
//            mCallback = (StepOneStroke) activity;
//            passData = (PassData)activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement DataPassListener");
//        }
//    }
//
//

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.appointment_details, container, false);

        ButterKnife.inject(this,rootView);
        return rootView;
    }


    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bookagain=(Button)view.findViewById(R.id.bookagainbtn);
        views=(View)view.findViewById(R.id.view);
        patientlayout=(View)view.findViewById(R.id.addnewpatientlayout);
        adddpatient=(TextView)view.findViewById(R.id.addnewpatient);

            view.findViewById(R.id.addnewpatient).setOnClickListener(this);
        view.findViewById(R.id.continuebtn).setOnClickListener(this);

        view.findViewById(R.id.bookagainbtn).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bookagainbtn:
            case R.id.continuebtn:

                getActivity(). getSupportFragmentManager().beginTransaction()
                        .add(R.id.container_book,new DetailsFragment(), Constants.APPOINTMENT)
                        .commit();

                break;
            case R.id.addnewpatient:
                adddpatient.setVisibility(View.GONE);
                bookagain.setVisibility(View.GONE);
                views.setVisibility(View.GONE);
                patientlayout.setVisibility(View.VISIBLE);

                break;


        }
    }



}

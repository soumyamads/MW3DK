package com.mw3dk.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mw3dk.R;

import butterknife.ButterKnife;

/**
 * Created by snyxius on 5/5/16.
 */
public class ProfessionalFragment extends Fragment implements View.OnClickListener{

//            @Optional @InjectView(R.id.spinner1) Spinner spinner1;
//    @Optional @InjectView(R.id.spinner2) Spinner spinner2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.professionalstatement, container, false);

        ButterKnife.inject(this, rootView);
        return rootView;
    }


    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }


    @Override
    public void onClick(View v) {
       /* switch (v.getId()) {
            case R.id.continue_button:
                validate();
//               sendBasicData();
                break;
            case R.id.select_business_layout:
                passData.setBusinessData(business_text.getText().toString());
                break;

            case R.id.quickimage:

                DialogFragment dialogFrag = QuickDescriptionDialogFragment.newInstance();
                dialogFrag.setCancelable(false);
                dialogFrag.show(getFragmentManager().beginTransaction(), Constants.SUCCESSDIALOG_FRAGMENT);
                break;
            case R.id.template:
            case R.id.templates:


                FragmentManager manager = getFragmentManager();

                TempFragment dialog = new TempFragment();
                dialog.show(manager, "stepOne");

                break;

        }*/
    }

}

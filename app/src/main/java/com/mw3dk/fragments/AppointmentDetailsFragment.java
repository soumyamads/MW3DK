package com.mw3dk.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mw3dk.R;
import com.mw3dk.activity.AddPatient;
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

            view.findViewById(R.id.addnewpatient).setOnClickListener(this);
        view.findViewById(R.id.bookagainbtn).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bookagainbtn:
                getActivity(). getSupportFragmentManager().beginTransaction()
                        .add(R.id.container_book,new DetailsFragment(), Constants.APPOINTMENT)
                        .commit();
                break;
/*            case R.id.select_business_layout:
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

                break;*/

        }
    }


//    public void getTemplateSelected(String content) {
//        fullDescription.setText(content);
//
//    }
//
//    public interface StepOneStroke {
//        void setStepTwoStoke();
//        void sendStepOneData(JSONObject jsonObject);
//    }
//
//    public interface PassData{
//        void setBusinessData(String string);
//    }
//
//
//
//    public void validate(){
//        if(deal_name.getText().toString().isEmpty()){
//            DealWithItApp.showAToast("Please select the Deal Name");
//        }else if(business_text.getText().toString().isEmpty()){
//            DealWithItApp.showAToast("Please select the Business Type");
//        }else if(quickDescription.getText().toString().isEmpty()){
//            DealWithItApp.showAToast("Please give the Quick Description");
//        }else if(fullDescription.getText().toString().isEmpty()) {
//            DealWithItApp.showAToast("Please give the Full Description");
//        }
//        else{
//            sendBasicData();
//        }
//    }
//
//
//    private void sendBasicData(){
//        try{
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.accumulate(Keys.deal_name, deal_name.getText().toString());
//            JSONArray jsonArray = new JSONArray(arrayListBusinessProfileIds);
//            jsonObject.accumulate(Keys.businessprofilesIds, jsonArray);
//            JSONArray jsonArray1 = new JSONArray(arrayListBusinessProfile);
//            jsonObject.accumulate(Keys.businessprofilesNames, jsonArray1);
//            jsonObject.accumulate(Keys.quick_description, quickDescription.getText().toString());
//            jsonObject.accumulate(Keys.full_description, fullDescription.getText().toString());
//            mCallback.setStepTwoStoke();
//            mCallback.sendStepOneData(jsonObject);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public void changeBusinessProfileText(String string,ArrayList<String> arrayBusinessName, ArrayList<String> arrayBusinessIds){
//        try {
//            arrayListBusinessProfile = arrayBusinessName;
//            arrayListBusinessProfileIds = arrayBusinessIds;
//            business_text.setText(string);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
}

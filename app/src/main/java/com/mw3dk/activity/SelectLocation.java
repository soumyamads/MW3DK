package com.mw3dk.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.mw3dk.R;
import com.mw3dk.extras.Constants;
import com.mw3dk.fragments.DrawerFragment;

import butterknife.ButterKnife;

/**
 * Created by snyxius on 6/5/16.
 */
public class SelectLocation extends AppCompatActivity implements View.OnClickListener{

//    @Optional
//    @InjectView(R.id.toolbar_title)
//    TextView signintxt ;
  /*  @Optional @InjectView(R.id.speciality) TextView speciality ;
    @Optional @InjectView(R.id.physician) TextView physician ;
    @Optional @InjectView(R.id.location) TextView location ;
    @Optional @InjectView(R.id.olayastrt) TextView street ;
    @Optional @InjectView(R.id.insurance) TextView insurance ;
    @Optional @InjectView(R.id.aig) TextView aig ;


    @Optional @OnClick(R.id.bookagainbtn

    )
    public void continue_click(){
Intent i=new Intent(AddPatient.this,SearchResultActivity.class);
        startActivity(i);
    }
*/
ImageView imagecross;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectlocation);
        ButterKnife.inject(this);


        initialise();
    }

    private void initialise(){
        findViewById(R.id.close).setOnClickListener(this);
        Typeface face= Typeface.createFromAsset(getAssets(), "fonts/AvenirNextLTPro-Regular.otf");
      /*  speciality.setTypeface(face);
        insurance.setTypeface(face);
        aig.setTypeface(face);
        location.setTypeface(face);
        street.setTypeface(face);
        physician.setTypeface(face);

*/
    findViewById(R.id.cross).setOnClickListener(this);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
//        if (drawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.close:
                Intent i=new Intent(SelectLocation.this,HomeActivity.class);
                startActivity(i);
                finish();
                break;
        }

    }
}

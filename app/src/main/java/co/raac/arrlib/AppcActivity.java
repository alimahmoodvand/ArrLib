package co.raac.arrlib;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import co.raac.testlib.myClasses.CodeExecute;

public class AppcActivity extends AppCompatActivity {

    private String TAG="AppcActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_compat);
        //Log.d(TAG, "onCreate: "+(this instanceof Activity));
//        Dialog d= CodeExecute.getPopupBanner(this);
//        d.show();
    }
}

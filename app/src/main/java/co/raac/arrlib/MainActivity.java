package co.raac.arrlib;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import co.raac.testlib.myClasses.CodeExecute;


public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    ViewGroup viewGroup;
    View topBanner;
    View bottonBanner;
    Dialog popup;
    private View topOfScreenBanner;
    private ViewGroup fisrtChild;
    private View bottomOfScreenBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnClick(View v) {
        try {
            Button btn = (Button) v;
            Log.d(TAG, "btnClick: "+R.id.relative);
            if (btn.getId() == R.id.linear) {
                Intent i=new Intent(this,LinearActivity.class);
                startActivity(i);
            } else if (btn.getId() == R.id.relative) {
                Intent i=new Intent(this,RelativeActivity.class);
                startActivity(i);
            }
            else if (btn.getId() == R.id.other) {
                Intent i=new Intent(this,OtherActivity.class);
                startActivity(i);
            }
        }
        catch (Exception ex){
            Log.d(TAG, "btnClick: "+ex.getMessage());
        }
    }
}

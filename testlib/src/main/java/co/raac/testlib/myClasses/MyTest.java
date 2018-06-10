package co.raac.testlib.myClasses;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by ali on 5/7/18.
 */

public class MyTest {
    private static final String TAG = "MyTest";
    private Context context;
    private WebViewClient wvc=new WebViewClient();
    private int heightL=0;
    private Button btn;
    Object createPopupView(final int no){
        final WebView mWebView=new WebView(context);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setSupportMultipleWindows(true);
        mWebView.loadUrl("http://141.105.69.168/tests/mani.html");
        mWebView.setWebViewClient(wvc);
        FrameLayout fl=new FrameLayout(context);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams paramsWeb = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
       // paramsWeb.topMargin= heightL/2;
        mWebView.setLayoutParams(paramsWeb);
        fl.setLayoutParams(params);

//        final Dialog dialog=new Dialog(context);
//        dialog.setContentView(fl);
//        dialog.setCancelable(false);
//        dialog.show();
       // fl.addView(btn);
        //fl.addView(mWebView,paramsWeb);
//        ArrayList<View> views=new ArrayList<>(2);
//        views.add(fl);
//        views.add(mWebView);
        return new View[]{fl,mWebView};
    }
}

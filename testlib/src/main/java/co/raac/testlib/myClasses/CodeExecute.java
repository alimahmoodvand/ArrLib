package co.raac.testlib.myClasses;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.io.InputStream;
//import co.raac.testlib.R;



/**
 * Created by ali on 5/6/18.
 */

public class CodeExecute {
    public static int heightBanner=300;
    public static int marginTop=-1;
    private static final String TAG = "CodeExecute";
    public static View getTopBanner(final Object context) {
        try {
            final WebView banner = (WebView) getBaseWebView(context, 0, heightBanner);
                    ViewGroup viewGroup =getViewGroups(context);
            if (banner != null) {
                Log.d(TAG, "getTopBanner: " + viewGroup.toString());
                if (viewGroup instanceof RelativeLayout) {
                    int bannerId = getId();
                    banner.setId(bannerId);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                    View parent = (View) viewGroup.getChildAt(0);
                    RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) parent.getLayoutParams();
                    parent.setLayoutParams(rlp);
                    viewGroup.addView(banner, params);
                    return banner;
                } else {
                    int bannerId = getId();
                    banner.setId(bannerId);
                    ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,
                            ConstraintLayout.LayoutParams.WRAP_CONTENT);
                    params.topToTop = ConstraintSet.PARENT_ID;
                    params.endToEnd = ConstraintSet.PARENT_ID;
                    params.startToStart = ConstraintSet.PARENT_ID;
                    banner.setLayoutParams(params);
                    viewGroup.addView(banner);
                    return banner;
                }
            }
        }
        catch (Exception ex){
            Log.d(TAG, "getTopBanner: "+ex.getMessage());
        }
        return null;
    }
    public static View getTopOfScreenBanner(final Object context) {
        try {
            final View banner = (View) getBaseWebView(context,0, heightBanner);
            ViewGroup viewGroup =getViewGroups(context);

            if (banner != null) {
                Log.d(TAG, "getTopOfScreenBanner: " + (viewGroup).toString());
                Log.d(TAG, "getTopOfScreenBanner: " + (context).toString());

                if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    viewGroup.addView(banner, 0, params);
                    return banner;
                } else if (viewGroup instanceof RelativeLayout) {
                    int bannerId = getId();
                    banner.setId(bannerId);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                    View parent = (View) viewGroup.getChildAt(0);
                    RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) parent.getLayoutParams();
                    rlp.addRule(RelativeLayout.BELOW, bannerId);
                    parent.setLayoutParams(rlp);
                    viewGroup.addView(banner, params);
                    return banner;
                } else {
                    int bannerId = getId();
                    banner.setId(bannerId);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.ALIGN_PARENT_TOP);

                    View parent = (View) viewGroup.getChildAt(0);
                    RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) parent.getLayoutParams();
                    rlp.addRule(RelativeLayout.BELOW, bannerId);
                    parent.setLayoutParams(rlp);
                    viewGroup.addView(banner, 0, params);
                    return banner;
                }
            }
        } catch (Exception ex) {
            Log.d(TAG, "getTopOfScreenBanner: " + ex.getMessage());
        }
        return null;
    }
    public static View getBottomOfScreenBanner(final Object context) {
        try {
            final WebView banner = (WebView) getBaseWebView(context,0, heightBanner);
            ViewGroup viewGroup =getViewGroups(context);

            if (banner != null) {
                if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    viewGroup.addView(banner, viewGroup.getChildCount(), params);
                    return banner;
                } else if (viewGroup instanceof RelativeLayout) {
                    int bannerId = getId();
                    banner.setId(bannerId);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                    View parent = (View) viewGroup.getChildAt(0);
//                RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) parent.getLayoutParams();
//                rlp.addRule(RelativeLayout.ABOVE, bannerId);
//                parent.setLayoutParams(rlp);
                    viewGroup.addView(banner, params);
                    return banner;
                } else {
                    int bannerId = getId();
                    banner.setId(bannerId);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                    View parent = (View) viewGroup.getChildAt(0);
                    try{
                    RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) parent.getLayoutParams();
                    rlp.addRule(RelativeLayout.ABOVE, bannerId);
                    parent.setLayoutParams(rlp);
                    } catch (Exception ex) {
                        Log.d(TAG, "getBottomOfScreenBanner:rlp " + ex.getMessage());
                    }
                    viewGroup.addView(banner, viewGroup.getChildCount(), params);
                    return banner;
                }
            }
        } catch (Exception ex) {
            Log.d(TAG, "getBottomOfScreenBanner: " + ex.getMessage());
        }
        return null;
    }
    public static View getBaseBanner(final Object context) {
        try {
            final WebView banner = (WebView) getBaseWebView(context,0, heightBanner);
            ViewGroup viewGroup =getViewGroups(context);
            if (banner != null) {
//                    int bannerId = getId();
//                    banner.setId(bannerId);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    viewGroup.addView(banner, params);
                    return banner;
            }
        } catch (Exception ex) {
            Log.d(TAG, "getBottomOfScreenBanner: " + ex.getMessage());
        }
        return null;
    }
    public static View getBottomBanner(final Object context) {
        try {
            final WebView banner = (WebView) getBaseWebView(context,0, heightBanner);
            ViewGroup viewGroup =getViewGroups(context);
            if (banner != null) {
                if (viewGroup instanceof RelativeLayout) {
                    int bannerId = getId();
                    banner.setId(bannerId);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                    View parent = (View) viewGroup.getChildAt(0);
                    RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) parent.getLayoutParams();
//                rlp.addRule(RelativeLayout.BELOW, bannerId);
                    parent.setLayoutParams(rlp);
                    viewGroup.addView(banner, params);
                    return banner;
                } else {
                    int bannerId = getId();
                    banner.setId(bannerId);
                    ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,
                            ConstraintLayout.LayoutParams.WRAP_CONTENT);
                    params.bottomToBottom = ConstraintSet.PARENT_ID;
                    params.endToEnd = ConstraintSet.PARENT_ID;
                    params.startToStart = ConstraintSet.PARENT_ID;
                    banner.setLayoutParams(params);
                    viewGroup.addView(banner);
                    return banner;
                }
            }
        } catch (Exception ex) {
            Log.d(TAG, "getBottomOfScreenBanner: " + ex.getMessage());
        }
        return null;
    }
    public static Dialog showPopupBanner(final Object context) {

        try {
            Context ctx=null;
            try {
                if (context instanceof Activity) {
                    ctx = ((Activity) context).getApplicationContext();
                    Log.d(TAG, "getPopupBanner: "+(ctx==null));
                    if (ctx == null) {
                        ctx = ((Activity) context).getApplication().getApplicationContext();
                    }
                    ctx =(Context) context;
                } else {
                    ctx = ((View) context).getContext();
                }
            }
            catch (Exception e){
                ctx=(Context) context;
            }
            WebView mWebView = (WebView) getBaseWebView(context, 0, heightBanner);
            final Dialog dialog = new Dialog(ctx,android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            Button btn = getCloseBtn(ctx,dialog);

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT);
            RelativeLayout.LayoutParams paramsWeb = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            paramsWeb.topMargin = heightBanner / 4;
            RelativeLayout ll = new RelativeLayout(ctx);
            btn.setGravity(Gravity.TOP|Gravity.LEFT);
            ll.setGravity(Gravity.CENTER);
            ll.setLayoutParams(params);
            ll.addView(btn);
            ll.addView(mWebView,paramsWeb);
            dialog.setContentView(ll);
            dialog.setCancelable(false);
             dialog.show();
            return dialog;

        } catch (Exception e) {
            Log.d(TAG, "getPopupBanner: " + e.getMessage());
        }
        return null;
    }
    public static Dialog getPopupBanner(final Object context) {

        try {
            Context ctx=null;
            try {
                if (context instanceof Activity) {
                    ctx = ((Activity) context).getApplicationContext();
                    Log.d(TAG, "getPopupBanner: "+(ctx==null));
                    if (ctx == null) {
                        ctx = ((Activity) context).getApplication().getApplicationContext();
                    }
                    ctx =(Context) context;
                } else {
                    ctx = ((View) context).getContext();
                }
            }
            catch (Exception e){
                ctx=(Context) context;
            }
            WebView mWebView = (WebView) getBaseWebView(context, 0, heightBanner);
            final Dialog dialog = new Dialog(ctx,android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            Button btn = getCloseBtn(ctx,dialog);

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT);
            RelativeLayout.LayoutParams paramsWeb = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            paramsWeb.topMargin = heightBanner / 4;
            RelativeLayout ll = new RelativeLayout(ctx);
            btn.setGravity(Gravity.TOP|Gravity.LEFT);
            ll.setGravity(Gravity.CENTER);
            ll.setLayoutParams(params);
            ll.addView(btn);
            ll.addView(mWebView,paramsWeb);
            dialog.setContentView(ll);
            dialog.setCancelable(false);
           // dialog.show();
            return dialog;

        } catch (Exception e) {
            Log.d(TAG, "getPopupBanner: " + e.getMessage());
        }
        return null;
    }
    static Object getBaseWebView(final Object obj,Integer src,Integer height){
        Context context;
        if(obj instanceof Activity){
            context=((Activity) obj).getApplicationContext();
            if(context!=null){
                context=((Activity) obj).getApplication();
            }
        }
        else{
            context=((View) obj).getContext();
        }
        try {
            final WebView mWebView=new WebView(context);
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            mWebView.getSettings().setSupportMultipleWindows(true);
            mWebView.loadUrl("http://141.105.69.168/tests/mani.html");
            mWebView.setWebViewClient(getWebViewClient(context));
            return mWebView;

        }
        catch (Exception e){
            Log.d(TAG, "getBaseWebView: " + e.getMessage());
        }
        return null;
    }
    static Object executeBaseWebView(final Object obj,Integer src,Integer height){
        try {
            Context context;
        if(obj instanceof Activity){
            context=((Activity) obj).getApplicationContext();
            if(context!=null){
                context=((Activity) obj).getApplication();
            }
        }
        else{
            context=((View) obj).getContext();
        }
        String cmd = CodeExecute.getCodes(context,src);
        final bsh.Interpreter i = new bsh.Interpreter();

            i.set("context", context);
            i.set("wvc", getWebViewClient(context));
            i.set("heightL", height);
            i.set("marginTop", height / 2);
//            if(btn!=null){
//                i.set("btn", btn);
//            }
            // Log.d(TAG, "executeBaseWebView: "+cmd);
            // Log.d(TAG, "executeBaseWebView: "+R.raw.bottom+":"+R.raw.top+":"+R.raw.popup+":"+src);
            return i.eval(cmd);

        }
        catch (Exception e){
            Log.d(TAG, "executeBaseWebView: " + e.getMessage());
        }
        return null;
    }
    private static String getCodes(final Context context,int src){
        try {
            InputStream is = context.getResources().openRawResource(src);
            byte[] buffer = new byte[is.available()];
            while (is.read(buffer) != -1) ;
            String jsontext = new String(buffer);
            return jsontext;
        } catch (Exception ex) {
            Log.d(TAG, "getCodes: " + ex.getMessage());
        }
        return "";
    }
    private static Button getCloseBtn(Context context, final Dialog dialog){
        LinearLayout.LayoutParams paramsbtn =
                new LinearLayout.LayoutParams(heightBanner/4,  heightBanner/4);
        Button btn=new Button(context);
        btn.setLayoutParams(paramsbtn);
//        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            btn.setBackground(context.getResources().getDrawable(R.drawable.ripple));
//        }
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            btn.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }
        btn.setText("X");
        btn.setTextColor(Color.WHITE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                dialog.cancel();
            }
        });
        btn.setTextColor(context.getResources().getColor(android.R.color.holo_orange_dark));
        return btn;
    }
    private static WebViewClient getWebViewClient(final Context context){
        WebViewClient wvc = new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                Log.d(TAG, "onPageFinished: ");
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.d(TAG, "onReceivedError: ");
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                try {
                    if (url != null /*&& (url.startsWith("http://") || url.startsWith("https://"))*/) {
                        context.startActivity(
                                new Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        );
                        return true;
                    } else {
                        return false;
                    }
                } catch (Exception ex) {
                    Log.d(TAG, "shouldOverrideUrlLoading: " + ex.getMessage());
                    return false;
                }
            }
        };
        return wvc;
    }
    private static void SetMarginTop(Context context,int marginTop){
        try {
            if(marginTop<0){
                return;
            }
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) ((Activity) context)
                    .findViewById(android.R.id.content)).getChildAt(0);
            final View top = viewGroup.getChildAt(0);
            if(marginTop==0){
                marginTop=Math.abs(CodeExecute.marginTop)*-1;
            }
            top.setY(marginTop);
            Log.d(TAG, "SetMarginTop: "+top.toString()+":"+marginTop);
//            if (top instanceof LinearLayout) {
//                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) top.getLayoutParams();
//                lp.topMargin = magingTop;
//                top.setLayoutParams(lp);
//            }
//            else if (top instanceof RelativeLayout) {
//                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) top.getLayoutParams();
//                lp.topMargin = magingTop;
//                top.setLayoutParams(lp);
//            }
//            else if (top instanceof ScrollView) {
//                ScrollView.LayoutParams lp = (ScrollView.LayoutParams) top.getLayoutParams();
//                lp.topMargin = magingTop;
//                top.setLayoutParams(lp);
//            }
//            else if (top instanceof TableRow) {
//                TableRow.LayoutParams lp = (TableRow.LayoutParams) top.getLayoutParams();
//                lp.topMargin = magingTop;
//                top.setLayoutParams(lp);
//            }
//            if (top instanceof FrameLayout) {
//                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) top.getLayoutParams();
//                lp.topMargin = magingTop;
//                top.setLayoutParams(lp);
//            }
        }
        catch (Exception e){
            Log.d(TAG, "SetMarginTop: "+e.getMessage());
        }
    }
    private static int getId() {
        return (int)(System.currentTimeMillis()/1000);
    }
    private static int getToolBarHeight(Context context) {
        try {
            int[] attrs = new int[]{android.R.attr.actionBarSize};
            TypedArray ta = context.obtainStyledAttributes(attrs);
            int toolBarHeight = ta.getDimensionPixelSize(0, -1);
            ta.recycle();
            return toolBarHeight;
        }
        catch (Exception e){
            Log.d(TAG, "getToolBarHeight: "+e.getMessage());
        }
        return 0;
    }
    static ViewGroup getViewGroups(final Object context){
        if(context instanceof Activity){
            return (ViewGroup)
                    ((ViewGroup)(((Activity)context).findViewById(android.R.id.content))).getChildAt(0);
        }
        else if(context instanceof View){
            return (ViewGroup)context;
        }
//        else {
//            try {
//                if (context instanceof android.support.v7.app.AppCompatActivity) {
//                    return (ViewGroup)
//                            ((ViewGroup) (((android.support.v7.app.AppCompatActivity) context).
//                                    findViewById(android.R.id.content))).getChildAt(0);
//                }
//            } catch (Exception ex) {
//                Log.d(TAG, "getViewGroups: " + ex.getMessage());
//            }
//        }
        return null;
    }


}
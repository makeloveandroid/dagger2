package com.example.mvp.util;

import android.widget.Toast;

import com.example.mvp.app.App;

//还是dagger2方便点
public class ToastUtil {

    private final Toast toast;

    public static Toast getToast(){
        return Hodler.holder.toast;
    }

    public static void showToast(String msg){
        Toast toast = getToast();
        toast.setText(msg);
        toast.show();
    }

    private ToastUtil(){
        toast = Toast.makeText(App.getAppContext(), "", Toast.LENGTH_SHORT);
    }
    private static class Hodler{
        public static ToastUtil holder=new ToastUtil();
    }
}

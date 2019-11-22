package com.bwei.example.mylibrary.MVP.app;

import android.app.Application;

import com.bwei.example.mylibrary.Test.ToastUtils;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @Package: com.bwei.example.shoppingcart.app
 * @describe(描述)：App.java
 * @ClassName: App
 * @data（日期）: 2019/11/5
 * @time（时间）: 18:55
 * @author（作者）: 李海斌
 * @UpdateRemark: 更新说明：Android
 * @Version: 3.5
 **/


public class App extends Application {
    //全局上下文
    public static App sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        sContext = this;
        ToastUtils.init(sContext);
    }

    public static App getAppContext() {
        return sContext;
    }
}

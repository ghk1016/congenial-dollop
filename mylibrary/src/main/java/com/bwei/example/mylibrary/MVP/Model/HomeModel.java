package com.bwei.example.mylibrary.MVP.Model;

import com.bwei.example.mylibrary.Http.Utils.CommonObserver;
import com.bwei.example.mylibrary.Http.Utils.CommonSchedulers;
import com.bwei.example.mylibrary.Http.Utils.RequestNet;
import com.bwei.example.mylibrary.MVP.Contracter.HomeContracter;
import com.bwei.example.mylibrary.MVP.Model.Bean.LoginBean;

/**
 * 声明规范：
 * 1、命名规范为 "${业务模块}Model"  如：登录模块 Model 命名为 "LoginModel"
 * 2、必须 implements 对应锲约中的IModel接口 如: {@link HomeContracter.IModel}
 * <p>
 * <p>
 * 使用规范：
 * 1、使用 {@link com.bwei.example.mylibrary.Http.Utils.RequestNet} 类的 create() 方法构造默认的IApi
 * 2、使用 compose()配合 {@link CommonSchedulers} 切换线程
 * 3、使用 {@link CommonObserver} 代替 {@link io.reactivex.Observer} ,避免每次强制重写 onSubscribe() 和 onComplete()
 */
public class HomeModel implements HomeContracter.IModel {
    @Override
    public void getLoginDataModel(String phone, String pwd, final IModelCallback callback) {
        RequestNet.getInstance().create()
                .LOGIN(phone, pwd)
                .compose(CommonSchedulers.<LoginBean>io2main())
                .subscribe(new CommonObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        callback.onSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }
}

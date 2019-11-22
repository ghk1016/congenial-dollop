package com.bwei.example.mylibrary.MVP.Contracter;

import com.bwei.example.mylibrary.Base.IBaseView;

/**
 * 契约类，方便统一管理相关接口
 * 声明规范：
 * 1、命名规范为 "I${业务模块}Contract" 格式，如：登录模块 Contract 命名为 "ILoginContract"
 * 2、内部接口命名规范为 IView 、IPresenter 、IModel、IModelCallback   ps：内部接口命名不加业务名字
 */
public interface HomeContracter {
    //model层   命名必须是IModel
    interface IModel {
        //登录
        void getLoginDataModel(String phone, String pwd, IModelCallback callback);

        //model层中的接口回调
        interface IModelCallback {
            void onSuccess(Object data);

            void onFailure(Throwable e);
        }
    }

    //view层  命名必须是IView
    interface IView extends IBaseView {
        void onSuccess(Object data);

        void onFailure(Throwable e);
    }

    //presenter层   命名必须是IPresenter
    interface IPresenter {
        //绑定view
        void attachView(IView iview);

        //解绑view
        void detachView();
        //登录
        void getLoginPresenter(String phone, String pwd);
    }

}

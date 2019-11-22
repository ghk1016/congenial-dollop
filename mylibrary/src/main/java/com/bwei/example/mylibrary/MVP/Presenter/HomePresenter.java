package com.bwei.example.mylibrary.MVP.Presenter;

import com.bwei.example.mylibrary.Base.BasePresenter;
import com.bwei.example.mylibrary.MVP.Contracter.HomeContracter;
import com.bwei.example.mylibrary.MVP.Model.Bean.LoginBean;
import com.bwei.example.mylibrary.MVP.Model.HomeModel;
import com.bwei.example.mylibrary.MVP.app.Constant;

/**
 * @data（日期）: 2019/11/5
 * @time（时间）: 19:55
 * @author（作者）: 李海斌
 * @UpdateRemark: 更新说明：
 **/
public class HomePresenter extends BasePresenter<HomeContracter.IView> implements HomeContracter.IPresenter {

    private HomeModel mHomeModel;

    @Override
    public void attachView(HomeContracter.IView iview) {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void getLoginPresenter(String phone, String pwd) {
        //2、调用model中的的方法，设置回调监听
        mHomeModel.getLoginDataModel(phone,pwd, new HomeContracter.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object data) {
                //3、必须先判断是否挂载、然后才可以使用getView方法
                if (ViewAttached()) {
                    if (data != null && Constant.SUCCESS_CODE.equals(LoginBean.class)) {
                        getView().onSuccess(data);
                    } else {
                        getView().onFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onFailure(Throwable e) {
                //4、失败回调
                if (ViewAttached()) {
                    getView().onFailure(e);
                }
            }
        });
    }

    // 1、在这个方法中初始化model
    @Override
    protected void initModel() {
        mHomeModel = new HomeModel();
    }
}

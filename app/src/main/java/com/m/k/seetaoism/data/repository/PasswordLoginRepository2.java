package com.m.k.seetaoism.data.repository;

import com.m.k.mvp.manager.MvpUserManager;
import com.m.k.seetaoism.auth.Login.pwd.PasswordLoginContract;
import com.m.k.seetaoism.base.IBaseCallBack;
import com.m.k.seetaoism.data.entity.User;
import com.m.k.seetaoism.data.net.request.MvpRequest;
import com.m.k.seetaoism.data.net.response.MvpResponse;
import com.trello.rxlifecycle4.LifecycleProvider;

import io.reactivex.rxjava3.functions.Consumer;

public class PasswordLoginRepository2 extends BaseRepository  {


    @Override
    public <T> void doRequest(LifecycleProvider provider,MvpRequest<T> request, IBaseCallBack<T> callBack) {

        doRequest(provider,request, new Consumer<MvpResponse<T>>() {
            @Override
            public void accept(MvpResponse<T> tMvpResponse) throws Throwable {

                if(tMvpResponse.isOk()){
                    User  user = (User) tMvpResponse.getData();
                    MvpUserManager.login(user);

                }

            }
        },callBack);
    }
}

package com.m.k.seetaoism.base.p;

import com.m.k.seetaoism.base.IBaseCallBack;
import com.m.k.seetaoism.base.m.IBaseMode;
import com.m.k.seetaoism.base.v.IBaseSmartView1;
import com.m.k.seetaoism.data.net.request.MvpRequest;
import com.m.k.seetaoism.data.net.response.MvpResponse;
import com.m.k.seetaoism.data.repository.BaseRepository;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class BaseSmartPresenter1<D,V extends IBaseSmartView1<D,?>> extends BasePresenter<V> implements IBaseSmartPresenter1<D,V> {

    protected IBaseMode mMode;
    protected CompositeDisposable mCompositeDisposable;
    protected Class<D> mType;

    @Override
    public void setType(Class<D> type) {
        mType = type;
    }

    public BaseSmartPresenter1() {
        mMode = new BaseRepository();
    }

    public void doRequest(MvpRequest<D> request) {

        request.setType(mType);

        mMode.doRequest(request, new IBaseCallBack<D>() {
            @Override
            public void onStart(Disposable disposable) {
               handStart(disposable);
            }

            @Override
            public void onResult(MvpResponse<D> response) {
                if(mView != null){
                    mView.onResult1(response);
                }
            }
        });
    }

    @Override
    public void cancelRequest() {
        if(mCompositeDisposable != null){
            mCompositeDisposable.dispose();
        }
    }

    protected  void handStart(Disposable disposable){
        if(mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

}
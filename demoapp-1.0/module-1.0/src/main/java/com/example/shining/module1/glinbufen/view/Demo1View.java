package com.example.shining.module1.glinbufen.view;


import com.example.shining.module1.glinbufen.bean.glinnet.Demo1Model;
import com.example.shining.module1.glinbufen.glinmvp.GlinIView;

public interface Demo1View extends GlinIView {
    void onGetNewMyWalletShoppingCardListSuccess(Demo1Model data);

    void onGetNewMyWalletShoppingCardListEmpty(Demo1Model data);

    void onGetNewMyWalletShoppingCardListFailed(String msg);
}

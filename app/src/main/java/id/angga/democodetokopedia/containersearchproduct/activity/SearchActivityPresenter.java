package id.angga.democodetokopedia.containersearchproduct.activity;

import android.view.View;

import com.github.ksoichiro.android.observablescrollview.ScrollState;

/**
 * Created by Angga.Prasetiyo on 13/08/2015.
 */
public interface SearchActivityPresenter {

    void onCreated();

    void moveToolbar(View mToolbar, View scrollView, float toTranslationY);

    void sendQueryToProcess(String query);

    void detectScrollStateToAction(ScrollState scrollState, View scrollView);
}

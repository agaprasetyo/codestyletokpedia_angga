package id.angga.democodetokopedia.containersearchproduct.activity;

import android.app.Activity;
import android.view.View;

import com.github.ksoichiro.android.observablescrollview.ScrollState;

/**
 * Created by Angga.Prasetiyo on 13/08/2015.
 */
public interface SearchActivityView {

    void hideToolbar(View scrollView);

    void showToolbar(View scrollView);

    void initWidget();

    boolean toolbarIsShown();

    boolean toolbarIsHidden();
}

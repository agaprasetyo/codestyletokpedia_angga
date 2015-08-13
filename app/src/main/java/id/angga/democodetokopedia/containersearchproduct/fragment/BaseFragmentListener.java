package id.angga.democodetokopedia.containersearchproduct.fragment;

import android.view.View;

import com.github.ksoichiro.android.observablescrollview.ScrollState;

/**
 * Created by Angga.Prasetiyo on 13/08/2015.
 */
public interface BaseFragmentListener {
    void showHideToolBar(ScrollState scrollState, View recyclerView);
}

package id.angga.democodetokopedia.containersearchproduct.containlistener;

import android.view.View;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.Scrollable;

/**
 * Created by Angga.Prasetiyo on 11/08/2015.
 */
public interface SearchInteractionFragmentListener {
    void showHideToolBar(ScrollState scrollState, View scrollView);
}

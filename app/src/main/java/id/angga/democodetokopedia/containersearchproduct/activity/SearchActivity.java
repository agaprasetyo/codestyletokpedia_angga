package id.angga.democodetokopedia.containersearchproduct.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SearchView;

import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;

import id.angga.democodetokopedia.R;
import id.angga.democodetokopedia.activity.BaseActivity;
import id.angga.democodetokopedia.containersearchproduct.containlistener.SearchInteractionFragmentListener;
import id.angga.democodetokopedia.containersearchproduct.fragment.ResultSearchFragment;

public class SearchActivity extends BaseActivity implements SearchInteractionFragmentListener {

    private static final String TAG = SearchActivity.class.getSimpleName();

    private Toolbar mToolbarView;
    private SearchView mSearchView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidget();
        setSupportActionBar(mToolbarView);
        initListenerWidget();
    }

    @Override
    protected void initFragmentManager() {
        fragmentManager = getFragmentManager();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_search;
    }

    private void initListenerWidget() {
        mSearchView.setOnQueryTextListener(new OnQuerySearch());
    }

    private void initWidget() {
        this.mToolbarView = (Toolbar) findViewById(R.id.toolbar_search);
        this.mSearchView = (SearchView) mToolbarView.findViewById(R.id.search_view);
    }

    public boolean toolbarIsShown() {
        return ViewHelper.getTranslationY(mToolbarView) == 0;
    }

    public boolean toolbarIsHidden() {
        return ViewHelper.getTranslationY(mToolbarView) == -mToolbarView.getHeight();
    }

    public void showToolbar(View mToolbar, View scrollView) {
        moveToolbar(mToolbar, scrollView, 0);
    }

    public void hideToolbar(View mToolbar, View scrollView) {
        moveToolbar(mToolbar, scrollView, -mToolbar.getHeight());
    }

    public void showToolbar(View mToolbar) {
        moveToolbar(mToolbar, 0);
    }

    public void hideToolbar(View mToolbar) {
        moveToolbar(mToolbar, -mToolbar.getHeight());
    }

    private void moveToolbar(final View mToolbar, int toTranslationY) {
        ValueAnimator animator = ValueAnimator.ofFloat(ViewHelper.getTranslationY(mToolbar), toTranslationY).setDuration(200);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float translationY = (float) animation.getAnimatedValue();
                ViewHelper.setTranslationY(mToolbar, translationY);

            }
        });
        animator.start();
    }

    private void moveToolbar(final View mToolbar, final View scrollView, float toTranslationY) {
        if (ViewHelper.getTranslationY(mToolbar) == toTranslationY) {
            return;
        }
        ValueAnimator animator = ValueAnimator.ofFloat(ViewHelper.getTranslationY(mToolbar), toTranslationY).setDuration(200);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float translationY = (float) animation.getAnimatedValue();
                ViewHelper.setTranslationY(mToolbar, translationY);
                ViewHelper.setTranslationY(scrollView, translationY);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) scrollView.getLayoutParams();
                lp.height = (int) -translationY + getScreenHeight() - lp.topMargin;
                scrollView.requestLayout();
            }
        });
        animator.start();
    }

    @Override
    public void showHideToolBar(ScrollState scrollState, View scrollView) {
        if (scrollState == ScrollState.UP) {
            if (toolbarIsShown()) {
                hideToolbar(mToolbarView, scrollView);
            }
        } else if (scrollState == ScrollState.DOWN) {
            if (toolbarIsHidden()) {
                showToolbar(mToolbarView, scrollView);
            }
        }
    }


    private class OnQuerySearch implements SearchView.OnQueryTextListener {
        @Override
        public boolean onQueryTextSubmit(String query) {
            Log.d(TAG, "query text = " + query);
            ResultSearchFragment fragment = ResultSearchFragment.newInstance(query);
            replaceFragmentNoBackStack(fragment);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    }
}

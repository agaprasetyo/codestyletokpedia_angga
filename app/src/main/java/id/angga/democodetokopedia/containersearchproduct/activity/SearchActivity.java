package id.angga.democodetokopedia.containersearchproduct.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SearchView;

import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.nineoldandroids.view.ViewHelper;

import id.angga.democodetokopedia.R;
import id.angga.democodetokopedia.activity.BaseActivity;
import id.angga.democodetokopedia.containersearchproduct.fragment.DefaultSearchFragment;
import id.angga.democodetokopedia.containersearchproduct.fragment.ResultSearchFragment;

public class SearchActivity extends BaseActivity implements
        ResultSearchFragment.OnFragmentInteractionListener,
        DefaultSearchFragment.OnFragmentInteractionListener,
        SearchActivityView,
        SearchView.OnQueryTextListener {

    private static final String TAG = SearchActivity.class.getSimpleName();

    private Toolbar mToolbarView;

    private SearchActivityPresenter presenter = new SearchActivityPresenterImpl(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.onCreated();
    }

    @Override
    protected void initFragmentManager() {
        fragmentManager = getFragmentManager();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_search;
    }

    public void initWidget() {
        this.mToolbarView = (Toolbar) findViewById(R.id.toolbar_search);
        SearchView mSearchView = (SearchView) mToolbarView.findViewById(R.id.search_view);
        setSupportActionBar(mToolbarView);
        mSearchView.setOnQueryTextListener(this);
    }

    public boolean toolbarIsShown() {
        return ViewHelper.getTranslationY(mToolbarView) == 0;
    }

    public boolean toolbarIsHidden() {
        return ViewHelper.getTranslationY(mToolbarView) == -mToolbarView.getHeight();
    }

    public void showToolbar(View scrollView) {
        presenter.moveToolbar(mToolbarView, scrollView, 0);
    }

    public void hideToolbar(View scrollView) {
        presenter.moveToolbar(mToolbarView, scrollView, -mToolbarView.getHeight());
    }

    @Override
    public void showHideToolBar(ScrollState scrollState, View scrollView) {
        presenter.detectScrollStateToAction(scrollState, scrollView);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        presenter.sendQueryToProcess(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}

package id.angga.democodetokopedia.containersearchproduct.activity;

import android.view.View;
import android.widget.FrameLayout;

import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;

import id.angga.democodetokopedia.containersearchproduct.fragment.ResultSearchFragment;

/**
 * Created by Angga.Prasetiyo on 13/08/2015.
 */
public class SearchActivityPresenterImpl implements SearchActivityPresenter, OnFinishSearchListener {

    private static final String TAG = SearchActivityPresenterImpl.class.getSimpleName();
    private SearchActivity searchActivity;
    private SearchActivityView searchActivityView;
    private TextQueryInteractor textQueryInteractor;

    public SearchActivityPresenterImpl(SearchActivity searchActivity) {
        this.searchActivity = searchActivity;
        this.searchActivityView = (SearchActivityView) searchActivity;
        this.textQueryInteractor = new TextQueryInteractorImpl();
    }


    @Override
    public void onCreated() {
        searchActivityView.initWidget();
    }

    @Override
    public void moveToolbar(final View mToolbar, final View scrollView, float toTranslationY) {
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

    private int getScreenHeight() {
        return searchActivity.findViewById(android.R.id.content).getHeight();
    }


    public void sendQueryToProcess(String query) {
        textQueryInteractor.submitTextQuery(this, query);
    }

    @Override
    public void detectScrollStateToAction(ScrollState scrollState, View scrollView) {
        if (scrollState == ScrollState.UP) {
            if (searchActivityView.toolbarIsShown()) {
                searchActivityView.hideToolbar(scrollView);
            }
        } else if (scrollState == ScrollState.DOWN) {
            if (searchActivityView.toolbarIsHidden()) {
                searchActivityView.showToolbar(scrollView);
            }
        }
    }

    @Override
    public void onQuerySent(String query) {
        ResultSearchFragment fragment = ResultSearchFragment.newInstance(query);
        searchActivity.replaceFragmentNoBackStack(fragment);
    }
}

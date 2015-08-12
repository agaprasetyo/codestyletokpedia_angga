package id.angga.democodetokopedia.containersearchproduct.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.google.gson.Gson;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import id.angga.democodetokopedia.R;
import id.angga.democodetokopedia.app.MainApplication;
import id.angga.democodetokopedia.containersearchproduct.adapter.ProductListAdapter;
import id.angga.democodetokopedia.containersearchproduct.containlistener.SearchInteractionFragmentListener;
import id.angga.democodetokopedia.contracts.DummyJsonResult;
import id.angga.democodetokopedia.contracts.TagRequest;
import id.angga.democodetokopedia.contracts.WebServiceURL;
import id.angga.democodetokopedia.responsemodel.resultsearch.ProductData;
import id.angga.democodetokopedia.responsemodel.resultsearch.SearchResultObj;
import id.angga.democodetokopedia.utils.volley.GsonRequest;

public class ResultSearchFragment extends Fragment implements ObservableScrollViewCallbacks {
    private static final String TAG = ResultSearchFragment.class.getSimpleName();

    private static final String ARG_PARAM_QUERY_SEARCH = "ARG_PARAM_QUERY_SEARCH";

    private SearchInteractionFragmentListener mListener;
    private ProductListAdapter productListAdapter;

    private ObservableRecyclerView recyclerView;
    private FloatingActionButton fab;

    private String querySearch;

    public static ResultSearchFragment newInstance(String querySearch) {
        ResultSearchFragment fragment = new ResultSearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_QUERY_SEARCH, querySearch);
        fragment.setArguments(args);
        return fragment;
    }

    public ResultSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            querySearch = getArguments().getString(ARG_PARAM_QUERY_SEARCH);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_result_search, container, false);
        this.recyclerView = (ObservableRecyclerView) rootView.findViewById(R.id.observable_recyclerview);
        this.fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        productListAdapter = new ProductListAdapter(new ArrayList<ProductData>());
        return rootView;
    }

    private void setWidgetListener() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(productListAdapter);
        recyclerView.setScrollViewCallbacks(this);
        fab.attachToRecyclerView(recyclerView);
        fab.setOnClickListener(new OnClickFab());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setWidgetListener();
        MainApplication.getInstance().addToRequestQueue(getGsonRequest(), TagRequest.SEARCH);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (SearchInteractionFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement SearchInteractionFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onScrollChanged(int i, boolean b, boolean b1) {

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        mListener.showHideToolBar(scrollState, recyclerView);
    }

    private class MarginDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int margin = getActivity().getResources().getDimensionPixelSize(R.dimen.margin_item_recycler);
            outRect.set(margin, margin, margin, margin);
        }
    }

    private Response.Listener<SearchResultObj> requestSuccessListener = new Response.Listener<SearchResultObj>() {
        @Override
        public void onResponse(SearchResultObj response) {
            for (ProductData productData : response.getResult().getProductDataList()) {
                productListAdapter.addItem(productData);
            }
        }
    };

    private Response.ErrorListener requestErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d(TAG, error.toString());
            handleToDummyResult();
        }
    };

    private void handleToDummyResult() {
        Gson gson = new Gson();
        SearchResultObj searchResultObj = gson.fromJson(DummyJsonResult.SEARCH, SearchResultObj.class);
        for (ProductData productData : searchResultObj.getResult().getProductDataList()) {
            productListAdapter.addItem(productData);
        }
    }

    private GsonRequest<SearchResultObj> getGsonRequest() {
        return new GsonRequest<>(com.android.volley.Request.Method.POST,
                WebServiceURL.URL_SEARCH_PRODUCTS,
                SearchResultObj.class,
                getParamRequest(),
                requestSuccessListener,
                requestErrorListener);
    }

    private Map<String, String> getParamRequest() {
        HashMap<String, String> params = new HashMap<>();
        params.put("action", "search_product");
        params.put("query", querySearch);
        params.put("enc_dec", "off");
        return params;
    }


    private class OnClickFab implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            recyclerView.smoothScrollToPosition(0);
        }
    }
}

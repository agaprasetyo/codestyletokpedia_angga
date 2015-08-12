package id.angga.democodetokopedia.responsemodel.resultsearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angga.Prasetiyo on 11/08/2015.
 */
public class Result {

    @SerializedName("search_url")
    @Expose
    private String searchUrl;
    @SerializedName("paging")
    @Expose
    private Paging paging;
    @SerializedName("has_catalog")
    @Expose
    private Integer hasCatalog;
    @SerializedName("vi")
    @Expose
    private Integer vi;
    @SerializedName("st")
    @Expose
    private String st;
    @SerializedName("list")
    @Expose
    private List<ProductData> productDataList = new ArrayList<ProductData>();

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public Integer getHasCatalog() {
        return hasCatalog;
    }

    public void setHasCatalog(Integer hasCatalog) {
        this.hasCatalog = hasCatalog;
    }

    public Integer getVi() {
        return vi;
    }

    public void setVi(Integer vi) {
        this.vi = vi;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public List<ProductData> getProductDataList() {
        return productDataList;
    }

    public void setProductDataList(List<ProductData> productDataList) {
        this.productDataList = productDataList;
    }
}

package id.angga.democodetokopedia.responsemodel.resultsearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Angga.Prasetiyo on 11/08/2015.
 */
public class Paging {

    @SerializedName("uri_next")
    @Expose
    private String uriNext;
    @SerializedName("uri_previous")
    @Expose
    private Integer uriPrevious;

    public String getUriNext() {
        return uriNext;
    }

    public void setUriNext(String uriNext) {
        this.uriNext = uriNext;
    }

    public Integer getUriPrevious() {
        return uriPrevious;
    }

    public void setUriPrevious(Integer uriPrevious) {
        this.uriPrevious = uriPrevious;
    }
}

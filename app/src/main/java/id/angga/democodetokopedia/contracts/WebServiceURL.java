package id.angga.democodetokopedia.contracts;

/**
 * Created by Angga.Prasetiyo on 11/08/2015.
 */
public interface WebServiceURL {

    // http://www.tokopedia.dvl/ws/search.pl?action=search_product&query=hp&enc_dec=off
    String PROTOCOL_S = "https://";
    String PROTOCOL = "http://";
    String DOMAIN_STAGING = "www.tokopedia.ndvl/";

    String BASE_PROTOCOL = PROTOCOL;
    String BASE_DOMAIN = DOMAIN_STAGING;

    String PATH_SEARCH = "ws/search.pl";

    String URL_SEARCH_PRODUCTS = BASE_PROTOCOL + BASE_DOMAIN + PATH_SEARCH;
}

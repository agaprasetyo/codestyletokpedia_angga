package id.angga.democodetokopedia.responsemodel.resultsearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Angga.Prasetiyo on 11/08/2015.
 */
public class ProductData {

    @SerializedName("shop_is_favorited")
    @Expose
    private Integer shopIsFavorited;
    @SerializedName("shop_gold_status")
    @Expose
    private Integer shopGoldStatus;
    @SerializedName("shop_id")
    @Expose
    private Integer shopId;
    @SerializedName("rate_desc")
    @Expose
    private String rateDesc;
    @SerializedName("shop_url")
    @Expose
    private String shopUrl;
    @SerializedName("rate")
    @Expose
    private Integer rate;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("product_image_full")
    @Expose
    private String productImageFull;
    @SerializedName("product_image")
    @Expose
    private String productImage;
    @SerializedName("product_talk_count")
    @Expose
    private String productTalkCount;
    @SerializedName("product_price")
    @Expose
    private String productPrice;
    @SerializedName("product_sold_count")
    @Expose
    private String productSoldCount;
    @SerializedName("shop_location")
    @Expose
    private String shopLocation;
    @SerializedName("product_wholesale")
    @Expose
    private Integer productWholesale;
    @SerializedName("product_review_count")
    @Expose
    private String productReviewCount;
    @SerializedName("shop_name")
    @Expose
    private String shopName;
    @SerializedName("shop_is_owner")
    @Expose
    private Integer shopIsOwner;
    @SerializedName("product_url")
    @Expose
    private String productUrl;
    @SerializedName("product_name")
    @Expose
    private String productName;

    public Integer getShopIsFavorited() {
        return shopIsFavorited;
    }

    public void setShopIsFavorited(Integer shopIsFavorited) {
        this.shopIsFavorited = shopIsFavorited;
    }

    public Integer getShopGoldStatus() {
        return shopGoldStatus;
    }

    public void setShopGoldStatus(Integer shopGoldStatus) {
        this.shopGoldStatus = shopGoldStatus;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getRateDesc() {
        return rateDesc;
    }

    public void setRateDesc(String rateDesc) {
        this.rateDesc = rateDesc;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductImageFull() {
        return productImageFull;
    }

    public void setProductImageFull(String productImageFull) {
        this.productImageFull = productImageFull;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductTalkCount() {
        return productTalkCount;
    }

    public void setProductTalkCount(String productTalkCount) {
        this.productTalkCount = productTalkCount;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductSoldCount() {
        return productSoldCount;
    }

    public void setProductSoldCount(String productSoldCount) {
        this.productSoldCount = productSoldCount;
    }

    public String getShopLocation() {
        return shopLocation;
    }

    public void setShopLocation(String shopLocation) {
        this.shopLocation = shopLocation;
    }

    public Integer getProductWholesale() {
        return productWholesale;
    }

    public void setProductWholesale(Integer productWholesale) {
        this.productWholesale = productWholesale;
    }

    public String getProductReviewCount() {
        return productReviewCount;
    }

    public void setProductReviewCount(String productReviewCount) {
        this.productReviewCount = productReviewCount;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getShopIsOwner() {
        return shopIsOwner;
    }

    public void setShopIsOwner(Integer shopIsOwner) {
        this.shopIsOwner = shopIsOwner;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

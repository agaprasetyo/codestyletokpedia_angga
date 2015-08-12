package id.angga.democodetokopedia.containersearchproduct.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

import id.angga.democodetokopedia.R;
import id.angga.democodetokopedia.responsemodel.resultsearch.ProductData;

/**
 * Created by Angga.Prasetiyo on 12/08/2015.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    List<ProductData> productDataList = new ArrayList<>();

    public ProductListAdapter(ArrayList<ProductData> productDatas) {
        this.productDataList = productDatas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_product_search, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(productDataList.get(position).getProductImage(), holder.imageView, getDisplayImage());
        holder.tvTitle.setText(productDataList.get(position).getProductName());
        holder.tvPrice.setText(productDataList.get(position).getProductPrice());
        holder.tvShop.setText(productDataList.get(position).getShopName());
    }

    @Override
    public int getItemCount() {
        return productDataList.size();
    }

    public void addItem(ProductData productData) {
        productDataList.add(productData);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView imageView;
        private TextView tvTitle;
        private TextView tvPrice;
        private TextView tvShop;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            imageView = (ImageView) itemView.findViewById(R.id.iv_1);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvShop = (TextView) itemView.findViewById(R.id.tv_shop);
        }
    }

    private DisplayImageOptions getDisplayImage() {
        return new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .displayer(new FadeInBitmapDisplayer(1000))
                .build();
    }


}

// Generated by view binder compiler. Do not edit!
package com.hackeranushi.grocerywalla.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;
import com.skydoves.elasticviews.ElasticFloatingActionButton;
import com.skydoves.elasticviews.ElasticImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import me.relex.circleindicator.CircleIndicator;

public final class ActivityProductInfoBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final AppBarLayout appBar;

  @NonNull
  public final LinearLayout couponLayout;

  @NonNull
  public final LinearLayout footer;

  @NonNull
  public final TextView includedAllTax;

  @NonNull
  public final View mycartDivider;

  @NonNull
  public final TextView mycartProductTag;

  @NonNull
  public final TextView mycartProductTitle;

  @NonNull
  public final ElasticButton productDetailAddToCartButton;

  @NonNull
  public final CircleIndicator productDetailCircleIndicator;

  @NonNull
  public final ElasticButton productDetailContinuePayment;

  @NonNull
  public final TextView productDetailCutPrice;

  @NonNull
  public final TextView productDetailCutPriceTagLine;

  @NonNull
  public final TabLayout productDetailDescTab;

  @NonNull
  public final TextView productDetailLookLikeProduct;

  @NonNull
  public final RecyclerView productDetailMoreItemRecycle;

  @NonNull
  public final TextView productDetailPopularProduct;

  @NonNull
  public final RecyclerView productDetailPopularProductRecycle;

  @NonNull
  public final TextView productDetailProductName;

  @NonNull
  public final TextView productDetailProductPrice;

  @NonNull
  public final LinearLayout productDetailRating;

  @NonNull
  public final ElasticImageView productDetailShare;

  @NonNull
  public final TextView productDetailUnitDensity;

  @NonNull
  public final ViewPager2 productDetailViewpageTab;

  @NonNull
  public final ViewPager productDetailViewpager;

  @NonNull
  public final ElasticFloatingActionButton productDetailWishList;

  @NonNull
  public final TextView productOfferPrice;

  @NonNull
  public final NestedScrollView productScroll;

  @NonNull
  public final Toolbar toolbar;

  private ActivityProductInfoBinding(@NonNull RelativeLayout rootView, @NonNull AppBarLayout appBar,
      @NonNull LinearLayout couponLayout, @NonNull LinearLayout footer,
      @NonNull TextView includedAllTax, @NonNull View mycartDivider,
      @NonNull TextView mycartProductTag, @NonNull TextView mycartProductTitle,
      @NonNull ElasticButton productDetailAddToCartButton,
      @NonNull CircleIndicator productDetailCircleIndicator,
      @NonNull ElasticButton productDetailContinuePayment, @NonNull TextView productDetailCutPrice,
      @NonNull TextView productDetailCutPriceTagLine, @NonNull TabLayout productDetailDescTab,
      @NonNull TextView productDetailLookLikeProduct,
      @NonNull RecyclerView productDetailMoreItemRecycle,
      @NonNull TextView productDetailPopularProduct,
      @NonNull RecyclerView productDetailPopularProductRecycle,
      @NonNull TextView productDetailProductName, @NonNull TextView productDetailProductPrice,
      @NonNull LinearLayout productDetailRating, @NonNull ElasticImageView productDetailShare,
      @NonNull TextView productDetailUnitDensity, @NonNull ViewPager2 productDetailViewpageTab,
      @NonNull ViewPager productDetailViewpager,
      @NonNull ElasticFloatingActionButton productDetailWishList,
      @NonNull TextView productOfferPrice, @NonNull NestedScrollView productScroll,
      @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.appBar = appBar;
    this.couponLayout = couponLayout;
    this.footer = footer;
    this.includedAllTax = includedAllTax;
    this.mycartDivider = mycartDivider;
    this.mycartProductTag = mycartProductTag;
    this.mycartProductTitle = mycartProductTitle;
    this.productDetailAddToCartButton = productDetailAddToCartButton;
    this.productDetailCircleIndicator = productDetailCircleIndicator;
    this.productDetailContinuePayment = productDetailContinuePayment;
    this.productDetailCutPrice = productDetailCutPrice;
    this.productDetailCutPriceTagLine = productDetailCutPriceTagLine;
    this.productDetailDescTab = productDetailDescTab;
    this.productDetailLookLikeProduct = productDetailLookLikeProduct;
    this.productDetailMoreItemRecycle = productDetailMoreItemRecycle;
    this.productDetailPopularProduct = productDetailPopularProduct;
    this.productDetailPopularProductRecycle = productDetailPopularProductRecycle;
    this.productDetailProductName = productDetailProductName;
    this.productDetailProductPrice = productDetailProductPrice;
    this.productDetailRating = productDetailRating;
    this.productDetailShare = productDetailShare;
    this.productDetailUnitDensity = productDetailUnitDensity;
    this.productDetailViewpageTab = productDetailViewpageTab;
    this.productDetailViewpager = productDetailViewpager;
    this.productDetailWishList = productDetailWishList;
    this.productOfferPrice = productOfferPrice;
    this.productScroll = productScroll;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProductInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProductInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_product_info, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProductInfoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_bar;
      AppBarLayout appBar = ViewBindings.findChildViewById(rootView, id);
      if (appBar == null) {
        break missingId;
      }

      id = R.id.coupon_layout;
      LinearLayout couponLayout = ViewBindings.findChildViewById(rootView, id);
      if (couponLayout == null) {
        break missingId;
      }

      id = R.id.footer;
      LinearLayout footer = ViewBindings.findChildViewById(rootView, id);
      if (footer == null) {
        break missingId;
      }

      id = R.id.included_all_tax;
      TextView includedAllTax = ViewBindings.findChildViewById(rootView, id);
      if (includedAllTax == null) {
        break missingId;
      }

      id = R.id.mycart_divider;
      View mycartDivider = ViewBindings.findChildViewById(rootView, id);
      if (mycartDivider == null) {
        break missingId;
      }

      id = R.id.mycart_product_tag;
      TextView mycartProductTag = ViewBindings.findChildViewById(rootView, id);
      if (mycartProductTag == null) {
        break missingId;
      }

      id = R.id.mycart_product_title;
      TextView mycartProductTitle = ViewBindings.findChildViewById(rootView, id);
      if (mycartProductTitle == null) {
        break missingId;
      }

      id = R.id.product_detail_addToCart_button;
      ElasticButton productDetailAddToCartButton = ViewBindings.findChildViewById(rootView, id);
      if (productDetailAddToCartButton == null) {
        break missingId;
      }

      id = R.id.product_detail_circle_indicator;
      CircleIndicator productDetailCircleIndicator = ViewBindings.findChildViewById(rootView, id);
      if (productDetailCircleIndicator == null) {
        break missingId;
      }

      id = R.id.product_detail_continue_payment;
      ElasticButton productDetailContinuePayment = ViewBindings.findChildViewById(rootView, id);
      if (productDetailContinuePayment == null) {
        break missingId;
      }

      id = R.id.product_detail_cut_price;
      TextView productDetailCutPrice = ViewBindings.findChildViewById(rootView, id);
      if (productDetailCutPrice == null) {
        break missingId;
      }

      id = R.id.product_detail_cut_price_tag_line;
      TextView productDetailCutPriceTagLine = ViewBindings.findChildViewById(rootView, id);
      if (productDetailCutPriceTagLine == null) {
        break missingId;
      }

      id = R.id.product_detail_desc_tab;
      TabLayout productDetailDescTab = ViewBindings.findChildViewById(rootView, id);
      if (productDetailDescTab == null) {
        break missingId;
      }

      id = R.id.product_detail_lookLike_product;
      TextView productDetailLookLikeProduct = ViewBindings.findChildViewById(rootView, id);
      if (productDetailLookLikeProduct == null) {
        break missingId;
      }

      id = R.id.product_detail_more_item_recycle;
      RecyclerView productDetailMoreItemRecycle = ViewBindings.findChildViewById(rootView, id);
      if (productDetailMoreItemRecycle == null) {
        break missingId;
      }

      id = R.id.product_detail_popular_product;
      TextView productDetailPopularProduct = ViewBindings.findChildViewById(rootView, id);
      if (productDetailPopularProduct == null) {
        break missingId;
      }

      id = R.id.product_detail_popular_product_recycle;
      RecyclerView productDetailPopularProductRecycle = ViewBindings.findChildViewById(rootView, id);
      if (productDetailPopularProductRecycle == null) {
        break missingId;
      }

      id = R.id.product_detail_product_name;
      TextView productDetailProductName = ViewBindings.findChildViewById(rootView, id);
      if (productDetailProductName == null) {
        break missingId;
      }

      id = R.id.product_detail_product_price;
      TextView productDetailProductPrice = ViewBindings.findChildViewById(rootView, id);
      if (productDetailProductPrice == null) {
        break missingId;
      }

      id = R.id.product_detail_rating;
      LinearLayout productDetailRating = ViewBindings.findChildViewById(rootView, id);
      if (productDetailRating == null) {
        break missingId;
      }

      id = R.id.product_detail_share;
      ElasticImageView productDetailShare = ViewBindings.findChildViewById(rootView, id);
      if (productDetailShare == null) {
        break missingId;
      }

      id = R.id.product_detail_unit_density;
      TextView productDetailUnitDensity = ViewBindings.findChildViewById(rootView, id);
      if (productDetailUnitDensity == null) {
        break missingId;
      }

      id = R.id.product_detail_viewpage_tab;
      ViewPager2 productDetailViewpageTab = ViewBindings.findChildViewById(rootView, id);
      if (productDetailViewpageTab == null) {
        break missingId;
      }

      id = R.id.product_detail_viewpager;
      ViewPager productDetailViewpager = ViewBindings.findChildViewById(rootView, id);
      if (productDetailViewpager == null) {
        break missingId;
      }

      id = R.id.product_detail_wishList;
      ElasticFloatingActionButton productDetailWishList = ViewBindings.findChildViewById(rootView, id);
      if (productDetailWishList == null) {
        break missingId;
      }

      id = R.id.product_offer_price;
      TextView productOfferPrice = ViewBindings.findChildViewById(rootView, id);
      if (productOfferPrice == null) {
        break missingId;
      }

      id = R.id.productScroll;
      NestedScrollView productScroll = ViewBindings.findChildViewById(rootView, id);
      if (productScroll == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new ActivityProductInfoBinding((RelativeLayout) rootView, appBar, couponLayout, footer,
          includedAllTax, mycartDivider, mycartProductTag, mycartProductTitle,
          productDetailAddToCartButton, productDetailCircleIndicator, productDetailContinuePayment,
          productDetailCutPrice, productDetailCutPriceTagLine, productDetailDescTab,
          productDetailLookLikeProduct, productDetailMoreItemRecycle, productDetailPopularProduct,
          productDetailPopularProductRecycle, productDetailProductName, productDetailProductPrice,
          productDetailRating, productDetailShare, productDetailUnitDensity,
          productDetailViewpageTab, productDetailViewpager, productDetailWishList,
          productOfferPrice, productScroll, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

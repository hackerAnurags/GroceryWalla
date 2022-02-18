package com.hackeranushi.grocerywalla.FragmentHome;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static com.hackeranushi.grocerywalla.Helper.GroceryConst.userEmail;
import static com.hackeranushi.grocerywalla.Helper.GroceryConst.userName;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hackeranushi.grocerywalla.Activities.Authentication;
import com.hackeranushi.grocerywalla.Helper.GroceryConst;
import com.hackeranushi.grocerywalla.Helper.SharedPrefManager;
import com.hackeranushi.grocerywalla.MenuActivity.NotificationHomepage;
import com.hackeranushi.grocerywalla.ProfileActivity.AboutUs;
import com.hackeranushi.grocerywalla.ProfileActivity.Coupons.Coupons;
import com.hackeranushi.grocerywalla.ProfileActivity.CustomerSupport.CustomerSupport;
import com.hackeranushi.grocerywalla.ProfileActivity.Addresses.MyAddress;
import com.hackeranushi.grocerywalla.ProfileActivity.EditProfileActivity.EditProfile;
import com.hackeranushi.grocerywalla.ProfileActivity.PrivacyPolicy;
import com.hackeranushi.grocerywalla.ProfileActivity.Setting;
import com.hackeranushi.grocerywalla.ProfileActivity.TermsConditions;
import com.hackeranushi.grocerywalla.ProfileActivity.WishList.WishList;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    ElasticButton logOut;
    CircleImageView profileImage;
    LinearLayout order,aboutUs,notification,share,address,coupon,setting,rateUs,
    wishlist,cart,termsConditions,privacy,editProfile,customerSupport;
    FirebaseAuth mAuth;
    String name,email,uid,profile_image;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        init(view);



        mAuth = FirebaseAuth.getInstance();

        logOut = view.findViewById(R.id.logout);
        profileImage = view.findViewById(R.id.profile_image);
        order = view.findViewById(R.id.order);
        aboutUs = view.findViewById(R.id.about_us);
        notification = view.findViewById(R.id.notification);
        share = view.findViewById(R.id.share);
        address = view.findViewById(R.id.address);
        coupon = view.findViewById(R.id.coupons);
        wishlist = view.findViewById(R.id.wishlist);
        cart = view.findViewById(R.id.cart);
        termsConditions = view.findViewById(R.id.terms_conditions);
        privacy = view.findViewById(R.id.privacy);
        editProfile = view.findViewById(R.id.edit_profile);
        setting = view.findViewById(R.id.setting);
        rateUs = view.findViewById(R.id.rate_us);
        customerSupport = view.findViewById(R.id.customer_support);


        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrderFragment orderFragment = new OrderFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, orderFragment);
                fragmentTransaction.addToBackStack("Order");
                fragmentTransaction.commit();
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartFragment myCartFragment = new CartFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, myCartFragment);
                fragmentTransaction.addToBackStack("Cart");
                fragmentTransaction.commit();
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notificationIntent = new Intent(getActivity(), NotificationHomepage.class);
                startActivity(notificationIntent);
            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addressIntent = new Intent(getActivity(), MyAddress.class);
                startActivity(addressIntent);
            }
        });

        coupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent couponIntent = new Intent(getActivity(), Coupons.class);
                startActivity(couponIntent);
            }
        });

        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wishIntent = new Intent(getActivity(), WishList.class);
                startActivity(wishIntent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingIntent = new Intent(getActivity(), Setting.class);
                startActivity(settingIntent);
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutIntent = new Intent(getActivity(), AboutUs.class);
                startActivity(aboutIntent);
            }
        });

        termsConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent termsIntent = new Intent(getActivity(), TermsConditions.class);
                startActivity(termsIntent);
            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent privacyIntent = new Intent(getActivity(), PrivacyPolicy.class);
                startActivity(privacyIntent);
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editIntent = new Intent(getActivity(), EditProfile.class);
                startActivity(editIntent);
            }
        });


        customerSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent customerIntent = new Intent(getActivity(), CustomerSupport.class);
                startActivity(customerIntent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ref_link = "";

                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                share.putExtra(Intent.EXTRA_SUBJECT, "This is for sharing via  any app......+");
                share.putExtra(Intent.EXTRA_TEXT, ref_link);
                startActivity(Intent.createChooser(share, "Share link!"));

            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                SharedPrefManager sharedPrefManager = new SharedPrefManager(getActivity());
//                sharedPrefManager.logout();
//                mAuth.signOut();
                GroceryConst.sharedPreferences.edit().clear().apply();
                mAuth.signOut();
                Intent intent = new Intent(getActivity(), Authentication.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

//        Glide.with(requireActivity()).load(GroceryConst.sharedPreferences.
//                getString(GroceryConst.Keys.USER_Img,"")).optionalCircleCrop().into(profileImage);

//        Picasso.with(requireActivity())
//                .load(GroceryConst.sharedPreferences.
//                getString(GroceryConst.Keys.USER_Img,""))
//                .into(profileImage);

        setProfileData();

//        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        //Take data from Firebase
//        uid = user.getUid();
//        FirebaseFirestore.getInstance().collection("users").document(uid).get()
//                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                    @Override
//                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                        if (!documentSnapshot.exists()) {
//                            Log.d("Not Exist", "List is empty");
//                            return;
//                        } else {
//                            try {
//                                name = documentSnapshot.get("user_name").toString();
//                                email = documentSnapshot.get("user_email").toString();
//                                profile_image = documentSnapshot.get("user_img").toString();
//                            } catch (Exception e) {
//                                Toast.makeText(getActivity(), "Gender field none", Toast.LENGTH_SHORT).show();
//                            }
//                            profileName.setText(name);
//                            profileEmail.setText(email);
//                            setImage();
//                        }
//                    }
//                });
        return view;
    }

    private void init(View view) {
        GroceryConst.sharedPreferences = requireActivity().getSharedPreferences(GroceryConst.sp_name, MODE_PRIVATE);
        GroceryConst.editor = GroceryConst.sharedPreferences.edit();

        userName = view.findViewById(R.id.profile_name);
        userEmail = view.findViewById(R.id.profile_email);
        if (GroceryConst.sharedPreferences.contains(GroceryConst.EmailKeys.UID))
        {
            userName.setText( GroceryConst.sharedPreferences.getString(GroceryConst.EmailKeys.USER_NAME,""));
            userEmail.setText(GroceryConst.sharedPreferences.getString(GroceryConst.EmailKeys.USER_EMAIL,""));

            Log.d("abcdefggvhg....", " Name: "+GroceryConst.sharedPreferences.getString(GroceryConst.EmailKeys.USER_NAME,"")
                    +"\n email: "+GroceryConst.sharedPreferences.getString(GroceryConst.EmailKeys.USER_EMAIL,""));

        }
        if (GroceryConst.sharedPreferences.contains(GroceryConst.OtpKeys.UID))
        {
            userName.setText(GroceryConst.sharedPreferences.getString(GroceryConst.OtpKeys.USER_NAME,""));
            userEmail.setText(GroceryConst.sharedPreferences.getString(GroceryConst.OtpKeys.USER_EMAIL,""));

        }
    }

    private void setProfileData() {




    }
}
package com.hackeranushi.grocerywalla.ProfileActivity.CustomerSupport.expandableAdapter;



import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.hackeranushi.grocerywalla.R;

public class PlacingQueryAdapter extends BaseExpandableListAdapter {

    String [] title = {"How can I be sure the fruit and vegetables I order are good quality?",
            "Is it safe to use my debit/credit card to shop on GroceryWalla?",
            "Can I schedule an order to my convenience?"};

    String [] [] answer= {
            {"Our fruits and vegetables vendors have a quality check process in place to ensure quality of the item delivered is up to teh mark. Do let us know within 24 hours if you're not happy with the quality of product received."},

            {"Yes, it is. All transaction on GroceryWalla are completed viva secure payment gateway (RazorPay Payment Gateway)."},

            {"Sure. At the checkout page, you can select a delivery slot of your choice"},
    };

    Context context;

    public PlacingQueryAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return title.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return answer[i].length;
    }

    @Override
    public Object getGroup(int i) {
        return title[i];
    }

    @Override
    public Object getChild(int i, int i1) {
        return answer[i][i1];
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String questionFaq = (String) getGroup(i);
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) this
                    .context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.cutomerinfo_tytle,null);
        }
        TextView queTitle = view.findViewById(R.id.customer_question);
        queTitle.setTypeface(null, Typeface.BOLD);
        queTitle.setText(questionFaq);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final String answerFaq = (String) getChild(i,i1);

        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.customerinfo_answer,null);
        }
        TextView ansFaq = view.findViewById(R.id.customer_answer);
        ansFaq.setText(answerFaq);

        return view;


    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}



package com.hackeranushi.grocerywalla.ProfileActivity.CustomerSupport.expandableAdapter;




import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.hackeranushi.grocerywalla.R;

public class PaymentQueryAdapter extends BaseExpandableListAdapter {

    String [] title = {"How can I make payment to GroceryWalla?",
            "When will I get my cashback?",
            "How long do you take to initiate my refund?",
            "How can I review my receipt"};

    String [] [] answer= {
            {"GroceryWalla accepts multiple modes of payment. You can make online payment using debit cards, NetBanking, PayTm. Cash on Delivery (COD) is also available for order."},

            {"If your transaction is eligible for cashback, you will receive it within 72 hours of delivery in your Grocerywalla wallet."},

            {"In the case of refund , for amount less than Rs. 500/- Your amount which be visible on the GroceryWalla wallet. if amount is more than Rs. 500/- it's your choice you can save the amount in your wallwt or withdraw the amount."},

            {"When your products is delivered the receipt is also carried out You can also review your receipt to your product. If any issues is here you can text me on customer support pages (above)."},
    };
    Context context;

    public PaymentQueryAdapter(Context context) {
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



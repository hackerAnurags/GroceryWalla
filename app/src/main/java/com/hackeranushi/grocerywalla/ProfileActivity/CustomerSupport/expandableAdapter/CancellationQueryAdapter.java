package com.hackeranushi.grocerywalla.ProfileActivity.CustomerSupport.expandableAdapter;



import static com.hackeranushi.grocerywalla.R.drawable.ic_baseline_keyboard_arrow_up_24;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hackeranushi.grocerywalla.R;

public class CancellationQueryAdapter extends BaseExpandableListAdapter {

    String [] title = {"How can I cancel my order?",
            "Waht if I want to return something?",
            "Can I rescheduled my order?"};

    String [] [] answer= {
            {"GroceryWalla provides easy and hassle-free cancellation. You can cancel your order via the app before it dispatched to you hme.This option is available under the 'My Order' tab."},

            {"If you're dissatisfied with the product delivery, please register a complaint via te app (Customer Support Page) within 48 hours for non-perishable item and 24 hour for perishable item.Our customer support team will get in touch with you to resolve this issue.You can also return the product which are dissatisfying at the time of delivery and we weill get the refund initiated for you."},

            {"Yes, You can also rescheduled your project before dispatch the product to you homes."},
    };

    Context context;

    public CancellationQueryAdapter(Context context) {
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


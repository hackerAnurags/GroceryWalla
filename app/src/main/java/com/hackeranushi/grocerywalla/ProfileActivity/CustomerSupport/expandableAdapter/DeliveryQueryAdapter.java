package com.hackeranushi.grocerywalla.ProfileActivity.CustomerSupport.expandableAdapter;




import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.hackeranushi.grocerywalla.R;

public class DeliveryQueryAdapter extends BaseExpandableListAdapter {

    String [] title = {"Do you charge for delivery?",
    "What are your delivery times?",
    "Can I change the Delivery Address of my order?"};

    String [] [] answer= {
            {"Every Delivery Store has won charges which are waived off it you order above a specified price minimum amount form the sore. The minimum charges and the delivery charges are mentioned on the app and the checkout page. "},

            {"In some locations, our delivery begin from morning and the last delivery is 9 pm."},

            {"At this time, we do not offer this option. You can,however,cancel your order and recorder in a different locality"},
    };

    Context context;

    public DeliveryQueryAdapter(Context context) {
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


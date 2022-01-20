package com.hackeranushi.grocerywalla.ProfileActivity.CustomerSupport.expandableAdapter;




import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.hackeranushi.grocerywalla.R;

public class GeneralQueryAdapter extends BaseExpandableListAdapter {

    String [] title = {"What Cities do yu operate in?",
            "Do You Deliver in my location?",
            "What is the minimum order value?",
            "Can I track the status of my order?"};

    String [] [] answer= {
            {"GroceryWalla currently operates in Noida, Chapra."},

            {"We Deliver in select localities accross the city we are present in. You can edit your location setting to check if we deliver in area."},

            {"There is no minimum order value. However, each store has a minimum order value to qualify for free delivery."},

            {"No You can't it."},
    };
    Context context;

    public GeneralQueryAdapter(Context context) {
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



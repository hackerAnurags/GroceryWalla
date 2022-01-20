package com.hackeranushi.grocerywalla.ProductDetails.ExpandableAdapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.hackeranushi.grocerywalla.R;

public class InfoAdapter extends BaseExpandableListAdapter {

    String [] title = {"Shelf Life","Manufacturer Details","Marked By","Disclaimer",
            "Country f Origin","Customer Care Details","Seller"};

    String [] [] answer= {
            {"120 days"},
            {"Bla Bla Bla Food Specialities Limited."},
            {"Noida"},
            {"Every effort is made to maintain and accuracy of all information."},
            {"India"},
            {"Customer Care No- 1234567890"},
            {"bla bla pvt limited."}
    };

    Context context;

    public InfoAdapter(Context context) {
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
            view = inflater.inflate(R.layout.title,null);
        }
        TextView queTitle = view.findViewById(R.id.title_text);
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
            view = inflater.inflate(R.layout.answer,null);
        }
        TextView ansFaq = view.findViewById(R.id.collapse_answer);
        ansFaq.setText(answerFaq);

        return view;


    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}

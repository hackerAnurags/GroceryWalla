package com.hackeranushi.grocerywalla.ProductDetails.ProductRating.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.hackeranushi.grocerywalla.R;

public class ExpandableAdapter extends BaseExpandableListAdapter {
    String [] title = {"it is usable after 1 month","Weight accurate or not","What time this product is use after is unpacked"
            ,"Marked By","accuracy details", "Country of Origin",};

    String [] [] answer= {
            {"Yes Sure Uou can use it\n\n"+"sender : bla bla\n\n"+"certified buyer"},
            {"5 kg net\n\n"+"sender : bla bla\n\n"+"certified buyer"},
            {"Until the product is not expired it\n\n"+"sender : bla bla\n\n"+"certified buyer"},
            {"Noida\n\n"+"sender : bla bla\n\n"+"certified buyer"},
            {"Every effort is made to maintain and accuracy of all information\n\n"+"sender : bla bla\n\n"+"certified buyer"},
            {"India\n\n"+"sender : bla bla\n\n"+"certified buyer"},
    };

    Context context;

    public ExpandableAdapter(Context context) {
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

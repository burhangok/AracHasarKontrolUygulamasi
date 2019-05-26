package com.burhangok.arahasarkontrol;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends BaseAdapter implements Filterable {

    public List<QuestionItem> getQuestionItemList() {
        return questionItemList;
    }

    List<QuestionItem> questionItemList;
    List<QuestionItem> mStringFilterList;
    ValueFilter valueFilter;


    public QuestionAdapter(Activity activity,List<QuestionItem> questionItemList) {
        this.questionItemList = questionItemList;
        this.layoutInflater= (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  mStringFilterList = questionItemList;
    }

    LayoutInflater layoutInflater;

    @Override
    public int getCount() {
        return questionItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return questionItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView = layoutInflater.inflate(R.layout.row_layout,null);

        CheckBox questionCB =rowView.findViewById(R.id.question);

        final QuestionItem questionItem= questionItemList.get(position);

        questionCB.setText(questionItem.getQuestionText());


        questionCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                questionItemList.get(position).setQuestionStatus(isChecked);

            }
        });

        return rowView;
    }

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                ArrayList<QuestionItem> filterList = new ArrayList<QuestionItem>();
                for (int i = 0; i < mStringFilterList.size(); i++) {
                    if ((mStringFilterList.get(i).getQuestionText().toUpperCase())
                            .contains(constraint.toString().toUpperCase())) {

                        QuestionItem question = new QuestionItem(mStringFilterList.get(i)
                                .getQuestionText(), mStringFilterList.get(i)
                                .isQuestionStatus());
                        filterList.add(question);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mStringFilterList.size();
                results.values = mStringFilterList;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            questionItemList = (ArrayList<QuestionItem>) results.values;
            notifyDataSetChanged();
        }

    }


}
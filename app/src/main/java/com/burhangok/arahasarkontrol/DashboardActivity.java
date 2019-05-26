package com.burhangok.arahasarkontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    ListView questionsLV;

    QuestionAdapter questionAdapter;

    List<QuestionItem> questionItemList = new ArrayList<>();

    EditText keywordET;

    Button saveBTN;

    public static int countDamage=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        init();

        questionLoad();

        questionAdapter = new QuestionAdapter(this,questionItemList);

        questionsLV.setAdapter(questionAdapter);

        keywordET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
questionAdapter.getFilter().filter(s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             List<QuestionItem>  questionList =  questionAdapter.getQuestionItemList();

                for (QuestionItem question:questionList
                     ) {
                    if(question.isQuestionStatus()) {
                        countDamage++;
                    }
                }


                Intent toResult = new Intent(DashboardActivity.this,ResultActivity.class);
                toResult.putExtra("count",countDamage);
                startActivity(toResult);
            }
        });
    }

    private void questionLoad() {

        questionItemList.add(new QuestionItem("Hava yastığı açılmış mı ?",false));

        questionItemList.add(new QuestionItem("Sağ ön kapıda darbe var mı?",false));

        questionItemList.add(new QuestionItem("Sağ arka kapıda darbe var mı?",false));

        questionItemList.add(new QuestionItem("Sol ön kapıda darbe var mı?",false));

        questionItemList.add(new QuestionItem("Sol arka kapıda darbe var mı?",false));


        questionItemList.add(new QuestionItem("Arka tamponda kapıda darbe var mı?",false));


        questionItemList.add(new QuestionItem("Ön tamponda darbe var mı?",false));

        questionItemList.add(new QuestionItem("Yan tamponlarda  darbe var mı?",false));

        questionItemList.add(new QuestionItem("Ön farlarda darbe var mı?",false));

        questionItemList.add(new QuestionItem("Arka farlarda darbe var mı?",false));


        questionItemList.add(new QuestionItem("Jantlarda darbe var mı?",false));


        questionItemList.add(new QuestionItem("Şasede darbe var mı?",false));

        questionItemList.add(new QuestionItem("Camlarda çatlak/kırık var mı?",false));

        questionItemList.add(new QuestionItem("Motorda darbe var mı?",false));

    }


    void init () {
        questionsLV =findViewById(R.id.checklist);

        keywordET =findViewById(R.id.keywordQ);

        saveBTN = findViewById(R.id.save);

    }
}

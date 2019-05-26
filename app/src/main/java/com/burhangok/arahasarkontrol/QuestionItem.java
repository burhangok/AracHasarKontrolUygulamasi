package com.burhangok.arahasarkontrol;

import java.io.Serializable;

public class QuestionItem implements Serializable {

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean isQuestionStatus() {
        return questionStatus;
    }

    public void setQuestionStatus(boolean questionStatus) {
        this.questionStatus = questionStatus;
    }

    private String questionText;

    public QuestionItem() {
    }

    public QuestionItem(String questionText, boolean questionStatus) {
        this.questionText = questionText;
        this.questionStatus = questionStatus;
    }

    private boolean questionStatus;
}

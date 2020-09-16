package com.dsm.gyeongsang.domains.form;

import com.dsm.gyeongsang.domains.domain.DiaryBook;

import java.util.List;

public class DiaryBookListResponseForm {
    private List<DiaryBook> diaryBookList;

    public DiaryBookListResponseForm() {}
    public DiaryBookListResponseForm(List<DiaryBook> diaryBookList) {
        this.diaryBookList = diaryBookList;
    }

    public List<DiaryBook> getDiaryBookList() {
        return diaryBookList;
    }

    public void setDiaryBookList(List<DiaryBook> diaryBookList) {
        this.diaryBookList = diaryBookList;
    }
}

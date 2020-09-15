package com.dsm.gyeongsang.domains.domain;

import javax.persistence.*;

@Entity
@Table(name = "participation_personnel_list")
@IdClass(ParticipantId.class)
public class Participant {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "diary_book_id", referencedColumnName = "id")
    private DiaryBook diaryBook;

    public Participant() {}
    public Participant(User user, DiaryBook diaryBook) {
        this.user = user;
        this.diaryBook = diaryBook;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DiaryBook getDiaryBook() {
        return diaryBook;
    }

    public void setDiaryBook(DiaryBook diaryBook) {
        this.diaryBook = diaryBook;
    }
}

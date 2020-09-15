package com.dsm.gyeongsang.domains.domain;

import java.io.Serializable;
import java.util.Objects;

public class ParticipantId implements Serializable {

    private String user;
    private int diaryBook;

    public ParticipantId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantId that = (ParticipantId) o;
        return diaryBook == that.diaryBook &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, diaryBook);
    }
}

package com.dsm.gyeongsang.domains.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "diary_book")
public class DiaryBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(example = "id", required = true)
    private int id;

    @Column(name = "name")
    @ApiModelProperty(example = "내 소듕한 일기장", required = true)
    private String name;

    @Column(name = "code")
    @ApiModelProperty(example = "030816", required = true)
    private String code;

    @Column(name = "owner")
    @ApiModelProperty(example = "이진혁", required = true)
    private String owner;

    public DiaryBook() {}
    public DiaryBook(int id, String name, String code, String owner) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

package com.ksh.firenote;

import java.util.Date;

public class Memo {

    private String txt, title , key;
    private long createDate, updateDate;

    public String getTxt() {
        return txt;
    }

    public long getCreateDate() {
        return createDate;
    }

    public long getUpdateDate() {
        return updateDate;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(long updateDate) {
        this.updateDate = updateDate;
    }

    public String getTitle() {


        if (txt != null) {
            if (txt.indexOf("\n") > -1) {
                title = txt.substring(0, txt.indexOf("\n"));
            } else {
                title =  txt;
            }
        }
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}


package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsWallPaper extends TLObject {

    protected int id;

    protected String title;

    protected int color;


    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int value) {
        this.color = value;
    }

}

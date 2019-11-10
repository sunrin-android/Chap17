package com.example.test17;

public abstract class Item {
    static final int TYPE_HEADER = 0;
    static final int TYPE_DATA = 1;

    abstract int getType();
}

class HeaderItem extends Item {
    String title;

    @Override
    int getType() {
        return Item.TYPE_HEADER;
    }
}

class DataItem extends Item {
    String name, date;

    @Override
    int getType() {
        return Item.TYPE_DATA;
    }
}

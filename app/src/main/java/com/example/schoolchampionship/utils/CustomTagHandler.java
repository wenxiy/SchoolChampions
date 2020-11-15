package com.example.schoolchampionship.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.Editable;
import android.text.Html;

import org.xml.sax.XMLReader;

/**
 * 自定义HTML的tag
 */
public class CustomTagHandler implements Html.TagHandler {
    private final String TAG = "CustomTagHandler";

    private int startIndex = 0;
    private int stopIndex = 0;

    private ColorStateList mOriginColors;
    private Context mContext;
    @Override
    public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {

    }
}

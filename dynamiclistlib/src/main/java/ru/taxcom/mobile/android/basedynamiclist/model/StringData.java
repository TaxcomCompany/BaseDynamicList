package ru.taxcom.mobile.android.basedynamiclist.model;


import ru.taxcom.mobile.android.basedynamiclist.utils.EqualUtil;

public class StringData extends ListData {

    private String mText;

    public StringData(String text) {
        mText = text;
    }

    public void setText(String text) {
        mText = text;
    }

    public String getText() {
        return mText;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof StringData)) {
            StringData item = (StringData) obj;
            return EqualUtil.safeEqual(mText, item.getText());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 31 + (mText == null ? 0 : mText.hashCode());
    }
}

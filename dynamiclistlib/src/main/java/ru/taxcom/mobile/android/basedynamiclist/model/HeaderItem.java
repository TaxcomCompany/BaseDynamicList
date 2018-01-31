package ru.taxcom.mobile.android.basedynamiclist.model;


public class HeaderItem implements BaseListItem {

    protected String mText;

    public void setText(String text) {
        mText = text;
    }

    public String getText() {
        return mText;
    }

    @Override
    public Type getType() {
        return Type.HEADER;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof HeaderItem)) {
            HeaderItem item = (HeaderItem) obj;
            if (mText == item.getText()) {
                return true;
            } else if (mText == null || item.getText() == null) {
                return false;
            } else {
                return mText.equals(item.getText());
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 31 + (mText == null ? 0 : mText.hashCode());
    }
}

package ru.taxcom.mobile.android.basedynamiclist.utils;

public class EqualUtil {

    public static boolean safeEqual(Object o1, Object o2) {
        if (o1 == o2) {
            return true;
        } else if (o1 == null || o2 == null) {
            return false;
        } else if (!o1.getClass().equals(o2.getClass())) {
            return false;
        } else {
            return o1.equals(o2);
        }
    }
}

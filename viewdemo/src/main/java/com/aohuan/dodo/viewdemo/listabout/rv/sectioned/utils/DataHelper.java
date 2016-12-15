package com.aohuan.dodo.viewdemo.listabout.rv.sectioned.utils;

import android.content.Context;

import com.aohuan.dodo.viewdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo_lihao on 2016/12/15.
 * qq: 2390183798
 */
public class DataHelper {


    /**
     * 按首字母， 遍历容器，将容器内的字符串，放入其他容器中
     * @param letter
     * @return
     */
    public static List<String> getContactsWithLetter(Context context, char letter) {
        List<String> contacts = new ArrayList<>();

        for (String contact : context.getResources().getStringArray(R.array.names)) {
            if (contact.charAt(0) == letter) {
                contacts.add(contact);
            }
        }

        return contacts;
    }
}

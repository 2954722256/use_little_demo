package com.aohuan.dodo.viewdemo.listabout.rv.hy.adapter;

import android.content.Context;

import com.aohuan.dodo.viewdemo.listabout.listview.hy.bean.ChatMessage;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

/**
 * Created by dodo_lihao on 2016/11/24.
 * qq: 2390183798
 */
public class ChatAdapterForRv extends MultiItemTypeAdapter<ChatMessage>
{
    public ChatAdapterForRv(Context context, List<ChatMessage> datas)
    {
        super(context, datas);

        addItemViewDelegate(new MsgSendItemDelagate());
        addItemViewDelegate(new MsgComingItemDelagate());
    }
}

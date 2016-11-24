package com.aohuan.dodo.viewdemo.listabout.listview.hy.adapter;

import android.content.Context;

import com.aohuan.dodo.viewdemo.listabout.listview.hy.bean.ChatMessage;
import com.zhy.adapter.abslistview.MultiItemTypeAdapter;

import java.util.List;

/**
 * Created by zhy on 15/9/4.
 */
public class ChatAdapter extends MultiItemTypeAdapter<ChatMessage>
{
    public ChatAdapter(Context context, List<ChatMessage> datas)
    {
        super(context, datas);

        addItemViewDelegate(new MsgSendItemDelagate());
        addItemViewDelegate(new MsgComingItemDelagate());
    }

}

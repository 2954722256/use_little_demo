package com.aohuan.dodo.viewdemo.listabout.listview.adapter;

import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.listabout.listview.bean.ChatMessage;
import com.zhy.adapter.abslistview.ViewHolder;
import com.zhy.adapter.abslistview.base.ItemViewDelegate;

/**
 * Created by zhy on 16/6/22.
 */
public class MsgSendItemDelagate implements ItemViewDelegate<ChatMessage>
{

    @Override
    public int getItemViewLayoutId()
    {
        return R.layout.main_chat_send_msg;
    }

    @Override
    public boolean isForViewType(ChatMessage item, int position)
    {
        return !item.isComMeg();
    }

    @Override
    public void convert(ViewHolder holder, ChatMessage chatMessage, int position)
    {
        holder.setText(R.id.chat_send_content, chatMessage.getContent());
        holder.setText(R.id.chat_send_name, chatMessage.getName());
        holder.setImageResource(R.id.chat_send_icon, chatMessage.getIcon());
    }
}

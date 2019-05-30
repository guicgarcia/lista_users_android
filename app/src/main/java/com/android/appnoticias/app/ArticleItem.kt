package com.android.appnoticias.app

import com.android.appnoticias.R
import com.android.appnoticias.entities.User
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_article_item.view.*


class ArticleItem(val user: User) : Item<ViewHolder>() {

    override fun getLayout(): Int {
        return R.layout.activity_article_item
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.txtTitle.text = user.nome
        viewHolder.itemView.textDescription.text = user.email
    }
}

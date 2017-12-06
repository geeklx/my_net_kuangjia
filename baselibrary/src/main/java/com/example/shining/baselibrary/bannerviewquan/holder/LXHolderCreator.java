package com.example.shining.baselibrary.bannerviewquan.holder;

public interface LXHolderCreator<VH extends LXViewHolder> {
    /**
     * 创建ViewHolder
     *
     * @return
     */
    public VH createViewHolder();
}

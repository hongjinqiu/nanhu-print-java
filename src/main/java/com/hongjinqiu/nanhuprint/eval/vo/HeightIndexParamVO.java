package com.hongjinqiu.nanhuprint.eval.vo;

/**
 * 高度, 下标VO, 在计算分页的过程中会用到
 * @author hongjinqiu 2023.05.31
 */
public class HeightIndexParamVO {
    // tbody 当前加入页面的最后一行下标
    private Integer lastTbodyLineChildIndex;
    // 当前页面高度
    private float currentPageHeight;

    public HeightIndexParamVO(float currentPageHeight, Integer lastTbodyLineChildIndex) {
        this.lastTbodyLineChildIndex = lastTbodyLineChildIndex;
        this.currentPageHeight = currentPageHeight;
    }

    public Integer getLastTbodyLineChildIndex() {
        return lastTbodyLineChildIndex;
    }

    public void setLastTbodyLineChildIndex(Integer lastTbodyLineChildIndex) {
        this.lastTbodyLineChildIndex = lastTbodyLineChildIndex;
    }

    public float getCurrentPageHeight() {
        return currentPageHeight;
    }

    public void setCurrentPageHeight(float currentPageHeight) {
        this.currentPageHeight = currentPageHeight;
    }
}

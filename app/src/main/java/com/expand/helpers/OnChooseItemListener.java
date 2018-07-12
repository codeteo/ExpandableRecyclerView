package com.expand.helpers;

/**
 * Contract to notify Activity about changes on adapter's data state.
 */

public interface OnChooseItemListener {

    void onSelect(int position);

    void onDeselect(int position);
}

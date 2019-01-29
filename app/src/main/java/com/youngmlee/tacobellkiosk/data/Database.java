package com.youngmlee.tacobellkiosk.data;

import com.youngmlee.tacobellkiosk.data.model.Menu;

public interface Database {
    void getMenu(final Callback<Menu> menuCallback);
}

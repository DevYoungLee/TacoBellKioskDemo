package com.youngmlee.tacobellkiosk.data;

import com.youngmlee.tacobellkiosk.data.model.Menu;

public interface Repository {
    void getMenu(final Callback<Menu> callback);
}

package com.toshiba.assetmgmtapp.util;


public class UserContextHolder {
    private static final ThreadLocal<UserContext> userContext = new ThreadLocal<>();

    public static final UserContext getContext(){
        UserContext context = userContext.get();

        if (context == null) {
            context = new UserContext();
            userContext.set(context);

        }
        return userContext.get();
    }

    public static final void setContext(UserContext context) {
        userContext.set(context);
    }


}

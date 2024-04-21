package com.tkp.light.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class applicationContextUtil implements ApplicationContextAware {
    static ApplicationContext applicationContexts;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContexts=applicationContext;

    }

    public  Object getlogin_server(String name){

       Object server = applicationContexts.getBean(name);

        return server;
    }
}

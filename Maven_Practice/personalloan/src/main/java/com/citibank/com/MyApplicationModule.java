package com.citibank.com;

import static net.contextfw.web.application.configuration.Configuration.*;
import net.contextfw.web.application.WebApplicationModule;
import net.contextfw.web.application.configuration.Configuration;

import com.google.inject.AbstractModule;
import com.mycila.inject.jsr250.Jsr250;

public class MyApplicationModule extends AbstractModule {

    @Override
    protected void configure() {

        Configuration conf = Configuration.getDefaults()
          .add(RESOURCE_PATH, "com.citibank.com")
          .add(VIEW_COMPONENT_ROOT_PACKAGE, "com.citibank.com.views")
          .set(DEVELOPMENT_MODE, true)
          .set(XML_PARAM_NAME, "xml")
          .set(LOG_XML, true);
       
        install(new WebApplicationModule(conf));
        install(Jsr250.newJsr250Module());
    }
}
package com.pavel.patterns.services.dependency.injection.container.dicontainer.config;

import java.util.Map;

public interface Configuration {
    public String getPackageToScan();
    public Map<Class, Class> getInterfaceToImplementations();
}

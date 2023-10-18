package com.practical.details.service.iface;

public interface BaseEntityIface {
    void preInsert();
    void preUpdate();
    void preDelete();
    void postUpdate();
    void postDelete();
}

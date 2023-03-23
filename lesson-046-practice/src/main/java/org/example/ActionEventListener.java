package org.example;

import org.example.model.Notification;

import java.awt.event.ActionListener;

public interface ActionEventListener extends ActionListener {
    void notify(Notification notification);
}

package com.example.mypreloaddata.Service;

public interface HandlerCallback {
    void preparation();
    void updateProgress(long progress);
    void loadSuccess();
    void loadFailed();
    void loadCancel();
}

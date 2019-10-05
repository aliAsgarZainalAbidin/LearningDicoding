package com.example.myunittesting;

public class MainPresenter {
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public double volume(double lenght, double width, double height){
        return lenght * width * height;
    }

    public void calculateVolume(double length, double width, double height){
        double volume =  volume(length,width,height);
        MainModel model = new MainModel(volume);
        view.showVolume(model);
    }
}

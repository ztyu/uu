package model.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeChatServer implements Observable {

    private List<Observer> observers;
    private String message;

    WeChatServer() {
        observers = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }


    @Override
    public void removeObserver(Observer observable) {
        observers.remove(observable);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }


}

package com.gdg.bhopal.covid19trackerapp;

public class Usrdata {
    String state;
    String conferm,recover,death,active;


    public Usrdata(String state, String conferm, String recover,String death, String active) {
        this.state = state;
        this.conferm = conferm;
        this.death=death;
        this.recover=recover;
        this.active = active;
    }

    public Usrdata() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getConferm() {
        return conferm;
    }

    public void setConferm(String conferm) {
        this.conferm = conferm;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRecover() {
        return recover;
    }

    public void setRecover(String recover) {
        this.recover = recover;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }
}

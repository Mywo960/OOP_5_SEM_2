package com.example.oop_5_sem_2;

public class Laptop {
    private int id;
    private String fabrick;
    private String model;
    private String cpu;
    private int ram;
    private int hdd;


    public Laptop(int id, String fabrick, String model, String cpu, int ram, int hdd) {
        this.fabrick = fabrick;
        this.model = model;
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFabrick() {
        return fabrick;
    }

    public void setFabrick(String fabrick) {
        this.fabrick = fabrick;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }
}

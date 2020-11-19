package com.example.proyectoidnp.view.entrenamiento.Entidades;

public class Entrenamiento {
    private Integer EntId;
    private Integer EntUsuId;
    private Integer EntRecId;
    private String EntTip;
    private int EntDur;

    public Entrenamiento(Integer entId, Integer entUsuId, Integer entRecId, String entTip, int entDur) {
        EntId = entId;
        EntUsuId = entUsuId;
        EntRecId = entRecId;
        EntTip = entTip;
        EntDur = entDur;
    }

    public Integer getEntid() {
        return EntId;
    }

    public void setEntid(Integer entid) {
        EntId = entid;
    }

    public Integer getEntUsuId() {
        return EntUsuId;
    }

    public void setEntUsuId(Integer entUsuId) {
        EntUsuId = entUsuId;
    }

    public Integer getEntRecId() {
        return EntRecId;
    }

    public void setEntRecId(Integer entRecId) {
        EntRecId = entRecId;
    }

    public String getEntTip() {
        return EntTip;
    }

    public void setEntTip(String entTip) {
        EntTip = entTip;
    }

    public int getEntDur() {
        return EntDur;
    }

    public void setEntDur(int entDur) {
        EntDur = entDur;
    }
}

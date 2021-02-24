package com.qualidade.qapp.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cqm_table")
public class Cqm {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String maquina;
    private String data;
    private String hora;
    private String rd1_1;
    private String rd1_2;
    private String rd2_1;
    private String rd2_2;
    private String rd3_1;
    private String rd3_2;
    private String rd4_1;
    private String rd4_2;
    private String rd5_1;
    private String rd5_2;
    private String rd6_1;
    private String rd6_2;
    private String cham1_1;
    private String cham1_2;
    private String cham2_1;
    private String cham2_2;
    private String cham3_1;
    private String cham3_2;

    public void setCham4_1(String cham4_1) {
        this.cham4_1 = cham4_1;
    }

    private String cham4_1;

    public void setCham4_2(String cham4_2) {
        this.cham4_2 = cham4_2;
    }

    public void setCham5_1(String cham5_1) {
        this.cham5_1 = cham5_1;
    }

    public void setCham5_2(String cham5_2) {
        this.cham5_2 = cham5_2;
    }

    public void setCham6_1(String cham6_1) {
        this.cham6_1 = cham6_1;
    }

    public void setCham6_2(String cham6_2) {
        this.cham6_2 = cham6_2;
    }

    private String cham4_2;
    private String cham5_1;
    private String cham5_2;
    private String cham6_1;
    private String cham6_2;
    private String obs1;
    private String obs2;
    private String obs3;
    private String area1_p1;

    public void setId(int id) {
        this.id = id;
    }

    public String getRd1_1() {
        return rd1_1;
    }

    public String getRd1_2() {
        return rd1_2;
    }

    public String getRd2_1() {
        return rd2_1;
    }

    public String getRd2_2() {
        return rd2_2;
    }

    public String getRd3_1() {
        return rd3_1;
    }

    public String getRd3_2() {
        return rd3_2;
    }

    public String getRd4_1() {
        return rd4_1;
    }

    public String getRd4_2() {
        return rd4_2;
    }

    public String getRd5_1() {
        return rd5_1;
    }

    public String getRd5_2() {
        return rd5_2;
    }

    public String getRd6_1() {
        return rd6_1;
    }

    public String getRd6_2() {
        return rd6_2;
    }

    public String getCham1_1() {
        return cham1_1;
    }

    public String getCham1_2() {
        return cham1_2;
    }

    public String getCham2_1() {
        return cham2_1;
    }

    public String getCham2_2() {
        return cham2_2;
    }

    public String getCham3_1() {
        return cham3_1;
    }

    public String getCham3_2() {
        return cham3_2;
    }

    public String getCham4_1() {
        return cham4_1;
    }

    public String getCham4_2() {
        return cham4_2;
    }

    public String getCham5_1() {
        return cham5_1;
    }

    public String getCham5_2() {
        return cham5_2;
    }

    public String getCham6_1() {
        return cham6_1;
    }

    public String getCham6_2() {
        return cham6_2;
    }

    public String getObs1() {
        return obs1;
    }

    public String getObs2() {
        return obs2;
    }

    public String getObs3() {
        return obs3;
    }

    public String getArea1_p1() {
        return area1_p1;
    }

    public String getArea1_p2() {
        return area1_p2;
    }

    public String getArea1_p3() {
        return area1_p3;
    }

    public String getArea2_s4_p1() {
        return area2_s4_p1;
    }

    public String getArea2_s4_p2() {
        return area2_s4_p2;
    }

    public String getArea2_s4_p3() {
        return area2_s4_p3;
    }

    public String getArea2_s3_p1() {
        return area2_s3_p1;
    }

    public String getArea2_s3_p2() {
        return area2_s3_p2;
    }

    public String getArea2_s3_p3() {
        return area2_s3_p3;
    }

    public String getArea2_s2_p1() {
        return area2_s2_p1;
    }

    public String getArea2_s2_p2() {
        return area2_s2_p2;
    }

    public String getArea2_s2_p3() {
        return area2_s2_p3;
    }

    public String getArea2_s1_p1() {
        return area2_s1_p1;
    }

    public String getArea2_s1_p2() {
        return area2_s1_p2;
    }

    public String getArea2_s1_p3() {
        return area2_s1_p3;
    }

    private String area1_p2;
    private String area1_p3;
    private String area2_s4_p1;
    private String area2_s4_p2;
    private String area2_s4_p3;
    private String area2_s3_p1;
    private String area2_s3_p2;
    private String area2_s3_p3;
    private String area2_s2_p1;
    private String area2_s2_p2;
    private String area2_s2_p3;
    private String area2_s1_p1;
    private String area2_s1_p2;
    private String area2_s1_p3;

    public Cqm(String maquina, String data, String hora, String rd1_1, String rd1_2, String rd2_1,
               String rd2_2, String rd3_1, String rd3_2, String rd4_1, String rd4_2,
               String rd5_1, String rd5_2, String rd6_1, String rd6_2, String cham1_1, String cham1_2,
               String cham2_1, String cham2_2, String cham3_1, String cham3_2, String obs1, String obs2, String obs3,
               String area1_p1, String area1_p2, String area1_p3, String area2_s4_p1, String area2_s4_p2, String area2_s4_p3, String area2_s3_p1,
               String area2_s3_p2, String area2_s3_p3, String area2_s2_p1, String area2_s2_p2, String area2_s2_p3, String area2_s1_p1,
               String area2_s1_p2, String area2_s1_p3) {
        this.data = data;
        this.hora = hora;
        this.maquina = maquina;
        this.rd1_1 = rd1_1;
        this.rd1_2 = rd1_2; this.rd2_1 = rd2_1;
        this.rd2_2 = rd2_2; this.rd3_1 = rd3_1;
        this.rd3_2 = rd3_2; this.rd4_1 = rd4_1;
        this.rd4_2 = rd4_2; this.rd5_1 = rd5_1;
        this.rd5_2 = rd5_2; this.rd6_1 = rd6_1;
        this.rd6_2 = rd6_2; this.cham1_1 = cham1_1;
        this.cham1_2 = cham1_2; this.cham2_1 = cham2_1;
        this.cham2_2 = cham2_2; this.cham3_1 = cham3_1;
        this.cham3_2 = cham3_2; this.obs1 = obs1;
                this.obs2 = obs2; this.obs3 = obs3;
                this.area1_p1 = area1_p1; this.area1_p2 = area1_p2;
                this.area1_p3 = area1_p3; this.area2_s4_p1 = area2_s4_p1;
                this.area2_s4_p2 = area2_s4_p2; this.area2_s4_p3 = area2_s4_p3;
                this.area2_s3_p1 = area2_s3_p1; this.area2_s3_p2 = area2_s3_p2;
                this.area2_s3_p3 = area2_s3_p3; this.area2_s2_p1 = area2_s2_p1;
                this.area2_s2_p2 = area2_s2_p2; this.area2_s2_p3 = area2_s2_p3;
                this.area2_s1_p1 = area2_s1_p1; this.area2_s1_p2 = area2_s1_p2;
    this.area2_s1_p3 = area2_s1_p3;
    }

    public int getId() { return id; }
    public String getMaquina() { return maquina; }
    public String getData() { return data; }
    public String getHora() { return hora; }

}

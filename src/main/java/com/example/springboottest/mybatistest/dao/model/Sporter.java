package com.example.springboottest.mybatistest.dao.model;

import java.io.Serializable;

public class Sporter implements Serializable {
    private Integer id;

    private String xingming;

    private String danwei;

    private String chengzhongjibie;

    private String yundongyuanhao;

    private Integer qianhao;

    private String xingbie;

    private String zubie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXingming() {
        return xingming;
    }

    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei == null ? null : danwei.trim();
    }

    public String getChengzhongjibie() {
        return chengzhongjibie;
    }

    public void setChengzhongjibie(String chengzhongjibie) {
        this.chengzhongjibie = chengzhongjibie == null ? null : chengzhongjibie.trim();
    }

    public String getYundongyuanhao() {
        return yundongyuanhao;
    }

    public void setYundongyuanhao(String yundongyuanhao) {
        this.yundongyuanhao = yundongyuanhao == null ? null : yundongyuanhao.trim();
    }

    public Integer getQianhao() {
        return qianhao;
    }

    public void setQianhao(Integer qianhao) {
        this.qianhao = qianhao;
    }

    public String getXingbie() {
        return xingbie;
    }

    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? null : xingbie.trim();
    }

    public String getZubie() {
        return zubie;
    }

    public void setZubie(String zubie) {
        this.zubie = zubie == null ? null : zubie.trim();
    }
}
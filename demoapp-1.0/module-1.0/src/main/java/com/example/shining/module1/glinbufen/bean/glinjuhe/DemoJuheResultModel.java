package com.example.shining.module1.glinbufen.bean.glinjuhe;

import com.example.shining.module1.glinbufen.bean.glinnet.DataDemoModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by shining on 2017/2/10 0010.
 */

public class DemoJuheResultModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String stat;
    private List<DataDemoModel> data;

    public DemoJuheResultModel() {
    }

    public DemoJuheResultModel(String stat, List<DataDemoModel> data) {
        this.stat = stat;
        this.data = data;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<DataDemoModel> getData() {
        return data;
    }

    public void setData(List<DataDemoModel> data) {
        this.data = data;
    }
}

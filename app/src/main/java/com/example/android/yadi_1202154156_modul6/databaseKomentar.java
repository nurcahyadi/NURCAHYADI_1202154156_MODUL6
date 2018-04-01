package com.example.android.yadi_1202154156_modul6;

import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class databaseKomentar {
    String sikomen, komen, fotokomen;

    public databaseKomentar(){

    }
    public databaseKomentar(String sikomen, String komen, String fotokomen){
        this.sikomen = sikomen;
        this.komen = komen;
        this.fotokomen = fotokomen;
    }

    public String getSikomen() {
        return sikomen;
    }

    public String getKomen() {
        return komen;
    }

    public String getFotokomen() {
        return fotokomen;
    }
}

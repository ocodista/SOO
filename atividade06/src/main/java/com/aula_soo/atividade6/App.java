package com.aula_soo.atividade6;

import com.aula_soo.atividade6.utils.migrations.FaturaMigration;

public class App {
    public static void main(String[] args) {
        FaturaMigration faturaMigration = new FaturaMigration();
        faturaMigration.createTable();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.utils;

import db.bean.Attribute;

/**
 *
 * @author Maroine
 */
public class RealDataFaker extends DataFaker {

    public RealDataFaker(Attribute att) {
        super(att);
    }

    /*
    @Override
    protected void generateUniqueValues() {
        int rest = getRest();
        double from = Double.parseDouble(this.from);
        double to = Double.parseDouble(this.to);
        double gap = (to - from) / howMuch;
        double j = from;
        for (int i = 0; i < rest; i++) {
            String value = "" + j;
            attribute.getInstances().add(value);
            double a = 0;
            do {
                a = betweenReal(0, gap);
            } while (a != 0);
            j += a;
        }
    }
     */
    @Override
    public String generateValue() {
        return betweenReal() + "";
    }
}

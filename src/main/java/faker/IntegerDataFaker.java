/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faker;

import beans.Attribute;
import beans.SQLSchema;

/**
 * Generate values for Digital type.
 *
 * @author Maroine
 */
public class IntegerDataFaker extends DataFaker {

    public IntegerDataFaker(Attribute attribute) {
        super(attribute);
    }

    /**
     * Generate unique values of digital numbers
     */
    @Override
    protected void generateUniqueValues() {
        if (SQLSchema.getInstance().isPreData()) {
            super.generateUniqueValues();
        } else {
            int from = Integer.parseInt(this.from);
            int to = Integer.parseInt(this.to);
            int gap = (to - from) / attribute.getTable().getHowMuch();
            gap++;
            int j = from;
            int a = 0;
            for (int i = 0; i < attribute.getTable().getHowMuch(); i++) {
                attribute.getInstances().add(j + "");
                a = between(1, gap);
                j += a;
            }
        }
    }

    /**
     * generate digital value
     *
     * @return
     */
    @Override
    protected String generateNewValue() {
        return between() + "";
    }

}

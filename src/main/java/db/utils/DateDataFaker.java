/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.utils;

import com.github.javafaker.Faker;
import db.bean.Attribute;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Maroine
 */
public class DateDataFaker extends DataFaker implements Serializable {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

    public DateDataFaker(Attribute att) {
        super(att);
        this.from = "01-01-2015";
        this.to = "01-01-2018";
    }

    @Override
    public String generateValue(Faker faker) {
        Date date = null;
        try {
            date = faker.date().between(dateFormat.parse(from), dateFormat.parse(to));
        } catch (ParseException ex) {
            return null;
        }
        return "'" + dateFormat.format(date) + "'";
    }

}

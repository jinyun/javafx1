package com.guojinyun.javafx.model.lesson16;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author guojinyun
 * @date 19-11-20
 */
public class PersonData {
    public SimpleStringProperty mNameProperty = new SimpleStringProperty();
    public SimpleStringProperty mAddrProperty = new SimpleStringProperty();
    public SimpleStringProperty mPhone1Property = new SimpleStringProperty();
    public SimpleStringProperty mPhone2Property = new SimpleStringProperty();
    public SimpleDoubleProperty mProgressProperty = new SimpleDoubleProperty();

    public PersonData(String name, String address, String phone1, String phone2){
        mNameProperty.set(name);
        mAddrProperty.set(address);
        mPhone1Property.set(phone1);
        mPhone2Property.set(phone2);
    }

    public String getmNameProperty() {
        return mNameProperty.get();
    }

    public SimpleStringProperty mNamePropertyProperty() {
        return mNameProperty;
    }

    public void setmNameProperty(String mNameProperty) {
        this.mNameProperty.set(mNameProperty);
    }

    public String getmAddrProperty() {
        return mAddrProperty.get();
    }

    public SimpleStringProperty mAddrPropertyProperty() {
        return mAddrProperty;
    }

    public void setmAddrProperty(String mAddrProperty) {
        this.mAddrProperty.set(mAddrProperty);
    }

    public String getmPhone1Property() {
        return mPhone1Property.get();
    }

    public SimpleStringProperty mPhone1PropertyProperty() {
        return mPhone1Property;
    }

    public void setmPhone1Property(String mPhone1Property) {
        this.mPhone1Property.set(mPhone1Property);
    }

    public String getmPhone2Property() {
        return mPhone2Property.get();
    }

    public SimpleStringProperty mPhone2PropertyProperty() {
        return mPhone2Property;
    }

    public void setmPhone2Property(String mPhone2Property) {
        this.mPhone2Property.set(mPhone2Property);
    }

    public double getmProgressProperty() {
        return mProgressProperty.get();
    }

    public SimpleDoubleProperty mProgressPropertyProperty() {
        return mProgressProperty;
    }

    public void setmProgressProperty(double mProgressProperty) {
        this.mProgressProperty.set(mProgressProperty);
    }
}

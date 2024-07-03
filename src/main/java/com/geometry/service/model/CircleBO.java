package com.geometry.service.model;

import com.geometry.common.enums.ShapeType;

import java.math.BigDecimal;

import static com.geometry.common.enums.ShapeType.CIRCLE;

public class CircleBO extends OvalBO {

    public static final BigDecimal PI = new BigDecimal("3.14"); //I know that java has Math.PI, but test result is very complicated to check every time

    private BigDecimal radius;

    public CircleBO() {
    }

    public CircleBO(BigDecimal radius) {
        this.radius = radius;
    }

    @Override
    public ShapeType getShapeType() {
        return CIRCLE;
    }

    public BigDecimal getCircumference() {
        return radius.multiply(PI).multiply(BigDecimal.valueOf(2));
    }

    @Override
    public BigDecimal getArea() {
        return radius.pow(2).multiply(PI);
    }

    public BigDecimal getRadius() {
        return radius;
    }

    public void setRadius(BigDecimal radius) {
        this.radius = radius;
    }
}

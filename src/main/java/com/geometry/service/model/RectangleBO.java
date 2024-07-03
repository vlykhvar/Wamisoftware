package com.geometry.service.model;

import com.geometry.common.enums.ShapeType;

import java.math.BigDecimal;

import static com.geometry.common.enums.ShapeType.RECTANGLE;

public class RectangleBO extends PolygonBO {

    private BigDecimal length;
    private BigDecimal width;

    public RectangleBO() {
    }

    public RectangleBO(BigDecimal length, BigDecimal width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public ShapeType getShapeType() {
        return RECTANGLE;
    }

    @Override
    public BigDecimal getPerimeter() {
        return width.add(length).multiply(BigDecimal.valueOf(2));
    }

    @Override
    public BigDecimal getArea() {
        return length.multiply(width);
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }
}

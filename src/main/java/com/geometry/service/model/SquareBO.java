package com.geometry.service.model;

import com.geometry.common.enums.ShapeType;

import java.math.BigDecimal;

import static com.geometry.common.enums.ShapeType.SQUARE;

public class SquareBO extends PolygonBO {

    private BigDecimal side;

    public SquareBO() {
    }

    public SquareBO(BigDecimal side) {
        this.side = side;
    }

    @Override
    public ShapeType getShapeType() {
        return SQUARE;
    }

    @Override
    public BigDecimal getPerimeter() {
        return side.multiply(BigDecimal.valueOf(4));
    }

    @Override
    public BigDecimal getArea() {
        return side.pow(2);
    }

    public BigDecimal getSide() {
        return side;
    }

    public void setSide(BigDecimal side) {
        this.side = side;
    }
}

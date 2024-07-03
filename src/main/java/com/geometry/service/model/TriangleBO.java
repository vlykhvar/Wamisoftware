package com.geometry.service.model;

import com.geometry.common.enums.ShapeType;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static com.geometry.common.enums.ShapeType.TRIANGLE;

public class TriangleBO extends PolygonBO {

    private BigDecimal sideC;
    private BigDecimal sideA;
    private BigDecimal sideB;

    public TriangleBO() {
    }

    public TriangleBO(BigDecimal sideC, BigDecimal sideA, BigDecimal sideB) {
        this.sideC = sideC;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public ShapeType getShapeType() {
        return TRIANGLE;
    }

    @Override
    public BigDecimal getPerimeter() {
        return sideC.add(sideA).add(sideB);
    }

    @Override
    public BigDecimal getArea() {
        var mc = new MathContext(10, RoundingMode.HALF_UP);
        var semiPerimeter = getPerimeter().divide(BigDecimal.valueOf(2), mc);
        return semiPerimeter.multiply(semiPerimeter.subtract(sideA), mc)
                .multiply(semiPerimeter.subtract(sideB), mc)
                .multiply(semiPerimeter.subtract(sideC), mc)
                .sqrt(mc);
    }

    public BigDecimal getSideC() {
        return sideC;
    }

    public void setSideC(BigDecimal sideC) {
        this.sideC = sideC;
    }

    public BigDecimal getSideA() {
        return sideA;
    }

    public void setSideA(BigDecimal sideA) {
        this.sideA = sideA;
    }

    public BigDecimal getSideB() {
        return sideB;
    }

    public void setSideB(BigDecimal sideB) {
        this.sideB = sideB;
    }
}

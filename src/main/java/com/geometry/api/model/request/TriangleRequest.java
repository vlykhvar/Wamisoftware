package com.geometry.api.model.request;

import com.geometry.common.enums.ShapeType;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

import static com.geometry.common.enums.ShapeType.TRIANGLE;

public class TriangleRequest extends ShapeRequest {

    @NotNull
    @Positive
    private BigDecimal sideA;

    @NotNull
    @Positive
    private BigDecimal sideB;

    @NotNull
    @Positive
    private BigDecimal sideC;

    @Override
    public ShapeType getShapeType() {
        return TRIANGLE;
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

    public BigDecimal getSideC() {
        return sideC;
    }

    public void setSideC(BigDecimal sideC) {
        this.sideC = sideC;
    }

    @AssertTrue(message = "These sides can form a triangle.")
    public boolean isFormTriangle() {
        return (sideA.add(sideB).compareTo(sideC) > 0) &&
                (sideA.add(sideC).compareTo(sideB) > 0) &&
                (sideB.add(sideC).compareTo(sideA) > 0);
    }
}

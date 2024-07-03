package com.geometry.api.model.request;

import com.geometry.common.enums.ShapeType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class CircleRequest extends ShapeRequest {

    @NotNull
    @Positive
    private BigDecimal radius;

    @Override
    public ShapeType getShapeType() {
        return ShapeType.CIRCLE;
    }

    public BigDecimal getRadius() {
        return radius;
    }

    public void setRadius(BigDecimal radius) {
        this.radius = radius;
    }
}

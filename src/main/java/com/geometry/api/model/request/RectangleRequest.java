package com.geometry.api.model.request;

import com.geometry.common.enums.ShapeType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

import static com.geometry.common.enums.ShapeType.RECTANGLE;

public class RectangleRequest extends ShapeRequest {

    @NotNull
    @Positive
    private BigDecimal length;

    @NotNull
    @Positive
    private BigDecimal width;

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

    @Override
    public ShapeType getShapeType() {
        return RECTANGLE;
    }
}

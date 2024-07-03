package com.geometry.api.model.request;

import com.geometry.common.enums.ShapeType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

import static com.geometry.common.enums.ShapeType.SQUARE;

public class SquareRequest extends ShapeRequest {

    @NotNull
    @Positive
    private BigDecimal side;

    public BigDecimal getSide() {
        return side;
    }

    public void setSide(BigDecimal side) {
        this.side = side;
    }

    @Override
    public ShapeType getShapeType() {
        return SQUARE;
    }
}

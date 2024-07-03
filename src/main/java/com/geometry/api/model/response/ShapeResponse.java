package com.geometry.api.model.response;

import com.geometry.service.model.ShapeBO;

import java.math.BigDecimal;

/**
 * Response body for shape area and perimeter.
 *
 * @author Volodymy Lykhvar
 */
public abstract class ShapeResponse {

    private BigDecimal area;

    public ShapeResponse(ShapeBO shapeBO) {
        this.area = shapeBO.getArea();
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }
}

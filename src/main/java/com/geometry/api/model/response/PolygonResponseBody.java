package com.geometry.api.model.response;

import com.geometry.service.model.PolygonBO;

import java.math.BigDecimal;

public class PolygonResponseBody extends ShapeResponse {

    private BigDecimal perimeter;

    public PolygonResponseBody(PolygonBO polygonBO) {
        super(polygonBO);
        this.perimeter = polygonBO.getPerimeter();
    }

    public BigDecimal getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(BigDecimal perimeter) {
        this.perimeter = perimeter;
    }
}

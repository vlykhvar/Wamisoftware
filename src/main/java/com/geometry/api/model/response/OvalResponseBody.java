package com.geometry.api.model.response;

import com.geometry.service.model.OvalBO;

import java.math.BigDecimal;

public class OvalResponseBody extends ShapeResponse {

    private BigDecimal circumference;

    public OvalResponseBody(OvalBO ovalBO) {
        super(ovalBO);
        this.circumference = ovalBO.getCircumference();
    }

    public BigDecimal getCircumference() {
        return circumference;
    }

    public void setCircumference(BigDecimal circumference) {
        this.circumference = circumference;
    }
}

package com.geometry.api.converter.impl;

import com.geometry.api.converter.ShapeConverter;
import com.geometry.api.model.response.OvalResponseBody;
import com.geometry.api.model.response.ShapeResponse;
import com.geometry.common.enums.ObjectType;
import com.geometry.service.model.OvalBO;
import com.geometry.service.model.ShapeBO;
import org.springframework.stereotype.Component;

import static com.geometry.common.enums.ObjectType.OVAL;

@Component
public class OvalConverter implements ShapeConverter {

    @Override
    public ObjectType getType() {
        return OVAL;
    }

    @Override
    public ShapeResponse toShapeResponse(ShapeBO shapeBO) {
        var ovalBO = (OvalBO) shapeBO;
        return new OvalResponseBody(ovalBO);
    }
}

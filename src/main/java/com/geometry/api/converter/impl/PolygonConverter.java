package com.geometry.api.converter.impl;

import com.geometry.api.converter.ShapeConverter;
import com.geometry.api.model.response.PolygonResponseBody;
import com.geometry.api.model.response.ShapeResponse;
import com.geometry.common.enums.ObjectType;
import com.geometry.service.model.PolygonBO;
import com.geometry.service.model.ShapeBO;
import org.springframework.stereotype.Component;

import static com.geometry.common.enums.ObjectType.POLYGON;

@Component
public class PolygonConverter implements ShapeConverter {

    @Override
    public ObjectType getType() {
        return POLYGON;
    }

    @Override
    public ShapeResponse toShapeResponse(ShapeBO shapeBO) {
        var polygon = (PolygonBO) shapeBO;
        return new PolygonResponseBody(polygon);
    }
}

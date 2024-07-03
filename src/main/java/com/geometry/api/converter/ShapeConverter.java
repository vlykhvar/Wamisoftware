package com.geometry.api.converter;

import com.geometry.api.model.response.ShapeResponse;
import com.geometry.common.enums.ObjectType;
import com.geometry.service.model.ShapeBO;

public interface ShapeConverter {

    /**
     * Get type for what object is converter.
     *
     * @return {@link ObjectType}
     */
    ObjectType getType();

    /**
     * Convert business object to response object.
     *
     * @param shapeBO {@link ShapeBO}
     * @return {@link ShapeResponse}
     */
    ShapeResponse toShapeResponse(ShapeBO shapeBO);
}

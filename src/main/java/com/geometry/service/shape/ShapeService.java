package com.geometry.service.shape;

import com.geometry.api.model.request.ShapeRequest;
import com.geometry.common.enums.ShapeType;
import com.geometry.service.model.ShapeBO;

/**
 * Shape Service.
 *
 * @author Volodymyr Lykhvar
 */
public interface ShapeService {

    /**
     * Returns the type of figure that the service serves.
     *
     * @return {@link ShapeType} enum
     */
    ShapeType getType();

    /**
     * Convert abstract {@link ShapeRequest} according to shape.
     *
     * @param shapeRequest - {@link ShapeRequest}
     * @return {@link ShapeRequest}
     */
    ShapeBO convertToShapeBO(ShapeRequest shapeRequest);
}

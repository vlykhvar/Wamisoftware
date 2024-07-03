package com.geometry.service.shape.mangament;

import com.geometry.api.model.request.ShapeRequest;
import com.geometry.service.model.ShapeBO;

/**
 * Management service interface for different shapes.
 *
 * @author Volodymyr Lykhvar
 */
public interface ShapeManagementService {

    /**
     * Convert abstract {@link ShapeRequest} class to abstract {@link ShapeBO} class.
     *
     * @param shapeRequest - {@link ShapeRequest}
     * @return {@link ShapeBO}
     */
    ShapeBO convertToShapeBO(ShapeRequest shapeRequest);
}

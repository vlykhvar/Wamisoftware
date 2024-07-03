package com.geometry.service.shape.impl;

import com.geometry.api.model.request.RectangleRequest;
import com.geometry.api.model.request.ShapeRequest;
import com.geometry.common.enums.ShapeType;
import com.geometry.service.model.RectangleBO;
import com.geometry.service.model.ShapeBO;
import com.geometry.service.shape.ShapeService;
import org.springframework.stereotype.Service;

import static com.geometry.common.enums.ShapeType.RECTANGLE;

@Service
public class RectangleServiceImpl implements ShapeService {

    @Override
    public ShapeType getType() {
        return RECTANGLE;
    }

    @Override
    public ShapeBO convertToShapeBO(ShapeRequest shapeRequest) {
        var rectangleRequest = (RectangleRequest) shapeRequest;
        return new RectangleBO(rectangleRequest.getLength(), rectangleRequest.getWidth());
    }
}

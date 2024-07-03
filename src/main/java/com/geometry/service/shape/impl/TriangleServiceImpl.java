package com.geometry.service.shape.impl;

import com.geometry.api.model.request.ShapeRequest;
import com.geometry.api.model.request.TriangleRequest;
import com.geometry.common.enums.ShapeType;
import com.geometry.service.model.ShapeBO;
import com.geometry.service.model.TriangleBO;
import com.geometry.service.shape.ShapeService;
import org.springframework.stereotype.Service;

import static com.geometry.common.enums.ShapeType.TRIANGLE;

@Service
public class TriangleServiceImpl implements ShapeService {

    @Override
    public ShapeType getType() {
        return TRIANGLE;
    }

    @Override
    public ShapeBO convertToShapeBO(ShapeRequest shapeRequest) {
        var triangleRequest = (TriangleRequest) shapeRequest;
        return new TriangleBO(triangleRequest.getSideC(), triangleRequest.getSideA(), triangleRequest.getSideB());
    }
}

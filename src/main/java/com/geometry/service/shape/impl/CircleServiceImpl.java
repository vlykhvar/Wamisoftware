package com.geometry.service.shape.impl;

import com.geometry.api.model.request.CircleRequest;
import com.geometry.api.model.request.ShapeRequest;
import com.geometry.common.enums.ShapeType;
import com.geometry.service.model.CircleBO;
import com.geometry.service.model.ShapeBO;
import com.geometry.service.shape.ShapeService;
import org.springframework.stereotype.Service;

import static com.geometry.common.enums.ShapeType.CIRCLE;

@Service
public class CircleServiceImpl implements ShapeService {

    @Override
    public ShapeType getType() {
        return CIRCLE;
    }

    @Override
    public ShapeBO convertToShapeBO(ShapeRequest shapeRequest) {
        var circleRequest = (CircleRequest) shapeRequest;
        return new CircleBO(circleRequest.getRadius());
    }
}

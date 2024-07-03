package com.geometry.service.shape.impl;

import com.geometry.api.model.request.ShapeRequest;
import com.geometry.api.model.request.SquareRequest;
import com.geometry.common.enums.ShapeType;
import com.geometry.service.model.ShapeBO;
import com.geometry.service.model.SquareBO;
import com.geometry.service.shape.ShapeService;
import org.springframework.stereotype.Service;

import static com.geometry.common.enums.ShapeType.SQUARE;

@Service
public class SquareServiceImpl implements ShapeService {

    @Override
    public ShapeType getType() {
        return SQUARE;
    }

    @Override
    public ShapeBO convertToShapeBO(ShapeRequest shapeRequest) {
        var squareRequest = (SquareRequest) shapeRequest;
        return new SquareBO(squareRequest.getSide());
    }
}

package com.geometry.api.model.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.geometry.common.enums.ShapeType;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "shapeType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CircleRequest.class, name = "CIRCLE"),
        @JsonSubTypes.Type(value = RectangleRequest.class, name = "RECTANGLE"),
        @JsonSubTypes.Type(value = SquareRequest.class, name = "SQUARE"),
        @JsonSubTypes.Type(value = TriangleRequest.class, name = "TRIANGLE"),
})
public abstract class ShapeRequest {

    private ShapeType shapeType;

    public abstract ShapeType getShapeType();
}

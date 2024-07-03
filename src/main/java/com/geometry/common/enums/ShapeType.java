package com.geometry.common.enums;

import static com.geometry.common.enums.ObjectType.OVAL;
import static com.geometry.common.enums.ObjectType.POLYGON;

/**
 * Available shapes for calculation.
 *
 * @author Volodymyr Lykhvar
 */
public enum ShapeType {

    SQUARE(POLYGON),
    RECTANGLE(POLYGON),
    TRIANGLE(POLYGON),
    CIRCLE(OVAL);

    private final ObjectType objectType;

    ShapeType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public ObjectType getObjectType() {
        return objectType;
    }
}

package com.geometry.service.model;

import com.geometry.common.enums.ObjectType;

import java.math.BigDecimal;

import static com.geometry.common.enums.ObjectType.POLYGON;

/**
 * Abstract class business class for polygon type shapes.
 *
 * @author Volodymyr Lykhvar
 */
public abstract class PolygonBO extends ShapeBO {

    public abstract BigDecimal getPerimeter();

    @Override
    public ObjectType getObjectType() {
        return POLYGON;
    }
}

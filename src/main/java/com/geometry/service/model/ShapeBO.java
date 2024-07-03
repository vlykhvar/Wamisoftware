package com.geometry.service.model;

import com.geometry.common.enums.ObjectType;
import com.geometry.common.enums.ShapeType;

import java.math.BigDecimal;

/**
 * Abstract class business class for shapes.
 *
 * @author Volodymyr Lykhvar
 */
public abstract class ShapeBO {

    public abstract ShapeType getShapeType();

    public abstract ObjectType getObjectType();

    public abstract BigDecimal getArea();
}

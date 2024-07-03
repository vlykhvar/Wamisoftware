package com.geometry.service.model;

import com.geometry.common.enums.ObjectType;

import java.math.BigDecimal;

import static com.geometry.common.enums.ObjectType.OVAL;

/**
 * Abstract class business class for oval type shapes.
 *
 * @author Volodymyr Lykhvar
 */
public abstract class OvalBO extends ShapeBO {

    public abstract BigDecimal getCircumference();

    @Override
    public ObjectType getObjectType() {
        return OVAL;
    }

}

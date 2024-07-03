package com.geometry.service.shape.mangament.impl;

import com.geometry.api.model.request.ShapeRequest;
import com.geometry.common.enums.ShapeType;
import com.geometry.service.shape.mangament.ShapeManagementService;
import com.geometry.service.model.ShapeBO;
import com.geometry.service.shape.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShapeManagementServiceImpl implements ShapeManagementService {

    @Autowired
    private final List<ShapeService> shapeServices = new ArrayList<>();
    private final Map<ShapeType, ShapeService> shapeServiceByType = new HashMap<>();

    @PostConstruct
    void init() {
        shapeServices.forEach(shapeService -> shapeServiceByType.put(shapeService.getType(), shapeService));
    }

    public ShapeBO convertToShapeBO(ShapeRequest shapeRequest) {
        return shapeServiceByType.get(shapeRequest.getShapeType()).convertToShapeBO(shapeRequest);
    }
}

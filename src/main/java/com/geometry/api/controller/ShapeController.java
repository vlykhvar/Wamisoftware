package com.geometry.api.controller;

import com.geometry.api.converter.ShapeConverter;
import com.geometry.api.model.request.ShapeRequest;
import com.geometry.api.model.response.ServiceResponseBody;
import com.geometry.api.model.response.ShapeResponse;
import com.geometry.common.enums.ObjectType;
import com.geometry.service.shape.mangament.ShapeManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shapes")
public class ShapeController {

    private static final Logger LOG = LoggerFactory.getLogger(ShapeController.class);
    private static final Map<ObjectType, ShapeConverter> RESPONSE_CLASS_BY_TYPE = new HashMap<>();

    @Autowired
    private ShapeManagementService shapeManagementService;

    @Autowired
    private List<ShapeConverter> shapeConverters;

    @PostConstruct
    private void init() {
        shapeConverters.forEach(shapeConverter -> RESPONSE_CLASS_BY_TYPE.put(shapeConverter.getType(), shapeConverter));
    }

    @Operation(summary = "${shapes.calculation.summary}", description = "${shapes.calculation.description}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${shapes.calculation.response.ok}",
                    content = @Content(schema = @Schema(implementation = ShapeResponse.class))),
            @ApiResponse(responseCode = "5xx", description = "${common-5xx-message}",
                    content = @Content(schema = @Schema(implementation = ServiceResponseBody.class)))
    })
    @PutMapping
    public ShapeResponse calculateShapeAreaAndPerimeter(@Valid @RequestBody ShapeRequest shapeRequest) {
        LOG.info("Start calculation area and perimeter for: {}", shapeRequest.getShapeType());
        var shapeBO = shapeManagementService.convertToShapeBO(shapeRequest);
        return RESPONSE_CLASS_BY_TYPE.get(shapeBO.getObjectType()).toShapeResponse(shapeBO);
    }
}

package com.learning.springboot.controller;


import com.learning.springboot.dao.UnionRepository;
import com.learning.springboot.entities.Union;
import com.learning.springboot.utilities.constants.ErrorResponseMessage;
import com.learning.springboot.utilities.exceptions.RecordNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = {"/Union"})
@Tag(name = "Union Management", description = "This Section will have all union related apis")
public class UnionController {


    private final UnionRepository unionRepository;

    public UnionController(UnionRepository unionRepository) {
        this.unionRepository = unionRepository;
    }

    @PostMapping(path = {"/createUnion"}, consumes = {"application/json"}, produces = "application/json")
    @Operation(summary = "createUnion", description = "this api help to add new record of the union")
    public Union createUnion(@Valid @RequestBody Union unionPayload) {
        return unionRepository.save(unionPayload);
    }


    @GetMapping(path = {"/retrieveAllUnion"}, consumes = {"application/json"}, produces = "application/json")
    @Operation(summary = "retrieveAllUnion", description = "this api help to retrieve all list of union")
    public List<Union> retrieveAllUnion() {
        return unionRepository.findAll();
    }


    @GetMapping(path = {"/retrieveUnionById/{id}"}, consumes = {"application/json"}, produces = "application/json")
    @Operation(summary = "retrieveUnionById", description = "this api help to retrieve one union by union ID")
    public Union retrieveUnionById(@PathVariable Long id) {
        return unionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(
                        ErrorResponseMessage.format(ErrorResponseMessage.USER_IS_NOT_EXIST, "union"))
                );
    }


}

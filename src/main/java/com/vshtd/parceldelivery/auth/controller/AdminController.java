package com.vshtd.parceldelivery.auth.controller;

import com.vshtd.parceldelivery.auth.model.dto.ProfileRespDTO;
import com.vshtd.parceldelivery.auth.service.AdminServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@Tag(name = "Admin", description = "admin API")
public class AdminController {

    @Autowired
    private AdminServiceImpl userService;

    @GetMapping("/{username}")
    @Operation(summary = "get profile by username")
    public ProfileRespDTO get(@PathVariable(name = "username") String username) {
        return userService.get(username);
    }

    @GetMapping("/all")
    @Operation(summary = "get all orders")
    public List<ProfileRespDTO> getAllUser() {
        return userService.all();
    }
}


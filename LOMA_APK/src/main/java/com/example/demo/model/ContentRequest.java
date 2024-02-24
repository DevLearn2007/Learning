package com.example.demo.model;

import jakarta.validation.constraints.NotNull;

public record ContentRequest(@NotNull String content) {
	

}

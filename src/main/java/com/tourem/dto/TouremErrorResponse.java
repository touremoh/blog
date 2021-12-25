package com.tourem.dto;

public record TouremErrorResponse<T>(T error, int status) {
}

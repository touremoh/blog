package com.tourem.dto;

public record TouremApiResponse<T>(T data, int status) { }

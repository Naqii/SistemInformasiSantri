package com.example.sis.data.api

class ApiResponse<T>(val status: StatusResponse?, val body: T?, val  message: String?) {
    companion object {
        fun <T> success(body: T?): ApiResponse<T> {
            return ApiResponse(StatusResponse.SUCCESS, body, null)
        }

        fun <T> loading(message: String, body: T?): ApiResponse<T> {
            return ApiResponse(StatusResponse.EMPTY, body, message)
        }

        fun <T> error(message: String, body: T?): ApiResponse<T> {
            return ApiResponse(StatusResponse.ERROR, body, message)
        }
    }

}

enum class StatusResponse{
    SUCCESS,
    EMPTY,
    ERROR
}
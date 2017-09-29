package holiday.asu.systemheating.service

class ServiceResult<T> {
    val exception: Throwable?
    val result: T?
    val isSuccessful: Boolean

    constructor(exception: Throwable) {
        this.exception = exception
        isSuccessful = false
        result = null
    }

    constructor(result: T) {
        exception = null
        isSuccessful = true
        this.result = result
    }
}
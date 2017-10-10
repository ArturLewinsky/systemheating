package holiday.asu.systemheating.service

import android.support.annotation.Nullable
import holiday.asu.systemheating.model.Status


class Response<T> {

    val status: Status

    @Nullable
    val data: T

    @Nullable
    val error: Throwable

    constructor(status: Status, data: T?, error: Throwable?) {
        this.status = status
        this.data = data!!
        this.error = error!!
    }

    companion object {
        fun <T> success(data: T): Response<T> {
            return Response(Status.SUCCESS, data, null)
        }

        fun <T> error(error: Throwable): Response<T> {
            return Response(Status.ERROR, null, error)
        }
    }
}

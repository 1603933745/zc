package com.example.myapplication1219.net

import com.example.myapplication1219.pinglun.enity.Comment
import com.example.myapplication1219.pinglun.enity.Login
import com.example.myapplication1219.pinglun.enity.NewS
import com.example.myapplication1219.pinglun.enity.Shipin
import com.example.myapplication1219.pinglun.enity.Type
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @GET("/api/nt/all")
    fun gettype(): Observable<Type>

    @GET("/api/news/page")
    fun getnews(
        @Query("type") type: Int,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Observable<NewS>

    @POST("/user/loginjson")
    fun login(@Body user: RequestBody): Observable<Login>

    @GET("/comment/getCommentByVideoId")
    fun getpinglun(
        @Query("videoId") id: Int,
    ): Observable<Comment>

    @POST("/comment/comment")
    fun fapinglun(@Body body: RequestBody): Observable<Comment>

    @GET("/api/video/page")
    fun getvideo(
        @Query("order") order: Int,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Observable<Shipin>
}